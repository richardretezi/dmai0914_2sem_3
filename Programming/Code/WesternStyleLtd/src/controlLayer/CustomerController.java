package controlLayer;

import java.util.ArrayList;

import modelLayer.*;
import dbLayer.*;

public class CustomerController {
	 /** Creates a new instance of CtrEmp */
    public CustomerController() {
        
    }
    public ArrayList<Customer> findAllCustomers()
    {
      IFDBCustomer dbCustomers = new DBCustomer();
      ArrayList<Customer> allCustomers = new ArrayList<Customer>();
      allCustomers = dbCustomers.getAllCustomers(false);
      return allCustomers;
    }
    public Customer findByFname(String phoneNo)
    {
        IFDBCustomer dbCustomer = new DBCustomer();
        return dbCustomer.findCustomer(phoneNo, false);
    }
      public void insertNew(String name, String address, String email, int zipCodeId, int phoneno, Boolean isCompany) throws Exception
      {    
           Customer customerObject = new Customer();
           customerObject.setName(name);
           customerObject.setAddress(address);
           customerObject.setEmail(email);
           customerObject.setZipCodeID(zipCodeId);
           customerObject.setPhoneno(phoneno);
           customerObject.setCompany(isCompany);
    
           try{
            DBConnect.startTransaction();
            DBCustomer dbCustomer = new DBCustomer();
            dbCustomer.insert(customerObject);
            DBConnect.commitTransaction();
           }
           catch(Exception e)
           {
               DBConnect.rollbackTransaction();
               throw new Exception("Employee not inserted");
           }
      }
}
