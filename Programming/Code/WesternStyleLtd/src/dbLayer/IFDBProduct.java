package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBProduct {
	public ArrayList<Product> getAllProduct(boolean retriveAssociation);
	   public Product findProduct(String name, boolean retriveAssosciation);
	   public int insert(Product dept);
	   public int update(Product dept);
}
