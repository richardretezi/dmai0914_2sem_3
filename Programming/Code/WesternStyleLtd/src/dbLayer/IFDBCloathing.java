package dbLayer;

import java.util.ArrayList;
import modelLayer.Cloathing;

public interface IFDBCloathing {
	   public ArrayList<Cloathing> getAllCloathing(boolean retriveAssociation);
	   public Cloathing findCloating(String name, boolean retriveAssosciation);
	   public int insert(Cloathing dept);
	   public int update(Cloathing dept);	
}
