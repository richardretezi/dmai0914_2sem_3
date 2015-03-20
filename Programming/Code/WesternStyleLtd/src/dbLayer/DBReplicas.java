package dbLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modelLayer.GunReplicas;

public class DBReplicas implements IFDBGunReplicas{
	
	private Connection con;
	
	public DBReplicas(){
		con = DBConnect.getInstance().getDBcon();
	}
	
	
	public ArrayList<GunReplicas> getGunReplicas(boolean retriveAssociation) {
		return miscWhere("", retriveAssociation);
	}
	
	public GunReplicas findGunReplicas(int id, boolean retriveAssociation) {
		String wClause = "  id = '" + id + "'";
        return singleWhere(wClause, retriveAssociation);
	}
	public int insert(GunReplicas gr) throws Exception{
		int idFromProduct = GetMax.getMaxId("Select max(id) from PRODUCT");
		System.out.println("Id of the product coresponding to replicas= " + idFromProduct);
		int rc = -1;
	   String query="INSERT INTO GUN_REPLICAS(id, fabric, calibre)  VALUES('"+
	  		  "','"  +
		    idFromProduct  + "','"  +
            gr.getFabric() + "','" +
            gr.getCalibre() + "')";
                     

       System.out.println("insert : " + query);
      try{ // insert new gun replica +  dependent
          Statement stmt = con.createStatement();
          stmt.setQueryTimeout(5);
     	  rc = stmt.executeUpdate(query);
          stmt.close();
      }//end try
       catch(SQLException ex){
          System.out.println("GunReplicas is not created");
          throw new Exception ("GunReplicas is not inserted correctly");
       }
       return(rc);
	}
	
	public int update(GunReplicas gr) {
		GunReplicas grObj  = gr;
		int rc=-1;

		String query="UPDATE GunReplicas SET "+
		 	  "fabric ='"+ grObj.getFabric() + "', " +
              "calibre ='"+ grObj.getCalibre() + "','";
                System.out.println("Update query:" + query);
  		try{ // update gun replica
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 	 	rc = stmt.executeUpdate(query);

	 	 	stmt.close();
		}//end try
	 	catch(Exception ex){
	 	 	System.out.println("Update exception in GunReplicas db: "+ex);
	  	}
		return(rc);
	}
	
	private GunReplicas singleWhere(String wClause, boolean retrieveAssociation)
	{
		ResultSet results;
		GunReplicas grObj = new GunReplicas();
                
	        String query =  buildQuery(wClause);
                System.out.println(query);
		try{ // read the GunReplicas from the database
	 		Statement stmt = con.createStatement();
	 		stmt.setQueryTimeout(5);
	 		results = stmt.executeQuery(query);
	 		
	 		if( results.next() ){
                            grObj = buildGunReplicas(results);
                            //assocaition is to be build
                            stmt.close();
			}
                        else{ //no GunReplicas was found
                            grObj = null;
                        }
		}//end try	
	 	catch(Exception e){
	 		System.out.println("Query exception: "+e);
	 	}
		return grObj;
	}
	
	private String buildQuery(String wClause)
	{
	    String query="SELECT id, fabric, calibre  FROM GunReplicas";
		
		if (wClause.length()>0)
			query=query+" WHERE "+ wClause;
			
		return query;
	}
	
	private GunReplicas buildGunReplicas(ResultSet results)
    {   GunReplicas grObj = new GunReplicas();
        try{ // the columns from the table gun replicas  are used
              //grObj.setId(results.getString("id"));
              grObj.setFabric(results.getString("fabric"));
              grObj.setCalibre(results.getString("calibre"));
              
        }
       catch(Exception e)
       {
           System.out.println("error in building the employee object");
       }
       return grObj;
    }
	
	private ArrayList<GunReplicas> miscWhere(String wClause, boolean retrieveAssociation)
	{
            ResultSet results;
	    ArrayList<GunReplicas> list = new ArrayList<GunReplicas>();	
		
	    String query =  buildQuery(wClause);
  
            try{ // read the employee from the database
		Statement stmt = con.createStatement();
	 	stmt.setQueryTimeout(5);
	 	results = stmt.executeQuery(query);
	 	
	
		while( results.next() ){
			GunReplicas grObj = new GunReplicas();
		 grObj = buildGunReplicas(results);	
                 list.add(grObj);	
		}//end while
                 stmt.close();     
                 
			
		}catch(Exception e){
			System.out.println("miscWhere failed");
		}
            return list;
	}


}
