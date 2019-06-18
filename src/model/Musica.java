package model;
import java.util.ArrayList;

public class Musica {

	private MusicFrame atualFrame;
	private ArrayList<MusicFrame> listaFrames;
	
	
	public ArrayList<MusicFrame> getListaFrames() {
		return this.listaFrames;
	}

	public Musica() {
		this.atualFrame = new MusicFrame();
		this.listaFrames = new ArrayList <MusicFrame>();
	}
	
	public Musica(MusicFrame atualFrame){
		
		this.atualFrame = atualFrame;
		this.listaFrames.add(atualFrame);
	}
	
	public void adicionaNovoFrame(MusicFrame novoFrame){
		
		this.listaFrames.add(novoFrame);
		
	}
	
	public MusicFrame frameAtual() {
	
		return this.atualFrame;
		
	}
	
	public int tamanhoLista() {
		return this.listaFrames.size();
	}
	
	//modificar os parametros para serem enviados os respectivos objetos
	//60 62 64 65 67 69 71 codigos das notas
	public void mudaNota(int codigoNovaNota){
		final MusicFrame novoFrame;
		final Nota novaNota = new Nota(codigoNovaNota);		
		novoFrame = new MusicFrame(novaNota, this.atualFrame);		
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
			System.out.println(novoFrame.getNota() +" adicionada");	
	}
	
	public void mudaOitava(int codigoNovaOitava) {
		final MusicFrame novoFrame;
		final Oitava novaOitava = new Oitava(codigoNovaOitava);
		novoFrame = new MusicFrame(novaOitava, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
			System.out.println(novoFrame.getOitava() + "adicionada");
	}
	
	public void mudaInstrumento(int codigoNovoInstrumento){
		final MusicFrame novoFrame;
		final Instrumento novoInstrumento = new Instrumento(codigoNovoInstrumento);
		novoFrame = new MusicFrame(novoInstrumento, this.atualFrame);		
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
			System.out.println(novoFrame.getInstrumento() + "adicionado");
		
	}
	
	public void mudaBPM(int codigoNovoBPM) {
		final MusicFrame novoFrame;
		final BPM novoBPM = new BPM(codigoNovoBPM);
		novoFrame = new MusicFrame(novoBPM, this.atualFrame);
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
			System.out.println(novoFrame.getBPM() + "adicionado");
	
	}
	
	
	
}

	
