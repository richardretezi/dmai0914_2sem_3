package dbLayer;

import java.util.ArrayList;
import modelLayer.*;

public interface IFDBUCustomer {
	   public ArrayList<Customer> getAllCustomer(boolean retriveAssociation);
	   public Customer findCustomer(String phoneNo, boolean retriveAssosciation);
	   public int insert(Customer dept);
	   public int update(Customer dept);
}
