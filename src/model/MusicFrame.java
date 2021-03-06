package model;

import org.jfugue.player.Player;

public class MusicFrame {

	private Oitava Oitava;
	private Nota Nota;
	private Instrumento Instrumento;
	private BPM BPM;
	private Volume Volume;
	
	private static final String OITAVA_DEFAULT = "4"; 
	private static final String NOTA_DEFAULT = "60";
	private static final String INSTR_DEFAULT = "PIANO";
	private static final String BPM_DEFAULT = "120";
	private static final String VOLUME_DEFAULT = "50";
	private static final int VOLUME_MAX = 127;


	public MusicFrame() {

		this.Oitava = new Oitava(OITAVA_DEFAULT);
		this.Nota = new Nota(NOTA_DEFAULT);
		this.Instrumento = new Instrumento(INSTR_DEFAULT);
		this.BPM = new BPM(BPM_DEFAULT);
		this.Volume = new Volume(VOLUME_DEFAULT);
	}

	public MusicFrame(String codigoOitava, String codigoNota, String codigoInstrumento, String codigoBPM, String codigoVolume) {

		this.Oitava = new Oitava(codigoOitava);
		this.Nota = new Nota(codigoNota);
		this.Instrumento = new Instrumento(codigoInstrumento);
		this.BPM = new BPM(codigoBPM);
		this.Volume = new Volume(codigoVolume);

	}

	// novo  para quando trocar apenas nota
	public MusicFrame(model.Nota NovaNota, MusicFrame atualFrame) {
		this.Nota = NovaNota;
		this.BPM = atualFrame.BPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Oitava = atualFrame.Oitava;
		this.Volume = atualFrame.Volume;
	}

	// quando trocar apenas oitava
	public MusicFrame(model.Oitava novaOitava, MusicFrame atualFrame) {
		this.Oitava = novaOitava;
		this.BPM = atualFrame.BPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Nota = atualFrame.Nota;
		this.Volume = atualFrame.Volume;

	}

	// quando trocar apenas instrumento
	public MusicFrame(model.Instrumento novoInstrumento, MusicFrame atualFrame) {
		this.Instrumento = novoInstrumento;
		this.BPM = atualFrame.BPM;
		this.Nota = atualFrame.Nota;
		this.Oitava = atualFrame.Oitava;
		this.Volume = atualFrame.Volume;
	}

	// quando trocar apenas BPM
	public MusicFrame(model.BPM novoBPM, MusicFrame atualFrame) {
		this.BPM = novoBPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Nota = atualFrame.Nota;
		this.Oitava = atualFrame.Oitava;
		this.Volume = atualFrame.Volume;

	}

	//quando troca apenas volume
	public MusicFrame(model.Volume novoVolume, MusicFrame atualFrame) {
		this.Volume = novoVolume;
		this.BPM = atualFrame.BPM;
		this.Instrumento = atualFrame.Instrumento;
		this.Nota = atualFrame.Nota;
		this.Oitava = atualFrame.Oitava;
		
	}
	
	public void executaFrameMusic(Player player) {
		
		int modificadorOitava = this.Oitava.getcodigoModificadordeOitava();
		String nota = Integer.toString((Integer.parseInt(this.Nota.getCodigoNota())+ modificadorOitava));
		String volume = (":CON(7, " + this.Volume.getCodigoVolume() + ") ");
		String instrumento = this.getCodigotInstrumento();
		
		String som = (volume + instrumento + " " + nota);
		
		player.play(som);
		return;
	}
	
	public void executaFrameMusicAlterandoVolume(Player player, int codigoVolume) {
		
		int volumeAlterado = Integer.parseInt(this.getCodigoVolume()) + codigoVolume;
		volumeAlterado = Math.min(volumeAlterado, VOLUME_MAX);
		if(volumeAlterado > VOLUME_MAX)
			volumeAlterado= VOLUME_MAX;	
		else if(volumeAlterado < 0)
				volumeAlterado= 0;		

		String tempo = "T" + this.getCodigoBPM();
		
//		String som = (tempo + " " + volume + instrumento + " " + nota);
		
		int modificadorOitava = this.Oitava.getcodigoModificadordeOitava();
		String nota = Integer.toString((Integer.parseInt(this.Nota.getCodigoNota())+ modificadorOitava));
		String volume = (":CON(7, " + Integer.toString(volumeAlterado) + ") ");
		String instrumento = this.getCodigotInstrumento();
		String som = (tempo + " " + volume + instrumento + " " + nota);
		player.play(som);
		
		
		return;
	}
	
	public String retornaSomParaSalvar() {
		int modificadorOitava = this.Oitava.getcodigoModificadordeOitava();
		String nota = Integer.toString((Integer.parseInt(this.Nota.getCodigoNota())+ modificadorOitava));
		String volume = (":CON(7, " + this.Volume.getCodigoVolume() + ") ");
		String instrumento = this.getCodigotInstrumento();
		
		String som = (volume + instrumento + " " + nota);
	
		return som;
	}
	

	public String getCodigoOitava() {
		return this.Oitava.getCodigoOitava();
	}
	
	public Oitava getOitava() {
		return this.Oitava;
	}

	public Nota getCodigoNota() {
		return Nota;
	}
	
	public int getcodigoModificadorOitava() {
		return this.Oitava.getcodigoModificadordeOitava();
	}

	public String getCodigotInstrumento() {
		return this.Instrumento.getCodigoInstrumento();
	}

	public String getCodigoBPM() {
		return this.BPM.getCodigoBPM();
	}
	
	public String getCodigoVolume() {
		return this.Volume.getCodigoVolume();
	}

	public void setOitava(Oitava oitava) {
		this.Oitava = oitava;
		return;
	}

	public void setNota(Nota nota) {
		this.Nota = nota;
		return;
	}

	public void setInstrumento(Instrumento instrumento) {
		this.Instrumento = instrumento;
		return;
	}

	public void setBPM(BPM bpm) {
		this.BPM = bpm;
		return;
	}
	
	public void setVolume(Volume volume) {
		this.Volume = volume;
		return;
	}
	

	public String toString() {

		return ("" + this.Nota + "\n" + this.Oitava + "\n" + this.Instrumento + "\n" + this.BPM + "\n" + this.Volume + "\n");
	}

}
