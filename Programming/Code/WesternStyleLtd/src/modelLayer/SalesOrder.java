package modelLayer;

import controlLayer.CustomerController;

public class SalesOrder {
	private int invoiceId;
	private String date;
	private boolean deliveryStatus;
	private String deliveryDate;
	private float totalPrice;
	private int discount;
	private double deliveryFee;
	private Customer customer;
	
	public SalesOrder(){
		
	}
	
	public SalesOrder(int invoiceId, String date, boolean deliveryStatus, 
			String deliveryDate, float totalPrice, int discount, double deliveryFee){
		
		this.invoiceId = invoiceId;
		this.date = date;
		this.deliveryStatus = deliveryStatus;
		this.deliveryDate = deliveryDate;
		this.totalPrice = totalPrice;
		this.discount = discount;
		this.deliveryFee = deliveryFee;

	}

	public int getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(int invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(boolean deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}

	public float getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public double getDeliveryFee() {
		return deliveryFee;
	}

	public void setDeliveryFee(double deliveryFee) {
		this.deliveryFee = deliveryFee;
	}
	
	public void setCustomer (String phoneNo) {
		customer = new CustomerController().findByFname(phoneNo);
	}
	
	public Customer getCustomer () {
		return customer;
	}

}
