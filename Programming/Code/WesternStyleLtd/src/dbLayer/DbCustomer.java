package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelLayer.*;
import dbLayer.*;

public class DBCustomer implements IFDBCustomer {
	private  Connection con;
    /** Creates a new instance of DBEmployee */
    public DBCustomer() {
      con = DBConnect.getInstance().getDBcon();
    }
	@Override
	public ArrayList<Customer> getAllCustomers(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}
	@Override
	public Customer findCustomer(String phoneNo, boolean retriveAssociation) {
		String wClause = "  phoneNo = '" + phoneNo + "'";
        return singleWhere(wClause, retriveAssociation);
	}
	@Override
	public int insert(Customer cust) throws Exception {
		 //call to get the next ssn number
        //int nextSSN = GetMax.getMaxId("Select max(id) from Customer");
       // nextSSN = nextSSN + 1;
       // System.out.println("next id = " +  nextSSN);
  
       int rc = -1;
	   String query="INSERT INTO customer(name, cAddress,email, zipcodeID,phoneNR,isCompany)VALUES('"+
			   cust.getName()  + "','"  +
			   cust.getAddress()  + "','"  +
			   cust.getEmail()+ "','" +
			   cust.getZipCodeID() + "','" +
			   cust.getPhoneno() + "','"+
			   cust.isCompany()
            	+")";
                     

       System.out.println("insert : " + query);
      try{ // insert new employee +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Customer not inserted");
          throw new Exception ("Employee not inserted correctly");
       }
       return(rc);
	}
	
	@Override
	public int update(Customer dept) {
		//to be implemented
		return 0;
	}
	
	private ArrayList<Customer> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Customer> list = new ArrayList<Customer>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Customer custObj = new Customer();
			custObj = buildCustomer(results);	
                 list.add(custObj);	
		}//end while
                 stmt.close();     
			
		}//slut try	
	 	catch(Exception e){
	 		System.out.println("Query exception - select: "+e);
			e.printStackTrace();
	 	}
		return list;
	}
	
	//Singelwhere is used when we only select one employee 	
	private Customer singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Customer cusObj = new Customer();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            cusObj = buildCustomer(results);
                            //assocaition is to be build
                            stmt.close();
			}
                        else{ //no employee was found
                            cusObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return cusObj;
	}
	//method to build the query
	private String buildQuery(String wClause)
	{
	    String query="SELECT *  FROM customer";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	//method to build an employee object
	private Customer buildCustomer(ResultSet results)
      {   Customer cusObj = new Customer();
          try{ // the columns from the table emplayee  are used
        	  //name, cAddress,email, zipcodeID,phoneNR,isCompany
        	  
        	  cusObj.setName(results.getString("name"));
        	  cusObj.setAddress(results.getString("cAddress"));
        	  cusObj.setEmail(results.getString("email"));
        	  cusObj.setZipCodeID(Integer.parseInt(results.getString("zipcodeID")));
        	  cusObj.setPhoneno(Integer.parseInt(results.getString("PhoneNR")));
        	  cusObj.setCompany(Boolean.valueOf(results.getString("isCompany")));
          }
         catch(Exception e)
         {
             System.out.println("error in building the employee object");
         }
         return cusObj;
      }
}
