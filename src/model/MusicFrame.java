package model;

public class MusicFrame {
	
	private Integer a=1;
	private Nota Nota;
	private Instrumento Instrumento;
	private BPM BPM;	
	
	
	
	public MusicFrame() {	
	}
	
	public MusicFrame(model.Oitava oitava, model.Nota nota, model.Instrumento instrumento, model.BPM bPM){
		this.Oitava = oitava;
		this.Nota = nota;
		this.Instrumento = instrumento;
		this.BPM= bPM;
	}
	
	
	
	

}
