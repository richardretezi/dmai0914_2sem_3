package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBInvoice {
	   public ArrayList<Invoice> getAllInvoice(boolean retriveAssociation);
	   public Invoice findInvoice(int saleId, boolean retriveAssosciation);
	   public int insert(Invoice dept) throws Exception;
	   public int update(Invoice dept);
}
