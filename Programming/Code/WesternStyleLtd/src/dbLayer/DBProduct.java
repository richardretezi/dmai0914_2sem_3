package dbLayer;
import modelLayer.*;

import java.sql.*;
import java.util.ArrayList;


//import dbLayer.GetMax;


public class DBProduct implements IFDBProduct {
	private Connection con;

	public DBProduct() {
		con = DBConnect.getInstance().getDBcon();
	}
	
	public ArrayList<Product> getAllProduct(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}
	
	public Product findProduct(String name, boolean retriveAssociation) {
		String wClause = " name like % '" + name + "%'";
		return singleWhere(wClause, retriveAssociation);
	}
	
	public int insert (Product dept) throws Exception {
		
	    {  //call to get the next ssn number
	        //int nextId = GetMax.getMaxId("Select max(ssn) from employee");
	     //   nextID = nextId + 1;
	      //  System.out.println("next ssn = " +  nextId);
	  
	       int rc = -1;
		   String query="INSERT INTO product( name, purchasePrice, salesPrice, rentPrice, countryofOrigin, "
		   		+ "minStock, inStock, typee)  VALUES('"+
		  		dept.getName()  + "','"  +
			    dept.getPurchasePrice()  + "','"  +
			    dept.getSalesPrice()  + "','"  +
			    dept.getRentPrice()  + "','"  +
			    dept.getCountryOfOrigin()  + "','"  +
			    dept.getMinStock()  + "','"  +
			    dept.getInStock() + "','" +
			    dept.getProductType() +	"')";
	                     

	       System.out.println("insert : " + query);
	      try{ // insert new employee +  dependent
	          Statement stmt = con.createStatement();
	          stmt.setQueryTimeout(5);
	     	  rc = stmt.executeUpdate(query);
	          stmt.close();
	      }//end try
	       catch(SQLException ex){
	          System.out.println("Product ikke oprettet");
	          throw new Exception ("Product is not inserted correctly");
	       }
	       return(rc);
	    }
	}
	    
	public int update (Product dept) {
	    	int rc = -1;
	    	return rc;
	    }
	    
	private ArrayList<Product> miscWhere(String wClause, boolean retrieveAssociation)
		{
	            ResultSet results;
		    ArrayList<Product> list = new ArrayList<Product>();	
			
		    String query =  buildQuery(wClause);
	  
	            try{ // read the employee from the database
			Statement stmt = con.createStatement();
		 	stmt.setQueryTimeout(5);
		 	results = stmt.executeQuery(query);
		 	
		
			while( results.next() ){
		     	 Product prObj = new Product();
		     	prObj = buildProduct(results);	
	                 list.add(prObj);	
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
	private Product singleWhere(String wClause, boolean retrieveAssociation)
		{
			ResultSet results;
			Product prObj = new Product();
	                
		        String query =  buildQuery(wClause);
	                System.out.println(query);
			try{ // read the employee from the database
		 		Statement stmt = con.createStatement();
		 		stmt.setQueryTimeout(5);
		 		results = stmt.executeQuery(query);
		 		
		 		if( results.next() ){
		 			prObj = buildProduct(results);
	                            //assocaition is to be build
	                            stmt.close();
	                         
				}
	                        else{ //no employee was found
	                        	prObj = null;
	                        }
			}//end try	
		 	catch(Exception e){
		 		System.out.println("Query exception: "+e);
		 	}
			return prObj;
		}
		//method to build the query
	private String buildQuery(String wClause)
		{
		    String query="SELECT *  FROM product";
			
			if (wClause.length()>0)
				query=query+" WHERE "+ wClause;
				
			return query;
		}
		//method to build an employee object
		private Product buildProduct(ResultSet results)
	      {   Product prObj = new Product();
	          try{ // the columns from the table employee  are used
	        	  prObj.setProductID(Integer.parseInt(results.getString("id")));
	        	  prObj.setName(results.getString("name"));
	        	  prObj.setPurchasePrice(Double.parseDouble(results.getString("purchasePrice")));
	        	  prObj.setSalesPrice(Double.parseDouble(results.getString("salesPrice")));
	        	  prObj.setRentPrice(Double.parseDouble(results.getString("rentPrice")));
	        	  prObj.setCountryOfOrigin(results.getString("countryOfOrigin"));
	        	  prObj.setMinStock(Integer.parseInt(results.getString("minStock")));
	        	  prObj.setInStock(Integer.parseInt(results.getString("inStock")));
	        	  prObj.setProductType(Integer.parseInt(results.getString("typee")));
	          }
	         catch(Exception e)
	         {
	             System.out.println("error in building the employee object");
	         }
	         return prObj;
	      }

}
