package modelLayer;

public class Cloathing extends Product{
	
	private String size;
	private String color;
	
	public Cloathing(){
		super();
	}
	
	public Cloathing(String size, String color){
		super();
		this.size = size;
		this.color = color;		
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}
}
