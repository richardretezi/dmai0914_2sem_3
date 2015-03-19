package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBSupplier {
	   public ArrayList<Supplier> getAllSupplier(boolean retriveAssociation);
	   public Supplier findSupplier(int id, boolean retriveAssosciation);
	   public int insert(Supplier dept);
	   public int update(Supplier dept);
}
