package model;

public class Oitava {

	private String codigoOitava;
	private int codigoModificadordeOitava;

	public Oitava(String oitavaDefault) {
		this.codigoOitava = oitavaDefault;
		this.codigoModificadordeOitava = 0;
	}

	public String getCodigoOitava() {
		return codigoOitava;
	}
	
	public int getcodigoModificadordeOitava() {
		return this.codigoModificadordeOitava;
	}
	
	public void setcodigoModificadordeOitava(int codigoModificador) {
		this.codigoModificadordeOitava = codigoModificador;
	}
	
	public void aumentaOitava(String novaOitava) {
		this.codigoOitava = novaOitava;
		System.out.println("aumentou oitava em: " + this.codigoOitava);
	}
	
	public void diminuiOitava(String novaOitava) {
		this.codigoOitava = novaOitava;
		System.out.println("diminuiu oitava em: " + this.codigoOitava);
	}

	public String toString() {
		return "Oitava codigoOitava=" + this.codigoOitava;
	}
	
	
	
}
