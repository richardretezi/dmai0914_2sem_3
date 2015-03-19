package dbLayer;

import java.sql.*;

import modelLayer.*;

import java.util.ArrayList;

import modelLayer.Cloathing;

/**
 * DBCloathing.java
 * @author A-Leonard
 * @version 1. march 2015
 *
 */

public class DBCloathing implements IFDBCloathing{
	
	private Connection con;
	// Create a new instance of DBEmployee
	public DBCloathing(){
		con = DBConnect.getInstance().getDBcon();
	}
	
	//Implement the methods from the interface
	
	public ArrayList<Cloathing> getAllCloathing(boolean retrieveAssociation){
		return miscWhere("", retrieveAssociation);
	}
	
	public Cloathing findCloathing(int id , boolean retrieveAssociation){
		String wClause = "id = '" + id + "'";
		return singleWhere(wClause, retrieveAssociation);
	}
	
	//insert a new Cloathing
	@Override
	public int insert(Cloathing clth) throws Exception{
		int idFromProduct = GetMax.getMaxId("Select max(id) from PRODUCT");
		System.out.println("Id of the product coresponding to cloathing = " + idFromProduct);
		int rc = -1;
		String query = "INSERT INTO CLOTHING (id, size, color) VALUES ('"+
				idFromProduct + "','" + 
				clth.getSize() + "','" + 
				clth.getColor() + "')";
		System.out.println("insert : " + query);
		
		//insert new Cloathing 
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex){
			throw new Exception ("Cloathing is not inserted correctly");
		}
		return(rc);
	}
	
	@Override 
	public int update(Cloathing clth){
		Cloathing clthObj = clth;
		int rc = -1;
		
		String query = "UPDATE CLOTHING SET " + 
			"size = '" + clthObj.getSize() + "', "+ 
			"color = '" + clthObj.getColor() + "'";
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}catch(Exception ex){
			System.out.println("Update exception in CLOTHING db: "+ex);
		}
		return (rc);
	}
	
	//private methods 
    //michWere is used whenever we want to select more than one cloathing
	private ArrayList<Cloathing> miscWhere(String wClause, boolean retrieveAssociation){
		ResultSet results;
		ArrayList<Cloathing> list = new ArrayList<Cloathing>();
		String query = buildQuery(wClause);
		
		try{//read from DB
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			while(results.next() ) {
				Cloathing clthObj = new Cloathing();
				clthObj = buildCloathing(results);
				list.add(clthObj);
			}
			stmt.close();
			if(retrieveAssociation){;}
		}catch(Exception e ){
			System.out.println("Query exception - select: " + e );
			e.printStackTrace();
		}
		return list;
		
	}
	
	private Cloathing singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Cloathing clthObj = new Cloathing();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            clthObj = buildCloathing(results);
                            //assocaition is to be build
                            stmt.close();
                            if(retrieveAssociation)
                            {;}
			}
            else{ //no employee was found
                    clthObj = null;
            }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return clthObj;
	}
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT color,size  FROM CLOTHING";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private Cloathing buildCloathing(ResultSet results){
		Cloathing clthObj = new Cloathing();
		try{//the columns from the table CLOATHING are used
			clthObj.setSize(results.getString("size"));
			clthObj.setColor(results.getString("color"));
		}
		catch (Exception e){
			System.out.println("Error in building the Cloathing object");
		}
		return clthObj;
	}
	
}
