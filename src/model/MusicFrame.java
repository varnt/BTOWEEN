package model;

public class MusicFrame {
	
	private Oitava Oitava;
	private Nota Nota;
	private Instrumento Instrumento;
	private BPM BPM;
	
	public MusicFrame() {
		
	}
	
	public MusicFrame(int codigoOitava, int codigoNota, int codigoInstrumento, int codigoBPM) {
		
		this.Oitava = new Oitava(codigoOitava);
		this.Nota = new Nota(codigoNota);
		this.Instrumento = new Instrumento(codigoInstrumento);
		this.BPM = new BPM(codigoBPM);
	
	}

	public Oitava getOitava() {
		return Oitava;
	}

	public Nota getNota() {
		return Nota;
	}

	public Instrumento getInstrumento() {
		return Instrumento;
	}

	public BPM getBPM() {
		return BPM;
	}
	
	public void setOitava(Oitava oitava) {
		this.Oitava = oitava;
		return;
	}

	public void setNota(Nota nota) {
		this.Nota=nota;
		return;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.Instrumento=instrumento;
		return;
	}

	public void setBPM(BPM bpm) {
		this.BPM = bpm;
		return;
	}
	
	
	
	
	
	

}
