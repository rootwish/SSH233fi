package com.action;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import com.domain.Customer;

import com.service.CustomerService;

import com.domain.Consignee;
import com.domain.Order;
//import com.onlineflowershop.order.model.Payment;
//import com.onlineflowershop.order.model.PaymentType;
import com.service.OrderService;
import com.domain.Product;
import com.service.ProductService;
import com.opensymphony.xwork2.ActionSupport;

public class OrderAction extends ActionSupport{
	private String num;
	private String name;
	private String oldname;
	private String mobilePhone;
	private String officePhone;
	private String homePhone;
	private String streetName;
	private String roadName;
	private String doorNumber;
	private String zipCode;
	private String email;
	private String qqNumber;
	private String ConsigneeArea;
	private OrderService orderService;
	private Consignee consignee;
	private Order order;
	private Customer customer;
	private CustomerService customerservice;
	//private Area area;
	private String objId;
	private String[] consigneeNum;
	private List<Product> shoppingCart = new ArrayList<Product>();
	private ProductService productService;
	
	private static final Integer unpayedOrderState=1;//设置未付款订单的状态为1
	
	

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public void setOrderService(OrderService orderService) {
		this.orderService = orderService;
	}
	
	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public void setCustomerservice(CustomerService customerservice) {
		this.customerservice = customerservice;
	}

	public void setConsignee(Consignee consignee) {
		this.consignee = consignee;
	}
	
	public void setOrder(Order order) {
		this.order = order;
	}
	
	public String getObjId() {
		return objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getOldname() {
		return oldname;
	}

	public void setOldname(String oldname) {
		this.oldname = oldname;
	}

	public String getMobilePhone() {
		return mobilePhone;
	}


	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}


	public String getConsigneeArea() {
		return ConsigneeArea;
	}


	public void setConsigneeArea(String consigneeArea) {
		ConsigneeArea = consigneeArea;
	}
	public String getOfficePhone() {
		return officePhone;
	}

	public void setOfficePhone(String officePhone) {
		this.officePhone = officePhone;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public void setHomePhone(String homePhone) {
		this.homePhone = homePhone;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getRoadName() {
		return roadName;
	}

	public void setRoadName(String roadName) {
		this.roadName = roadName;
	}

	public String getDoorNumber() {
		return doorNumber;
	}

	public void setDoorNumber(String doorNumber) {
		this.doorNumber = doorNumber;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQqNumber() {
		return qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	public String[] getConsigneeNum() {
		return consigneeNum;
	}

	public void setConsigneeNum(String[] consigneeNum) {
		this.consigneeNum = consigneeNum;
	}

	
				
	public String CreateConsignee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		customer=(Customer)session.getAttribute("customer");
		
		//area = (Area)orderService.findOneArea(ConsigneeArea).get(0);
		if(session.getAttribute("consignee")!=null)
			session.removeAttribute("consignee");
		consignee.setName(name);		
		consignee.setMobilePhone(mobilePhone);
//		consignee.setOfficePhone(officePhone);
//		consignee.setHomePhone(homePhone);
		consignee.setStreetName(streetName);
		consignee.setRoadName(roadName);
//		consignee.setDoorNumber(doorNumber);
//		consignee.setZipCode(Integer.parseInt(zipCode));
//		consignee.setQqNumber(qqNumber);
//		consignee.setEmail(email);
		consignee.setTheCustomer(customer);
		//consignee.setTheArea(area);
		session.setAttribute("consignee",consignee);
		orderService.add(consignee);
		
		return SUCCESS;
	}
	
	public String CreateOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		consignee= (Consignee)session.getAttribute("consignee");
		if(consignee!=null){
			//Payment payment=new Payment();
			//PaymentType paymentType = orderService.findAPaymentType("支付宝");
			//payment.setThePaymentType(paymentType);		
			//orderService.add(payment);
			customer = (Customer)session.getAttribute("customer");
			shoppingCart=(List<Product>) session.getAttribute("shoppingCart");
			//CustomerType customerType = customer.getTheCustomerType();
			List<Order> orderlists = new ArrayList<Order>();
				System.out.println(num+"!!!!!!!!!!");
				
				int i = 0;
				List<String> productlist=new ArrayList<String>();
				
//				Iterator iterator = shoppingCart.iterator();
				for(Product product:shoppingCart){
					productlist.add(product.getProductId());
					i++;
					System.out.println(product.getProductId());
				}
//				while (iterator.hasNext()){
//					Product product = (Product)iterator.next();
//					productlist[i]=product.getProductId();
//					System.out.println(productlist[i]+"!!!!!!");
//					i++;
//											}
				//用商品的时候 
				if(productlist!=null){
					
					for(int j = 0;j<productlist.size();j++){
					Product product = productService.findAProduct(productlist.get(j));
//					Set<PriceList> priceList = product.getPriceList();
//					Iterator it = priceList.iterator();
//					while (it.hasNext()){
//						PriceList pList = (PriceList)it.next();
//						if(customerType.getObjId().equals(pList.getTheCustomerType().getObjId())){
//							order.setAmt(Float.parseFloat(pList.getRealPrice().toString()));
		//			}
			//	}	
					order.setTheProduct(product);
					order.setTheCustomer(customer);
					order.setTheConsignee(consignee);
					order.setAmt(Float.parseFloat(num));
					order.setOrderTime(new Date()); 
					order.setOrderState(1);
					orderService.add(order);
					//Order newOrder = (Order)orderService.findOrderById(customer.getObjId(), order.getObjId()).get(0);
					//orderlists.add(newOrder);

									}
							}
				
			request.setAttribute("orderlists", order);
			session.setAttribute("orderlists", order);
			session.removeAttribute("shoppingCart");
			session.removeAttribute("totalOMoney");
			session.removeAttribute("set");
				}
		return SUCCESS;
				
	}
	
	public String DeleteAnOrder(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		customer = (Customer)session.getAttribute("customer");
		Integer Order_objId=Integer.parseInt(request.getParameter("Order_objId"));		
		List<Order> neworderlists = new ArrayList<Order>();
		if(session.getAttribute("orderlists")!=null){
			List<Order> orderlists = (List<Order>)session.getAttribute("orderlists");
			for(int i=0;i<orderlists.size();i++){
				if(!orderlists.get(i).getObjId().equals(Order_objId)){				
					neworderlists.add(orderlists.get(i));				
				}
			}
			Order delOrder = (Order)orderService.findOrderById(customer.getObjId(), Order_objId).get(0);
			orderService.delete(delOrder);
			request.setAttribute("orderlists",neworderlists);
			session.removeAttribute("orderlists");			
			if(neworderlists.isEmpty()){
				neworderlists = null;
			}
			session.setAttribute("orderlists",neworderlists);
			return "delete";
		}else{
			return "input";
		}							
	}
	
	//删除未付款的订单
	public String DelUnpayedOrder(){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		Customer customer=(Customer)session.getAttribute("customer");
		Integer unpayedOrderId=Integer.parseInt(req.getParameter("unpayedOrderId"));
		Order unpayedOrder=(Order)orderService.findOrderById(customer.getObjId(), unpayedOrderId).get(0);
		orderService.delete(unpayedOrder);
		List<Order> unpayedOrderList=orderService.findOrderByOrderState(unpayedOrderState, customer.getObjId());
		req.setAttribute("unpayedOrderList", unpayedOrderList);
		if(unpayedOrderList.isEmpty()){
			addActionError("<tr height='70px'><td align='center' colspan='8'><font color='#BF4D4D'>您好！不存在未付款的订单！ </font></td></tr>");
			return "input";
		}
		return "del";
	}
	
	//从未付款订单页去付款
	public String GoPay(){
		if(objId!=null){
		HttpServletRequest req=ServletActionContext.getRequest();
		HttpSession session=req.getSession();
		Customer customer=(Customer)session.getAttribute("customer");
		Order unpayedOrder=(Order)orderService.findOrderById(customer.getObjId(), Integer.parseInt(objId)).get(0);
//		Payment payment=new Payment();
//		PaymentType paymentType = orderService.findAPaymentType("支付宝");
//		payment.setThePaymentType(paymentType);		
//		orderService.add(payment);
//		unpayedOrder.setThePayment(payment);
		orderService.update(unpayedOrder);
		List<Order> orderlists = new ArrayList<Order>();
		orderlists.add(unpayedOrder);
		session.setAttribute("orderlists", orderlists);
		}
		return "success";
	}
	
	public void findOldConsignee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		
		customer = (Customer)session.getAttribute("customer");
		customer = customerservice.getCustomerExample(customer.getCustomerId());
		Set<Consignee> consignee = customer.getConsignee();
		
		if(consignee.isEmpty()){
			request.setAttribute("error", "您尚无送花记录，不存在历史送花对象！");
		}else
			request.setAttribute("consignee", consignee);
	}
	
	public String SetHistoryConsignee(){
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		customer = (Customer)session.getAttribute("customer");
		Set<Consignee> consignee = customer.getConsignee();
		if(request.getParameter("set")!=null&&request.getParameter("objId")!=null){
			Integer set =Integer.parseInt(request.getParameter("set"));
			Integer objId=Integer.parseInt(request.getParameter("objId").toString());
			Iterator<Consignee> it = consignee.iterator();
			while(it.hasNext()){
				Consignee aconsignee= (Consignee)it.next();
				if(objId.equals(aconsignee.getObjId())){
					Set<Consignee> aConsignee = new HashSet<Consignee>();
					aConsignee.add(aconsignee);
					session.setAttribute("theconsignee", aConsignee);
					session.setAttribute("set", set);
				}
			}
			return "index";
		}else
			return null;
	}
}
