package model;

public class Volume {
	
	private double codigoVolume;
	
	
	public Volume(double codigoVolume) {
		this.codigoVolume = codigoVolume;
	}

	public double getCodigoVolume() {
		return this.codigoVolume;
	}
	
	public void mudaVolume(int codigoVolume) {
		
	}
	
	public String toString() {
		return "Volume codigoVolume=" + this.codigoVolume;
	}
	
	
	

}
