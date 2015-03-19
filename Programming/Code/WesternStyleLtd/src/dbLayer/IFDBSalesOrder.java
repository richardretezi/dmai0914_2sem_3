package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBSalesOrder {
	public ArrayList<SalesOrder> getAllSalesOrder(boolean retriveAssociation);
	   public SalesOrder findSalesOrder(int id, boolean retriveAssosciation);
	   public int insert(SalesOrder dept);
	   public int update(SalesOrder dept);
}
