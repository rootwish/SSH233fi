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
	
	//商品ID
	private String objId;
	
	//商品编号
	private String productId;
	
	//小类名
	private String productTypeName;
	
	//大类名
	private String classifyType;
	
	//小类名
	private String typeName;
	
	//产品专题类型
	private String theTheme; 
	
	//全部页数
	private int totalPage;	
	
	//页码
	private int pageNumber=0;	 
	
	//页面显示的产品数量初始为4个
	private int pageSize=4;	 
	
	//分页查询的所有产品
	private List<Product> allProducts;
	
	//商品服务对象
	private ProductService productService;
	
	//管理者服务对象
	private ManageService manageService;
	
	//添加分类时的识别类型，1为添加大类，2为添加小类
	private String type;
	
	//填出框信息
	private String message;
	
	//返回路径
	private String path;
	
	//商品搜索词
	private String keyword;
	
	//节日专题单个小分类的所有产品
	private Set Products= new HashSet();
	
	//产品种类映射集合
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
	
	//产品列表(Action)
	public String product() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		productId = request.getParameter("productId");     //获取从页面传来的商品编号，默认为null
		
		try
		{
			productTypeName = new String(request.getParameter("productTypeName").getBytes("ISO8859-1"),"GB2312"); //获取从页面传来的小类名，做编码转换，默认为null
		}catch (Exception e){}
	
		//主页面加载时（页面没有传来任何值）
		if(productId == null && productTypeName == null){
			ServletContext application = ServletActionContext.getRequest().getSession().getServletContext();
			List<Product> product = (List<Product>)application.getAttribute("product");  //从服务器application容器里获取所有商品
			if(product == null){
				product = productService.findProduct("在售",10);
				application.setAttribute("product", product);
			}
				request.setAttribute("allflower", product);
				return "index";
		}
		//页面传来商品编号
		else if(productId != null){
			Product AProduct = productService.findAProduct(productId);
			if(AProduct != null)
			request.setAttribute("aProduct", AProduct);
			return "aProduct";
		}
		//页面传来小类名
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
	
	//查询新产品(Action)
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
	
	//主题匹配对应分类判断
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
	
	//初始化种类Map映射方法
	public void CreateMap(int pageNumber){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		if(pageNumber==0){
			List<ProductType> productTypeList = productService.listProductType();
			if(!productTypeList.isEmpty()){			
				for(ProductType productType:productTypeList){
					typeNameMap.put(productType.getTypeName().trim(),productType.getTypeName().trim());
				}
				typeNameMap.put("鲜花","鲜花");
				session.setAttribute("typeNameMap",typeNameMap);
			}
		}else{
			typeNameMap=(Map<String,String>)session.getAttribute("typeNameMap");
		}
	}
	
	//可以对任一小种类的产品进行分页查询(需要传小种类的类型名)(Action)
	public String themeProduct() throws Exception{
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		productId = request.getParameter("productId");
		if(productId != null&&!productId.trim().equals("")){ //显示某一产品详细信息
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
		CreateMap(pageNumber);//初始化种类Map映射			
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
			if(!productTypeName.equals("鲜花")){  //非鲜花专题
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
					for(Product p:pSet){    //Set集合转化为List集合
						if(p.getProductState()==1){  //取出在售状态的产品
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
			}else{                          //鲜花专题
				pageSize=16;					
				if(pageNumber==0){
					allProducts = productService.findProduct("在售",1000);
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
	
	//节日专题(Action)
	public void FestivalThemeAction(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List<String> allFestivalType = (List<String>)productService.findTypeNameByProductClassifyType("节日");
		Map<String,Set> festival = new HashMap<String,Set>();
		Iterator it = allFestivalType.iterator();										
		while(it.hasNext()){
			String typeName = (String)it.next();
			List<ProductType> allType = (List<ProductType>)productService.findProductTypeByTypeName(typeName);
			for(ProductType pt:allType){
				Products = pt.getProduct(); //Set赋值
			}
			festival.put(typeName,Products); //Map赋值
		}
		request.setAttribute("festival",festival);
	}
	
	//产品类型(Action)
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
	
	//购买排行
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
	
	//鲜花哄抢(最便宜的花)
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
	
	//查询所有产品大种类(Action)
	public void allProductType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List allType = productService.findAllProductClassifyType();
		request.setAttribute("allType", allType);	
	}
	//查询所有产品小种类(Action)
	public void listProductType(){
		HttpServletRequest request = ServletActionContext.getRequest();
		List allType = productService.listProductType();
		request.setAttribute("allType", allType);
	}
	// 添加产品种类(Action)
	public String addProductType(){
		ProductType productType = new ProductType();
		//添加大类
		if(type.equals("1")){
			if(productService.findProductTypeByClassifyType(classifyType).isEmpty())
			{
			productType.setClassifyType(classifyType);
			productType.setTypeName(typeName);
		//	manageService.save(productType);
			}else {
				this.setMessage("添加失败!已存在大类："+classifyType);
				this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
				return "succeed";
			}
		}
		//添加小类
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
			this.setMessage("添加失败!在大类：" + classifyType + "已存在小类：" + typeName);
			this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
			return "succeed";
		}
		}
		this.setMessage("添加成功!");
		this.setPath("manage/manage_jsp/general_manager/manage_addProductType.jsp");
		return "succeed";
	}
	//删除产品类型(Action)
	public String deleteProductType(){
		ProductType productType = productService.findProductTypeByObjId(Integer.parseInt(objId));
		manageService.delete(productType);
		this.setMessage("删除成功!");
		this.setPath("manage/manage_jsp/general_manager/manage_listProductType.jsp");
		return "succeed";
	}
	
	//模糊搜索产品（Action）
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
