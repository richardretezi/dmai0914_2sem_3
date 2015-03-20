package controlLayer;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import modelLayer.Invoice;
import dbLayer.DBConnect;
import dbLayer.DBInvoice;
import dbLayer.IFDBInvoice;

public class InvoiceController {
	 /** Creates a new instance of CtrEmp */
    public InvoiceController() {
        
    }
    public ArrayList<Invoice> findAllInvoices()
    {
      IFDBInvoice dbInvoice = new DBInvoice();
      ArrayList<Invoice> allInvoices = new ArrayList<Invoice>();
      allInvoices = dbInvoice.getAllInvoice(false);
      return allInvoices;
    }
    public Invoice findById(int id)
    {
        IFDBInvoice dbInvoice = new DBInvoice();
        return dbInvoice.findInvoice(id, false);
    }
      public void insertNew(int salesOrderId, String name, int invoiceNo, Date paymentDate, float amount ) throws Exception
      {    
    	  
    	 //covert date to string
    	  DateFormat df = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
    	  Date date = paymentDate;     
    	  String reportDate = df.format(date);
    	  //convert date to string
           Invoice invoiceObject = new Invoice();
           invoiceObject.setSalesOrderId(salesOrderId);
           invoiceObject.setName(name);
           invoiceObject.setInvoiceNo(invoiceNo);
           invoiceObject.setPaymentDate(paymentDate);
           invoiceObject.setAmount(amount);
    
           try{
            DBConnect.startTransaction();
            DBInvoice dbInvoice = new DBInvoice();
            dbInvoice.insert(invoiceObject);
            DBConnect.commitTransaction();
           }
           catch(Exception e)
           {
               DBConnect.rollbackTransaction();
               throw new Exception("Invoice not inserted");
           }
      }
}
