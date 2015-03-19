package dbLayer;

import java.util.ArrayList;

import modelLayer.*;

public interface IFDBGunReplicas {
	  public ArrayList<GunReplicas> getGunReplicas(boolean retriveAssociation);
	   public GunReplicas findGunReplicas(String name, boolean retriveAssosciation);
	   public int insert(GunReplicas dept);
	   public int update(GunReplicas dept);
}
