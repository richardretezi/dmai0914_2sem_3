package controlLayer;

import java.util.ArrayList;

import modelLayer.*;
import dbLayer.*;

public class SalesOrderController {
	
	public SalesOrderController() {
		
	}
	
	public ArrayList<SalesOrder> getAllSalesOrders(boolean retriveAssociation) {
		IFDBSalesOrder dbSalesOrder = new DBSalesOrder();
	      ArrayList<SalesOrder> allSalesOrders= new ArrayList<SalesOrder>();
	      allSalesOrders = dbSalesOrder.getAllSalesOrders(false);
	      return allSalesOrders;
	}
	
	 public SalesOrder findSalesOrder(int id, boolean retriveAssociation)
	    {
	        IFDBSalesOrder dbSalesOrder = new DBSalesOrder();
	        return dbSalesOrder.findSalesOrder(id, false);
	    }
	 
	 public void insert(SalesOrder dept) throws Exception
     {    
          SalesOrder salesOrderObject = new SalesOrder();
       
   
          try{
           DBConnect.startTransaction();
           DBSalesOrder dbSalesOrder = new DBSalesOrder();
           dbSalesOrder.insert(salesOrderObject);
           DBConnect.commitTransaction();
          }
          catch(Exception e)
          {
              DBConnect.rollbackTransaction();
              throw new Exception("SaleOrderLine is not inserted");
          }
     }

}
