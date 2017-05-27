package com.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

//import com.onlineflowershop.product.model.PriceList;
import com.domain.Product;
import com.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;





public class ShoppingCartAction extends ActionSupport{
	
	private ProductService productService;
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}
	public String execute(){
		
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		

		String productId = request.getParameter("productId");
		List<Product> shoppingCart = new ArrayList<Product>();
		if(session.getAttribute("shoppingCart") == null){
			session.setAttribute("shoppingCart", shoppingCart);
		}
		else{
			shoppingCart = (List<Product>) session.getAttribute("shoppingCart");
		}
		
		int i = 0;
		Iterator iterator = shoppingCart.iterator();
		while (iterator.hasNext()){
			Product product = (Product)iterator.next();
			if(productId.equals(product.getProductId().trim())){
			//	product.setProductAmount(product.getProductAmount()+1);
				i++;
			}
		}
		
		if(i == 0){
			Product product = productService.findAProduct(productId);
			//List<PriceList> price = new ArrayList(product.getPriceList());
			product.setProductAmount(1);
			shoppingCart.add(product);
			
			double totalOMoney = 0;
			double totalVMoney = 0;
			if(session.getAttribute("totalOMoney") == null ){
				session.setAttribute("totalOMoney",product.getPrice());  //普通价合计
				//session.setAttribute("totalVMoney",price.get(1).getRealPrice());  //VIP价合计
			}else{
				//普通价合计
				totalOMoney = (Double) session.getAttribute("totalOMoney");
				totalOMoney += product.getPrice();
				session.removeAttribute("totalOMoney");
				session.setAttribute("totalOMoney", totalOMoney);
				
				//VIP价合计
//				totalVMoney = (Double) session.getAttribute("totalVMoney");
//				totalVMoney += price.get(1).getRealPrice();
//				session.removeAttribute("totalVMoney");
//				session.setAttribute("totalVMoney", totalVMoney);
			}
			session.removeAttribute("shoppingCart");
			session.setAttribute("shoppingCart", shoppingCart);
		}
		try {
			String path = request.getContextPath(); 
			response.sendRedirect(path + "/shoppingCart.jsp");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}
	//移除购物车中商品
	public String deleteShoppingCart(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		HttpSession session = request.getSession();
		Product removeProduct=null;
		String productId = request.getParameter("productId");
		List<Product> shoppingCart = new ArrayList<Product>();
		shoppingCart = (List<Product>) session.getAttribute("shoppingCart");
		Iterator iterator = shoppingCart.iterator();
		while (iterator.hasNext()){
			Product product = (Product)iterator.next();
			if(productId.equals(product.getProductId().trim())){
			//	product.setProductAmount(product.getProductAmount()+1);
				removeProduct=product;
				String money=session.getAttribute("totalOMoney").toString();
				double totalOMoney=Double.parseDouble(money)-product.getPrice();
				session.removeAttribute("totalOMoney");
				session.setAttribute("totalOMoney", totalOMoney);
			}
		}
		shoppingCart.remove(removeProduct);
		session.removeAttribute("shoppingCart");
		session.setAttribute("shoppingCart", shoppingCart);
		return SUCCESS;
	}

	
}
