package model;

public class Oitava {

	private int codigoOitava;

	public Oitava(int codigoOitava) {
		this.codigoOitava = codigoOitava;
	}

	public int getCodigoOitava() {
		return codigoOitava;
	}
	
	public void aumentaOitava(int novaOitava) {
		this.codigoOitava = novaOitava;
		System.out.println("aumentou oitava em: " + this.codigoOitava);
	}
	
	public void diminuiOitava(int novaOitava) {
		this.codigoOitava = novaOitava;
		System.out.println("diminuiu oitava em: " + this.codigoOitava);
	}

	public String toString() {
		return "Oitava codigoOitava=" + codigoOitava;
	}
	
	
	
}
