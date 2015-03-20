package modelLayer;

public class SaleOrderLine {
	private int quantity;
	private int id;
	
	public SaleOrderLine(){
		
	}
	
	public SaleOrderLine(int id, int quantity){
		this.id = id;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getID() {
		return id;
	}

	public void setID(int id) {
		this.id = id;
	}

}
