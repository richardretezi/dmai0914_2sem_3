package dbLayer;

import static org.junit.Assert.*;

import org.junit.Test;

public class DBConnectTest {
	
	@Test
	public void test(){
		DBConnect dbCon = DBConnect.getInstance();
		if(dbCon != null){
			System.out.println("Connection to DB is ok!");
		}
		else {
			fail("Cannot connect to the DB");
		}
	}

}
