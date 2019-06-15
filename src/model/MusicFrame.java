package model;

public class MusicFrame {
	
	private Oitava Oitava;
	private Nota Nota;
	private Instrumento Instrumento;
	private BPM BPM;
	
	public MusicFrame() {
		//valores default
		this.Oitava = new Oitava(1);
		this.Nota = new Nota(1);
		this.Instrumento = new Instrumento(1);
		this.BPM = new BPM(1);
	}
	
	public MusicFrame(int codigoOitava, int codigoNota, int codigoInstrumento, int codigoBPM) {
		
		this.Oitava = new Oitava(codigoOitava);
		this.Nota = new Nota(codigoNota);
		this.Instrumento = new Instrumento(codigoInstrumento);
		this.BPM = new BPM(codigoBPM);
	
	}

	//novo frame para quando trocar apenas nota
	public MusicFrame(Nota NovaNota, MusicFrame frameAtual) {
			this.Nota = NovaNota;
			this.BPM = frameAtual.BPM;
			this.Instrumento = frameAtual.Instrumento;
			this.Oitava = frameAtual.Oitava;
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
	
	public String toString() {
		
		return (""+ this.Nota + "\n" +
						this.Oitava + "\n" +
						this.Instrumento + "\n" +
						this.BPM +"\n");
	}
	
	

}
