package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBSaleOrderLine {
		public ArrayList<SaleOrderLine> getAllSaleOrderLine(boolean retriveAssociation);
	   public SaleOrderLine findSaleOrderLine(int id, boolean retriveAssosciation);
	   public int insert(SaleOrderLine dept);
	   public int update(SaleOrderLine dept);
}
