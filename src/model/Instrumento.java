package model;

public class Instrumento {

	private String codigoInstrumento;

	public Instrumento(String codigoNovoInstrumento) {
		this.codigoInstrumento = codigoNovoInstrumento;
	}

	public String getCodigoInstrumento() {
		return codigoInstrumento;
	}

	public String toString() {
		return "Instrumento codigoInstrumento=" + this.codigoInstrumento;
	}

}
