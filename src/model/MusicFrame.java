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
	public MusicFrame(model.Nota NovaNota, MusicFrame atualFrame) {
			this.Nota = NovaNota;
			this.BPM = atualFrame.BPM;
			this.Instrumento = atualFrame.Instrumento;
			this.Oitava = atualFrame.Oitava;
	}
	
	
	//quando trocar apenas oitava
	public MusicFrame(model.Oitava novaOitava, MusicFrame atualFrame) {
		this.Oitava = novaOitava;
		this.BPM = atualFrame.BPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Nota= atualFrame.Nota;
	
	}
	
	//quando trocar apenas instrumento
	public MusicFrame(model.Instrumento novoInstrumento, MusicFrame atualFrame) {
		this.Instrumento = novoInstrumento;
		this.BPM = atualFrame.BPM;
		this.Nota = atualFrame.Nota;
		this.Oitava = atualFrame.Oitava;		
	}

	//quando trocar apenas BPM
	public MusicFrame(model.BPM novoBPM, MusicFrame atualFrame) {
		this.BPM = novoBPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Nota = atualFrame.Nota;
		this.Oitava = atualFrame.Oitava;
		
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
