package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBProduct {
	public ArrayList<Product> getAllProduct(boolean retriveAssociation);
	   public Product findProduct(String name, boolean retriveAssociation);
	   public int insert(Product dept) throws Exception;
	   public int update(Product dept);
}
