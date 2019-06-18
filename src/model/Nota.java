package model;

public class Nota {

	private int codigoNota;

	public Nota(int codigoNota) {
		this.codigoNota = codigoNota;
	}

	public int getCodigoNota() {
		return codigoNota;
	}

	public void setCodigoNota(int codigoNota) {
		this.codigoNota = codigoNota;
		return;
	}

	public String toString() {
		return "Nota codigoNota=" + this.codigoNota;

	}

}
