package modelLayer;

public class Customer {
	
	private String name;
	private String address;
	private String email;
	private int zipC;
	private String city;
	private int phoneno;
	private boolean isCompany;
	
	public Customer(){
		
	}
	
	public Customer( String name, String address, String email, int zipC, String city, 
			int phoneno, boolean isCompany){
		
		this.name = name;
		this.address = address;
		this.email = email;
		this.zipC = zipC;
		this.city = city;
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

	public int getZipC() {
		return zipC;
	}

	public void setZipC(int zipC) {
		this.zipC = zipC;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
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
