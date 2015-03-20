package controlLayer;

import dbLayer.DBProduct;
import dbLayer.DBCloathing;
import dbLayer.DBEquipment;
import dbLayer.DBReplicas;
import modelLayer.Product;
import modelLayer.Cloathing;
import modelLayer.Equipment;
import modelLayer.GunReplicas;

public class ProductController {

	public Product findProduct(String name){
		DBProduct p = new DBProduct();
		Product pObj = new Product();
		pObj = p.findProduct(name, false);
		if(pObj.getProductType() == 1){
			DBCloathing clthDb = new DBCloathing();
			Cloathing clth = new Cloathing();
			clth = clthDb.findCloathing(pObj.getProductID(), false);
			Product prod = new Cloathing();
			///prod.setProductID(pObj.getProductID());
			prod = pObj;
			((Cloathing)prod).setSize(clth.getSize());
			((Cloathing)prod).setColor(clth.getColor());
			return prod;
		}
			
		else if (pObj.getProductType() == 2){
			DBEquipment equipDb = new DBEquipment();
			Equipment equip = new Equipment();
			equip = equipDb.findEquipment(pObj.getProductID(), false);
			Product prod = new Equipment();
			///prod.setProductID(pObj.getProductID());
			prod = pObj;
			((Equipment)prod).setType(equip.getType());
			((Equipment)prod).setDescription(equip.getDescription());
			return prod;
		}
		else {
			DBReplicas gunDb = new DBReplicas();
			GunReplicas gun = new GunReplicas();
			gun = gunDb.findGunReplicas(pObj.getProductID(), false);
			Product prod = new GunReplicas();
			///prod.setProductID(pObj.getProductID());
			prod = pObj;
			((GunReplicas)prod).setCalibre(gun.getCalibre());
			((GunReplicas)prod).setFabric(gun.getFabric());
			return prod;
		}
		
		
	}
	public boolean checkQuantity(Product product , int quantity){
		return product.getInStock() > quantity;
	}
	
	
	
}
