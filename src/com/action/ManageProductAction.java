package com.action;


import java.io.File;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;

import com.service.CustomerService;
import com.service.ManageService;
//import com.domain.PriceList;
import com.domain.Product;
import com.domain.ProductType;
import com.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class ManageProductAction extends ActionSupport{
	private ManageService manageService;
	private ProductService productService;
	private CustomerService customerservice;
	private Product product;
	private String productId;
	private String productName;
	private String feature;
	private String description;
	private String meaning;
	private String price;
	private String ordinary;
	private String vip;
	private String productState;
	private String[] typeName; 
	private String objId;
	private Integer productAmount;

	private int totalPage;	 //全部页数
	private int pageNumber;	 //页码
	private int pageSize=12; //页面显示的产品数量初始为12个
	private List<Product> allProducts; //分页查询的所有产品
	
	private String message;
	private String path;

	private List<File> myFile = new ArrayList<File>();	
	private List<String> contentType = new ArrayList<String>();
	private List<String> myFileFileName = new ArrayList<String>();	//文件名
	private List<String> imageFileName = new ArrayList<String>();
	
	private File myFile1;
	private File myFile2;
	private String myFile1FileName;
	private String myFile2FileName;

	public void setManageService(ManageService manageService) {
		this.manageService = manageService;
	}
	
	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getFeature() {
		return feature;
	}

	public void setFeature(String feature) {
		this.feature = feature;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeaning() {
		return meaning;
	}

	public void setMeaning(String meaning) {
		this.meaning = meaning;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getOrdinary() {
		return ordinary;
	}

	public void setOrdinary(String ordinary) {
		this.ordinary = ordinary;
	}

	public String getVip() {
		return vip;
	}

	public void setVip(String vip) {
		this.vip = vip;
	}

	public String getProductState() {
		return productState;
	}

	public void setProductState(String productState) {
		this.productState = productState;
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

	public String[] getTypeName() {
		return typeName;
	}

	public void setTypeName(String[] typeName) {
		this.typeName = typeName;
	}

	public List<File> getMyFile() {
		return myFile;
	}

	public File getMyFile1() {
		return myFile1;
	}

	public void setMyFile1(File myFile1) {
		this.myFile1 = myFile1;
	}

	public File getMyFile2() {
		return myFile2;
	}

	public void setMyFile2(File myFile2) {
		this.myFile2 = myFile2;
	}

	public String getMyFile1FileName() {
		return myFile1FileName;
	}

	public void setMyFile1FileName(String myFile1FileName) {
		this.myFile1FileName = myFile1FileName;
	}

	public String getMyFile2FileName() {
		return myFile2FileName;
	}

	public void setMyFile2FileName(String myFile2FileName) {
		this.myFile2FileName = myFile2FileName;
	}

	public void setMyFile(List<File> myFile) {
		this.myFile = myFile;
	}

	public List<String> getContentType() {
		return contentType;
	}

	public void setContentType(List<String> contentType) {
		this.contentType = contentType;
	}

	public List<String> getMyFileFileName() {
		return myFileFileName;
	}

	public void setMyFileFileName(List<String> myFileFileName) {
		this.myFileFileName = myFileFileName;		
	}
	

	public List<String> getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(List<String> imageFileName) {
		this.imageFileName = imageFileName;
	}

	private static String getExtention(String fileName) {
		int pos = fileName.lastIndexOf(".");
		return fileName.substring(pos);
	}
	
	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
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
	
	//增加产品
	public String addProduct() {
		
		product.setProductId(productId);
		product.setProductName(productName);
		product.setDescription(description);
		product.setFeature(feature);
		product.setMeaning(meaning);
		//product.setPrice(Double.parseDouble(price));
		//product.setProductState(Integer.parseInt(productState));
		
		//图片处理
		if(myFile != null){
			for (int i = 0; i < myFile.size(); i++) {
				String fileName = new Date().getTime()+ getExtention(this.getMyFileFileName().get(i));
				String url = "";
				if(i==0)
					{
					url = ServletActionContext.getRequest().getRealPath("images/smallImg");
					product.setSmallImg(fileName);
					}
				if(i==1) 
					{
					url = ServletActionContext.getRequest().getRealPath("images/Flower_BigSize");
					product.setBigImg(fileName);
					}
				File imageFile = new File(url,fileName);//得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)	
			 //把图片写入到上面设置的路径里
				try {
					FileUtils.copyFile(myFile.get(i), imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		}
		
		//分类处理
		for(int i = 0 ; i< typeName.length ; i++){
			if(!typeName[i].equals("") && typeName[i] != null)
			{	ProductType productType = (ProductType)productService.findProductTypeByTypeName(typeName[i]).get(0);
				product.getProductType().add(productType);
			}
		}
		//价格处理
//		CustomerType customerType;
//		PriceList priceList1 = new PriceList();
//		customerType = customerservice.getCustomerTypeExample("普通");
//		priceList1.setTheProduct(product);
//		priceList1.setTheCustomerType(customerType);
//		priceList1.setRealPrice(Double.parseDouble(ordinary));
//		PriceList priceList2 = new PriceList();
//		customerType = customerservice.getCustomerTypeExample("VIP");
//		priceList2.setTheProduct(product);
//		priceList2.setTheCustomerType(customerType);
//		priceList2.setRealPrice(Double.parseDouble(vip));
//		product.getPriceList().add(priceList2);
//		product.getPriceList().add(priceList1);
		
		manageService.save(product);
	
		this.setMessage("添加成功!");
		this.setPath("manage/manage_addProduct.jsp");
		return "succeed";
	}
	
	//修改产品
	public String updateProduct(){
		product = manageService.findProductById(Integer.parseInt(objId));
		product.setProductName(productName);
		product.setDescription(description);
		product.setFeature(feature);
		product.setMeaning(meaning);
		product.setPrice(Double.parseDouble(price));
		//product.setProductState(Integer.parseInt(productState));
		
		//分类处理
		Set<ProductType> productTypeSet = new HashSet();
		for(int i = 0 ; i< typeName.length ; i++){
			if(!typeName[i].equals("") && typeName[i] != null)
			{
				ProductType productType = (ProductType)productService.findProductTypeByTypeName(typeName[i]).get(0);
				productTypeSet.add(productType);
			}
		}
		product.setProductType(productTypeSet);
		
		//价格处理
//		Set<PriceList> priceListSet = product.getPriceList();
//		Iterator iterator = priceListSet.iterator();
//		while (iterator.hasNext()){
//			PriceList priceList = (PriceList)iterator.next();
//			if(priceList.getTheCustomerType().getTypeName().trim().equals("普通")){
//				priceList.setRealPrice(Double.parseDouble(ordinary));
//			}
//			if(priceList.getTheCustomerType().getTypeName().trim().equals("VIP")){
//				priceList.setRealPrice(Double.parseDouble(vip));
//			}
//		}
		
		//图片处理
		if(myFile1 != null){
			
				String fileName1 = new Date().getTime()+ getExtention(this.getMyFile1FileName());
				String url = "";
				
					url = ServletActionContext.getRequest().getRealPath("images/smallImg");
					product.setSmallImg(fileName1);
				File imageFile = new File(url,fileName1);//得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)	
			 //把图片写入到上面设置的路径里
				try {
					FileUtils.copyFile(myFile1, imageFile);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}			
		
		if(myFile2 != null){
			
			String fileName2 = new Date().getTime()+ getExtention(this.getMyFile2FileName());
			String url = "";
			
			url = ServletActionContext.getRequest().getRealPath("images/Flower_BigSize");
			product.setBigImg(fileName2);
			File imageFile = new File(url,fileName2);//得到图片保存的位置(根据root来得到图片保存的路径在tomcat下的该工程里)	
		 //把图片写入到上面设置的路径里
			try {
				FileUtils.copyFile(myFile2, imageFile);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}		
		
		manageService.update(product);
		this.setMessage("修改成功!");
		this.setPath("findAProdictInfoAction.action?objId="+ objId);
		return "succeed";
	}
	
	//删除产品
	public String deleteProduct(){
		product = manageService.findProductById(Integer.parseInt(objId));
		manageService.delete(product);
		return "succeed";
	}
	
	//查询一个产品所有信息
	public String findAProductInfo(){
		HttpServletRequest request = ServletActionContext.getRequest();
		product = manageService.findProductById(Integer.parseInt(objId));
		request.setAttribute("updateAProduct", product);
		return "success";
	}
	
	//所有鲜花分页查询方法
	public String ListAllProducts(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		String pageNumberStr = request.getParameter("pageNumber");
		
		if(pageNumberStr == null || "".equals(pageNumberStr.trim())){
			pageNumberStr = "1";
		}
		int[] paging = new int[2];
		int productAmount;
		List<Product> subList=new ArrayList<Product>();
		if(pageNumber==0){
			allProducts = productService.findProduct("所有",1000);//只需查询一次
			session.setAttribute("allProducts", allProducts);
	    }else{
	    	allProducts= (List<Product>)session.getAttribute("allProducts");
	    }
		productAmount=allProducts.size();
		paging = productService.pageNumber(productAmount, pageNumberStr, pageSize);
		pageNumber = paging[0];
		totalPage = paging[1];
	//	productBypage = productService.findProductByPage(0, pageNumber, pageSize,0);
		Integer Page=Integer.parseInt(pageNumberStr);
		int j=allProducts.size()-1-pageSize*(Page-1);		
		for(int ipage=0;ipage<pageSize;ipage++){
			if(j>=0){
				Product product = allProducts.get(j);
				subList.add(product);
				j--;
			}
		}		
		request.setAttribute("AllProducts",subList);
		request.setAttribute("pageNumber",pageNumber);
		request.setAttribute("totalPage",totalPage);
	//	this.setPath("manage/manage_jsp/general_manager/manage_listProduct.jsp");
	//	return "succeed";
		return SUCCESS;
	}
}
