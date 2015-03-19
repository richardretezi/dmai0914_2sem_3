package dbLayer;

import java.util.ArrayList;
import modelLayer.Cloathing;

public interface IFDBCloathing {
	   public ArrayList<Cloathing> getAllCloathing(boolean retriveAssociation);
	   public Cloathing findCloathing(int id, boolean retriveAssosciation);
	   public int insert(Cloathing dept) throws Exception;
	   public int update(Cloathing dept);
}
