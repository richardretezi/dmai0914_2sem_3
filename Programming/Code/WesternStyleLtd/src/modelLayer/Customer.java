package modelLayer;

public class Customer {
	
	private String name;
	private String address;
	private String email;
	private int zipCodeID;
	private int phoneno;
	private boolean isCompany;
	
	public Customer(){
		
	}
	
	public Customer( String name, String address, String email, int zipC,
			int phoneno, boolean isCompany){
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.zipCodeID = zipC;
		this.phoneno = phoneno;
		this.isCompany = isCompany;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZipCodeID() {
		return zipCodeID;
	}

	public void setZipCodeID(int zipC) {
		this.zipCodeID = zipC;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public boolean isCompany() {
		return isCompany;
	}

	public void setCompany(boolean isCompany) {
		this.isCompany = isCompany;
	}

}
