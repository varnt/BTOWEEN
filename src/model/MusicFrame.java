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
	
	
	
	
	
	
	
	

}
