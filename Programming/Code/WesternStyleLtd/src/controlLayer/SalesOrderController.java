package controllerLayer;

import java.util.ArrayList;

import modelLayer.*;
import dbLayer.*;

public class SalesOrderController {
	
	public SalesOrderController() {
		
	}
	
	public ArrayList<SalesOrder> getAllSalesOrders(boolean retriveAssociation) {
		IFDBSaleOrderLine dbSalesOrders = new DBSalesOrder();
	      ArrayList<SalesOrder> allSaleOrderLines = new ArrayList<SalesOrders>();
	      allSalesOrders = dbSalesOrder.getAllSalesOrders(false);
	      return allSalesOrders;
	}
	
	 public SaleOrderLine findSalesOrder(int id, boolean retriveAssociation)
	    {
	        IFDBSaleOrderLine dbSalesOrder = new DBSalesOrder();
	        return dbSalesOrder.findSaleOrderLine(id, false);
	    }
	 
	 public void insert(SalesOrder dept, int quantity, int id) throws Exception
     {    
          SalesOrder salesOrderObject = new SalesOrder();
          salesOrderObject.setQuantity(quantity);
          salesOrderObject.setID(id);
          
   
          try{
           DBConnect.startTransaction();
           DBSaleOrderLine dbSaleOrderLine = new DBSaleOrderLine();
           dbSaleOrderLine.insert(salesOrderObject);
           DBConnect.commitTransaction();
          }
          catch(Exception e)
          {
              DBConnect.rollbackTransaction();
              throw new Exception("SaleOrderLine is not inserted");
          }
     }

}
