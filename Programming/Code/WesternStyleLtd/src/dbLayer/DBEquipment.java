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

public class DBEquipment implements IFDBEquipment{
	
	private Connection con;
	// Create a new instance of DBEmployee
	public DBEquipment(){
		con = DBConnect.getInstance().getDBcon();
	}
	
	//Implement the methods from the interface
	
	public ArrayList<Equipment> getAllEquipment(boolean retrieveAssociation){
		return miscWhere("", retrieveAssociation);
	}
	
	public Equipment findEquipment(int id , boolean retrieveAssociation){
		String wClause = "id = '" + id + "'";
		return singleWhere(wClause, retrieveAssociation);
	}
	
	//insert a new Cloathing
	@Override
	public int insert(Equipment equip) throws Exception{
		int idFromProduct = GetMax.getMaxId("Select max(id) from PRODUCT");
		System.out.println("Id of the product coresponding to equipment= " + idFromProduct);
		int rc = -1;
		String query = "INSERT INTO EQUIPMENT (id, eType, eDescription) VALUES ('"+
				idFromProduct + "','" + 
				equip.getType() + "','" + 
				equip.getDescription() + "')";
		System.out.println("insert : " + query);
		
		//insert new Cloathing 
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}
		catch(SQLException ex){
			throw new Exception ("Equipment is not inserted correctly");
		}
		return(rc);
	}
	
	@Override 
	public int update(Equipment equip){
		Equipment equipObj = equip;
		int rc = -1;
		
		String query = "UPDATE EQUIPMENT SET " + 
			"eType = '" + equipObj.getType() + "', "+ 
			"color = '" + equipObj.getDescription() + "'";
		try{
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			rc = stmt.executeUpdate(query);
			stmt.close();
		}catch(Exception ex){
			System.out.println("Update exception in EQUIPMENT db: "+ex);
		}
		return (rc);
	}
	
	//private methods 
    //michWere is used whenever we want to select more than one cloathing
	private ArrayList<Equipment> miscWhere(String wClause, boolean retrieveAssociation){
		ResultSet results;
		ArrayList<Equipment> list = new ArrayList<Equipment>();
		String query = buildQuery(wClause);
		
		try{//read from DB
			Statement stmt = con.createStatement();
			stmt.setQueryTimeout(5);
			results = stmt.executeQuery(query);
			while(results.next() ) {
				Equipment equipObj = new Equipment();
				equipObj = buildEquipment(results);
				list.add(equipObj);
			}
			stmt.close();
			if(retrieveAssociation){;}
		}catch(Exception e ){
			System.out.println("Query exception - select: " + e );
			e.printStackTrace();
		}
		return list;
		
	}
	
	private Equipment singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		Equipment equipObj = new Equipment();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the employee from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
	 			equipObj = buildEquipment(results);
                //assocaition is to be build
                stmt.close();
                if(retrieveAssociation)
                	{;}
			}
            else{ //no employee was found
            	equipObj = null;
            }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return equipObj;
	}
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT eType,eDescription  FROM EQUIPMENT";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private Equipment buildEquipment(ResultSet results){
		Equipment equipObj = new Equipment();
		try{//the columns from the table CLOATHING are used
			equipObj.setType(results.getString("size"));
			equipObj.setDescription(results.getString("color"));
		}
		catch (Exception e){
			System.out.println("Error in building the Cloathing object");
		}
		return equipObj;
	}
	
}
