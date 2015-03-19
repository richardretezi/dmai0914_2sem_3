package modelLayer;

public class GunReplicas extends Product{
	
	private String fabric;
	private String calibre;
	
	public GunReplicas(){
		super();
	}
	
	public GunReplicas(String fabric, String calibre){
		super();
		this.fabric = fabric;
		this.calibre = calibre;
		
	}

	public String getFabric() {
		return fabric;
	}

	public void setFabric(String fabric) {
		this.fabric = fabric;
	}

	public String getCalibre() {
		return calibre;
	}

	public void setCalibre(String calibre) {
		this.calibre = calibre;
	}
}
