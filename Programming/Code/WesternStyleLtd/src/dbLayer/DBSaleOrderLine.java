package dbLayer;
import modelLayer.*;

import java.sql.*;
import java.util.ArrayList;





import dbLayer.DBConnect;

public class DBSaleOrderLine implements IFDBSaleOrderLine{
	 private  Connection con;
	    /** Creates a new instance of DBEmployee */
	    public DBSaleOrderLine() {
	      con = DBConnect.getInstance().getDBcon();
	    }
	    
	    public  ArrayList<SaleOrderLine> getAllSaleOrderLine(boolean retriveAssociation)
	    {
	        return miscWhere("", retriveAssociation);
	    }
	    
	    public SaleOrderLine findSaleOrderLine(int id, boolean retriveAssociation)
	    {   String wClause = "  id = '" + id + "'";
	        return singleWhere(wClause, retriveAssociation);
	    }
	    
	    public void insert(SaleOrderLine dept) throws Exception
	    {  //call to get the next ssn number
	       /* int nextSSN = GetMax.getMaxId("Select max(ssn) from employee");
	        nextSSN = nextSSN + 1;
	        System.out.println("next ssn = " +  nextSSN); */
	  
	       int rc = -1;
		   String query="INSERT INTO saleOrderLine(quantity, pID)  VALUES('"+
			    dept.getQuantity()  + "','"  +
	            dept.getID() + "','" +"')";
	                     

	       System.out.println("insert : " + query);
	      try{ // insert new employee +  dependent
	          Statement stmt = con.createStatement();
	          stmt.setQueryTimeout(5);
	     	  rc = stmt.executeUpdate(query);
	          stmt.close();
	      }//end try
	       catch(SQLException ex){
	          System.out.println("OrderLine ikke oprettet");
	          throw new Exception ("OrderLine is not inserted correctly");
	       }
	       
	    }
	    
	    public int update(SaleOrderLine dept) {
	    	int rc=-1;
	    	return rc;
	    }
	    
	    private ArrayList<SaleOrderLine> miscWhere(String wClause, boolean retrieveAssociation)
		{
	            ResultSet results;
		    ArrayList<SaleOrderLine> list = new ArrayList<SaleOrderLine>();	
			
		    String query =  buildQuery(wClause);
	  
	            try{ // read the employee from the database
			Statement stmt = con.createStatement();
		 	stmt.setQueryTimeout(5);
		 	results = stmt.executeQuery(query);
		 	
		
			while( results.next() ){
				SaleOrderLine solObj = new SaleOrderLine();
				solObj = buildSaleOrderLine(results);	
	                 list.add(solObj);	
			}//end while
	                
				
			}//slut try	
		 	catch(Exception e){
		 		System.out.println("Query exception - select: "+e);
				e.printStackTrace();
		 	}
			return list;
		}
		
		//Singelwhere is used when we only select one employee 	
		private SaleOrderLine singleWhere(String wClause, boolean retrieveAssociation)
		{
			ResultSet results;
			SaleOrderLine solObj = new SaleOrderLine();
	                
		        String query =  buildQuery(wClause);
	                System.out.println(query);
			try{ // read the employee from the database
		 		Statement stmt = con.createStatement();
		 		stmt.setQueryTimeout(5);
		 		results = stmt.executeQuery(query);
		 		
		 		if( results.next() ){
		 			solObj = buildSaleOrderLine(results);
	                            //assocaition is to be build
	                            stmt.close();
	                            
				}
	                        else{ //no employee was found
	                        	solObj = null;
	                        }
			}//end try	
		 	catch(Exception e){
		 		System.out.println("Query exception: "+e);
		 	}
			return solObj;
		}
		//method to build the query
		private String buildQuery(String wClause)
		{
		    String query="SELECT quantity, pID  FROM SaleOrderLine";
			
			if (wClause.length()>0)
				query=query+" WHERE "+ wClause;
				
			return query;
		}
		//method to build an employee object
		private SaleOrderLine buildSaleOrderLine(ResultSet results)
	      {   SaleOrderLine solObj = new SaleOrderLine();
	          try{ // the columns from the table emplayee  are used
	        	  solObj.setQuantity(Integer.parseInt(results.getString("quantity")));
	        	  solObj.setID(Integer.parseInt(results.getString("id")));
	               
	          }
	         catch(Exception e)
	         {
	             System.out.println("error in building the SaleOrderLine object");
	         }
	         return solObj;
	      }

}
