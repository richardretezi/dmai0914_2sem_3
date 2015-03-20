package controlLayer;

import java.sql.Date;

import modelLayer.Customer;
import modelLayer.Invoice;
import modelLayer.Product;
import modelLayer.SaleOrderLine;
import modelLayer.SalesOrder;

public class SaleController {
	private CustomerController customerController;
	private SalesOrderController saleOrderController;
	private SalesOrder salesOrder;
	private ProductController productController;
	private InvoiceController invoiceController;
	
	
	
	
	public SaleController(){
	salesOrder= new SalesOrder();
	}
	public void addCustomer(String phoneNo){
		//to be implemented
	}
	//done
	public Invoice createInvoice(int saleId){
		Invoice i = new Invoice();		
		Date date = new Date(0);
		try {
			invoiceController.insertNew(saleId, "Invoice", invoiceController.findAllInvoices().size()+1,date, salesOrder.getTotalPrice());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	public void addInvoiceToDB(Invoice i){
		try {
			invoiceController.insertNew(i.getSalesOrderId(), i.getName(), i.getInvoiceNo(), i.getPaymentDate(), i.getAmount());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("There is a problem with the invoice adding.");
		}
	}
	//done
	public void addCustomerToSaleOder(String phoneNo){
		salesOrder.setCustomer(phoneNo);
	}
	//done
	public SaleOrderLine addProductToSaleLine(int id, int quantity){
		SaleOrderLine sol = new SaleOrderLine(id,quantity);
		return sol;
	}
	//done
	public void setInvoiceToSaleOrder(int invoiceId){
		salesOrder.setInvoiceId(invoiceId);
	}
	//done
	public Customer findCustomer(String phonoNo){
		return customerController.findByFname(phonoNo);
	}
	//done
	public boolean checkProductQuantity(Product p, int quantity){
		return productController.checkQuantity(p, quantity);		
	}
	//done
	public Product findProduct(String name){
		return productController.findProduct(name);		
	}
	//done
		public void addSaleOrderToDB(SalesOrder saleOrder){
			try {
				saleOrderController.insert(saleOrder);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Problem in add sale order to database");
			}
		}
	
}
