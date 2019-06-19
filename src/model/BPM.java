package model;

public class BPM {

	private String codigoBPM;

	public BPM(String bpmDefault) {
		this.codigoBPM = bpmDefault;
	}

	public String getCodigoBPM() {
		return codigoBPM;
	}

	public String toString() {
		return "BPM codigoBPM=" + this.codigoBPM;
	}

}
