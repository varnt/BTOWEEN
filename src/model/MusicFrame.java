package model;

public class MusicFrame {
	
	private Oitava Oitava;
	private Nota Nota;
	private Instrumento Instrumento;
	private BPM BPM;
	
	
	public MusicFrame() {
		
		
		
	}
	
	public MusicFrame(model.Oitava oitava, model.Nota nota, model.Instrumento instrumento, model.BPM bPM) {

		this.Oitava = oitava;
		this.Nota = nota;
		this.Instrumento = instrumento;
		this.BPM= bPM;
		
	}
	
	

}
