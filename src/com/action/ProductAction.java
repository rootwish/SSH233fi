package com.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

//import com.service.ManageService;
import com.domain.Product;
import com.domain.ProductType;
import com.service.ManageService;
import com.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class ProductAction extends ActionSupport{
	
	//��ƷID
	private String objId;
	
	//��Ʒ���
	private String productId;
	
	//С����
	private String productTypeName;
	
	//������
	private String classifyType;
	
	//С����
	private String typeName;
	
	//��Ʒר������
	private String theTheme; 
	
	//ȫ��ҳ��
	private int totalPage;	
	
	//ҳ��
	private int pageNumber=0;	 
	
	//ҳ����ʾ�Ĳ�Ʒ������ʼΪ4��
	private int pageSize=4;	 
	
	//��ҳ��ѯ�����в�Ʒ
	private List<Product> allProducts;
	
	//��Ʒ�������
	private ProductService productService;
	
	//�����߷������
	private ManageService manageService;
	
	//��ӷ���ʱ��ʶ�����ͣ�1Ϊ��Ӵ��࣬2Ϊ���С��
	private String type;
	
	//�������Ϣ
	private String message;
	
	//����·��
	private String path;
	
	//��Ʒ������
	private String keyword;
	
	//����ר�ⵥ��С��������в�Ʒ
	private Set Products= new HashSet();
	
	//��Ʒ����ӳ�伯��
	private Map<String,String> typeNameMap = new HashMap<String,String>();

	public String getClassifyType() {
		return classifyType;
	}
	public void setClassifyType(String classifyType) {
		this.classifyType = classifyType;
	}
	public String getTypeName() {
		return typeName;
	}
	public String getObjId() {
		return objId;
	}
	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	
	//��Ʒ�б�(Action)
	public String product() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		productId = request.getParameter("productId");     //��ȡ��ҳ�洫������Ʒ��ţ�Ĭ��Ϊnull
		
		try
		{
			productTypeName = new String(request.getParameter("productTypeName").getBytes("ISO8859-1"),"GB2312"); //��ȡ��ҳ�洫����С������������ת����Ĭ��Ϊnull
		}catch (Exception e){}
	
		//��ҳ�����ʱ��ҳ��û�д����κ�ֵ��
		if(productId == null && productTypeName == null){
			ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
			List<Product> product = (List<Product>)application.getAttribute("product");  //�ӷ�����application�������ȡ������Ʒ
			if(product == null){
				product = productService.findProduct("����",10);
				application.setAttribute("product", product);
			}
				request.setAttribute("allflower", product);
				return "index";
		}
		//ҳ�洫����Ʒ���
		else if(productId != null){
			Product AProduct = productService.findAProduct(productId);
			if(AProduct != null)
			request.setAttribute("aProduct", AProduct);
			return "aProduct";
		}
		//ҳ�洫��С����
		else {
			List list = productService.findProductTypeByTypeName(productTypeName);
			if(list != null && !list.isEmpty()){
			ProductType productType = (ProductType)list.get(0);
			request.setAttribute("productByTypeName", productType.getProduct());
			productType = null;
			}
			list = null;
			return "productByTypeName";
		}
	}
	
	//��ѯ�²�Ʒ(Action)
	public String newProduct() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		List<Product> newproduct = (List<Product>)application.getAttribute("newproduct");		
		if(newproduct == null){
			newproduct = productService.findNewProduct();
			application.setAttribute("newproduct", newproduct);
		}	
		request.setAttribute("newflowers", newproduct);
		return null;
	}
	
	//����ƥ���Ӧ�����ж�
	public boolean checkTheme(String theTheme,Map<String,String> typeNameMap){
		Boolean flag = false;
		String str="";
		Iterator keys = typeNameMap.keySet().iterator();
		while(keys.hasNext()){
			str =(String)keys.next();
			if(str.equals(theTheme)){
				flag = true;
			}
		} 
		return flag;
	}
	
	//��ʼ������Mapӳ�䷽��
	public void CreateMap(int pageNumber){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNumber==0){
			List<ProductType> productTypeList = productService.listProductType();
			if(!productTypeList.isEmpty()){			
				for(ProductType productType:productTypeList){
					typeNameMap.put(productType.getTypeName().trim(),productType.getTypeName().trim());
				}
				typeNameMap.put("�ʻ�","�ʻ�");
				session.setAttribute("typeNameMap",typeNameMap);
			}
		}else{
			typeNameMap=(Map<String,String>)session.getAttribute("typeNameMap");
		}
	}
	
	//���Զ���һС����Ĳ�Ʒ���з�ҳ��ѯ(��Ҫ��С�����������)(Action)
	public String themeProduct() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		productId = request.getParameter("productId");
		if(productId != null&&!productId.trim().equals("")){ //��ʾĳһ��Ʒ��ϸ��Ϣ
			theTheme="";
			Product aProduct = productService.findAProduct(productId);
			if(aProduct!=null){
				request.setAttribute("aProduct", aProduct);
				return "aProduct";
			}else
				return null;			
		}else{
			theTheme = new String(request.getParameter("theTheme").getBytes("ISO8859-1"),"GB2312");		
		}
		String pageNumberStr = request.getParameter("pageNumber");			
		CreateMap(pageNumber);//��ʼ������Mapӳ��			
		if(theTheme!=null&&checkTheme(theTheme.trim(),typeNameMap)){
			productTypeName = theTheme.trim();
		}else{
			productTypeName = "";
		}
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		int[] paging = new int[2];
		int productAmount;
		List<Product> subList=new ArrayList<Product>();
		if(productTypeName!=null&&!productTypeName.equals("")){
			if(!productTypeName.equals("�ʻ�")){  //���ʻ�ר��
				ProductType productType = new ProductType();
				if(pageNumber==0){
					productType = (ProductType)productService.findProductTypeByTypeName(productTypeName).get(0);
					session.setAttribute("productType", productType);			
				}else{
					productType = (ProductType)session.getAttribute("productType");
				}
				Set<Product> pSet= (Set<Product>)productType.getProduct();
				productAmount=productType.getProduct().size();		
				if(!pSet.isEmpty()){
					allProducts = new ArrayList<Product>();
					for(Product p:pSet){    //Set����ת��ΪList����
						if(p.getProductState()==1){  //ȡ������״̬�Ĳ�Ʒ
							allProducts.add(p);
						}
					}
				}
				paging = productService.pageNumber(productAmount, pageNumberStr, pageSize);
				pageNumber = paging[0];
				totalPage = paging[1];					
				Integer Page=Integer.parseInt(pageNumberStr);
				int j=allProducts.size()-1-pageSize*(Page-1);		
				for(int ipage=0;ipage<pageSize;ipage++){
					if(j>=0){
						Product product = allProducts.get(j);
						subList.add(product);
						j--;
					}
				}
				request.setAttribute("ThemeProduct",subList);
				return theTheme;
			}else{                          //�ʻ�ר��
				pageSize=16;					
				if(pageNumber==0){
					allProducts = productService.findProduct("����",1000);
					session.setAttribute("allProducts", allProducts);
				}else{
				    allProducts= (List<Product>)session.getAttribute("allProducts");
				}
				productAmount=allProducts.size();
				paging = productService.pageNumber(productAmount, pageNumberStr, pageSize);
				pageNumber = paging[0];
				totalPage = paging[1];
				Integer Page=Integer.parseInt(pageNumberStr);
				int j=allProducts.size()-1-pageSize*(Page-1);		
				for(int ipage=0;ipage<pageSize;ipage++){
					if(j>=0){
						Product product = allProducts.get(j);
						subList.add(product);
						j--;
					}
				}		
				request.setAttribute("ThemeProduct", subList);				
				return theTheme;
			}
		}
		else{
			return null;
		}		
	}
	
	//����ר��(Action)
	public void FestivalThemeAction(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> allFestivalType = (List<String>)productService.findTypeNameByProductClassifyType("����");
		Map<String,Set> festival = new HashMap<String,Set>();
		Iterator it = allFestivalType.iterator();										
		while(it.hasNext()){
			String typeName = (String)it.next();
			List<ProductType> allType = (List<ProductType>)productService.findProductTypeByTypeName(typeName);
			for(ProductType pt:allType){
				Products = pt.getProduct(); //Set��ֵ
			}
			festival.put(typeName,Products); //Map��ֵ
		}
		request.setAttribute("festival",festival);
	}
	
	//��Ʒ����(Action)
	public String productType() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext(); 
		Map<String, List> productType = (Map)application.getAttribute("productType");
		if(productType == null){
			productType = productService.findProductType();
			application.setAttribute("productType", productType);
		}
		request.setAttribute("TypeName", productType);
		request.setAttribute("productType", productType.keySet());
		return null;
	}
	
	//��������
	public void BuyRanking (){
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		List listRanking = (List)application.getAttribute("listRanking");
		if(listRanking==null || listRanking.isEmpty()){
			listRanking = productService.findMostPopularProduct();
			application.setAttribute("listRanking",listRanking);
		}
		request.setAttribute("listBuyRanking", listRanking);
	}
	
	//�ʻ�����(����˵Ļ�)
	public void CheapestProductRanking(){
		HttpServletRequest request = ServletActionContext.getRequest();
		ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
		List cheapestRanking = (List)application.getAttribute("cheapestRanking");
		if(cheapestRanking==null || cheapestRanking.isEmpty()){
			cheapestRanking = productService.findCheapestProduct();
			application.setAttribute("cheapestRanking",cheapestRanking);
		}
		request.setAttribute("cheapestRanking", cheapestRanking);
	}
	
	//��ѯ���в�Ʒ������(Action)
	public void allProductType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List allType = productService.findAllProductClassifyType();
		request.setAttribute("allType", allType);	
	}
	//��ѯ���в�ƷС����(Action)
	public void listProductType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List allType = productService.listProductType();
		request.setAttribute("allType", allType);
	}
	// ��Ӳ�Ʒ����(Action)
	public String addProductType(){
		ProductType productType = new ProductType();
		//��Ӵ���
		if(type.equals("1")){
			if(productService.findProductTypeByClassifyType(classifyType).isEmpty())
			{
			productType.setClassifyType(classifyType);
			productType.setTypeName(typeName);
		//	manageService.save(productType);
			}else {
				this.setMessage("���ʧ��!�Ѵ��ڴ��ࣺ"+classifyType);
				this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
				return "succeed";
			}
		}
		//���С��
		if(type.equals("2")){
		if(productService.findProductTypeByTypeName_ClassifyType(classifyType, typeName).isEmpty()){				
			List<ProductType> productTypeList = productService.findProductTypeByTypeName_ClassifyType(classifyType, "");
			if(!productTypeList.isEmpty()){
			productType = (ProductType)productTypeList.get(0);
			productType.setTypeName(typeName);
			manageService.update(productType);
			}
			else {
				productType.setClassifyType(classifyType);
				productType.setTypeName(typeName);
			//	manageService.save(productType);
			}
		}else {
			this.setMessage("���ʧ��!�ڴ��ࣺ" + classifyType + "�Ѵ���С�ࣺ" + typeName);
			this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
			return "succeed";
		}
		}
		this.setMessage("��ӳɹ�!");
		this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
		return "succeed";
	}
	//ɾ����Ʒ����(Action)
	public String deleteProductType(){
		ProductType productType = productService.findProductTypeByObjId(Integer.parseInt(objId));
		manageService.delete(productType);
		this.setMessage("ɾ���ɹ�!");
		this.setPath("manage/manage_jsp/general_manager/manage_listProductType.jsp");
		return "succeed";
	}
	
	//ģ��������Ʒ��Action��
	public String searchingProduct(){
		HttpServletRequest request = ServletActionContext.getRequest();
		keyword = request.getParameter("keyword");
		keyword = keyword.trim();
		if(keyword.length()>0){
			 List<Product> products = (List<Product>) productService.searchingProduct(keyword);
			 if(!products.isEmpty()){
				 request.setAttribute("products", products);
				 return "success";	
			 }else{
				 return "input";
			 }			 			 		 
		}else{
			return "input";	
		}				
	}
	
	
}
