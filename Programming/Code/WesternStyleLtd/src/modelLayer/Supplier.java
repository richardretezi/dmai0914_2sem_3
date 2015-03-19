package modelLayer;

public class Supplier {
	
	private String name;
	private String address;
	private String country;
	private int phoneno;
	private String email;
	
	public Supplier(){
		
	}
	
	public Supplier(String name, String address, String country, int phoneno, String email){
		
		this.name = name;
		this.address = address;
		this.country = country;
		this.phoneno = phoneno;
		this.email = email;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public int getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(int phoneno) {
		this.phoneno = phoneno;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
