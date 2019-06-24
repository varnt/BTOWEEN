package model;

public class Volume {
	
	private String codigoVolume;
	
	
	public Volume(String volumeDefault) {
		this.codigoVolume = volumeDefault;
	}

	public String getCodigoVolume() {
		return this.codigoVolume;
	}
	
	
	public String toString() {
		return "Volume = " + this.codigoVolume;
	}
	
	
	

}
