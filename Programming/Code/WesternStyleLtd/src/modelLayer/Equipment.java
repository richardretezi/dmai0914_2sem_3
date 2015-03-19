package modelLayer;

public class Equipment extends Product{

	private String type;
	private String description;
	
	public Equipment(){
		super();
	}
	
	public Equipment(String type, String description){
		super();
		this.type = type;
		this.description = description;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
