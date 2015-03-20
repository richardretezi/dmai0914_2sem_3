package modelLayer;

import java.sql.Date;

public class Invoice {
	
	private int salesOrderId;
	private String name;
	private int invoiceNo;
	private Date paymentDate;
	private float amount;
	
	public Invoice(){
		
	}
	
	public Invoice(int salesOrderId, String name, int invoiceNo, Date paymentDate, float amount){
		this.salesOrderId = salesOrderId;
		this.name = name;
		this.invoiceNo = invoiceNo;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}

	public int getSalesOrderId() {
		return salesOrderId;
	}

	public void setSalesOrderId(int salesOrderId) {
		this.salesOrderId = salesOrderId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getInvoiceNo() {
		return invoiceNo;
	}

	public void setInvoiceNo(int invoiceNo) {
		this.invoiceNo = invoiceNo;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	

}
