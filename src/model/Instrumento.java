package model;

public class Instrumento{
	
	private int codigoInstrumento;

	public Instrumento(int codigoInstrumento){
		this.codigoInstrumento = codigoInstrumento;
	}

	public int getCodigoInstrumento(){
		return codigoInstrumento;
	}

	public String toString() {
		return "Instrumento codigoInstrumento=" + codigoInstrumento;
	}
	
	
	
}
