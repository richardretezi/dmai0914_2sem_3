package modelLayer;

public class SaleOrderLine {
	private int quantity;
	private Product p;
	
	public SaleOrderLine(){
		
	}
	
	public SaleOrderLine(Product p, int quantity){
		this.p = p;
		this.quantity = quantity;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Product getP() {
		return p;
	}

	public void setP(Product p) {
		this.p = p;
	}

}
