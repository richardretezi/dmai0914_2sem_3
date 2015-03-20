package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.Invoice;

public class DBInvoice implements IFDBInvoice{

	
	private Connection con;
	
	public DBInvoice(){
		con = DBConnect.getInstance().getDBcon();
	}
	
	
	public ArrayList<Invoice> getAllInvoice(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}
	
	public Invoice findInvoice(int id, boolean retriveAssociation) {
		String wClause = "  id = '" + id + "'";
        return singleWhere(wClause, retriveAssociation);
	}
	public int insert(Invoice i) throws Exception{
		//int nextName = GetMax.getMaxId("Select max(ssn) from Invoice");
        //nextSSN = nextSSN + 1;
        //System.out.println("next ssn = " +  nextSSN);
		/**String query1="INSERT INTO PRODUC(name, purchasePrice, salesPrice, rentPrice, "
				+ "countryofOrigin, minStock, inStock, typee) VALUES('"+
				+ "','" + 
				i.getName() + "','" +
				i.getPurchasePrice() + "','" +
				i.getSalesPrice() + "','" +
				i.getRentPrice() + "','" +
				i.getCountryOfOrigin() + "','" +
				i.getMinStock() + "','" +)
				*/
		
       int rc = -1;
	   String query="INSERT INTO GUN_REPLICAS(id, name, invoiceNR, paymentDate, amount, saleID)  VALUES('"+
	  		  "','"  +
		    //i.getId()  + "','"  +
            i.getName() + "','" +
            i.getInvoiceNo() + "','" + 
            i.getPaymentDate() + "','" +
            i.getAmount() + "','" +
            i.getSalesOrderId() + "')";
                     

       System.out.println("insert : " + query);
      try{ // insert new invoice +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("Invoice is not created");
          throw new Exception ("Invoice is not inserted correctly");
       }
       return(rc);
	}
	
	public int update(Invoice i) {
		Invoice iObj  = i;
		int rc=-1;

		String query="UPDATE Invoice SET "+
		 	  "name ='"+ iObj.getName() + "', " +
		 	  "invoiceNR ='"+ iObj.getInvoiceNo() + "', " +
		 	  "paymentDate ='"+ iObj.getPaymentDate() + "', " +
		 	  "amount ='"+ iObj.getAmount() + "', " +
              "saleID ='"+ iObj.getSalesOrderId() + "','";
                System.out.println("Update query:" + query);
  		try{ // update Invoice
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in Invoice db: "+ex);
	  	}
		return(rc);
	}
	
	private Invoice singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Invoice iObj = new Invoice();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the Invoice from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            iObj = buildInvoice(results);
                            //association is to be build
                            stmt.close();
			}
                        else{ //no Invoice was found
                            iObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return iObj;
	}
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT id, name, invoiceNR, paymentDate, amount, saleID";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private Invoice buildInvoice(ResultSet results)
    {   Invoice iObj = new Invoice();
        try{ // the columns from the table gun replicas  are used
              //iObj.setId(results.getString("id"));
              iObj.setName(results.getString("name"));
              iObj.setInvoiceNo(results.getInt("invoiceNR"));
              iObj.setPaymentDate(results.getDate("paymentDate"));
              iObj.setAmount(results.getFloat("amount"));
              iObj.setSalesOrderId(results.getInt("saleID"));
        }
       catch(Exception e)
       {
           System.out.println("error in building the Invoice object");
       }
       return iObj;
    }
	
	private ArrayList<Invoice> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<Invoice> list = new ArrayList<Invoice>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			Invoice iObj = new Invoice();
		 iObj = buildInvoice(results);	
                 list.add(iObj);	
		}//end while
                 stmt.close();     
                 
			
		}catch(Exception e){
			System.out.println("miscWhere failed");
		}
            return list;
	}
}
