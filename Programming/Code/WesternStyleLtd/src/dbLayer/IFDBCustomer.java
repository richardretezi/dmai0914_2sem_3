package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBCustomer {
	   public ArrayList<Customer> getAllCustomers(boolean retriveAssociation);
	   public Customer findCustomer(String phoneNo, boolean retriveAssociation);
	   public int insert(Customer dept) throws Exception;
	   public int update(Customer dept)throws Exception;
}
