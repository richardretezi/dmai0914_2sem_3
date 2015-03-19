package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBEquipment {
	  	public ArrayList<Equipment> getAllEquipment(boolean retriveAssociation);
	   public Cloathing findEquipment(String name, boolean retriveAssosciation);
	   public int insert(Equipment dept);
	   public int update(Equipment dept);
}
