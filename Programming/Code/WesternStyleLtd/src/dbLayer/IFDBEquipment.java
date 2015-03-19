package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBEquipment {
	  	public ArrayList<Equipment> getAllEquipment(boolean retriveAssociation);
	   public Equipment findEquipment(int id, boolean retriveAssosciation);
	   public int insert(Equipment dept) throws Exception;
	   public int update(Equipment dept);
}
