package model;
import java.util.ArrayList;

public class Musica {

	private MusicFrame atualFrame;
	ArrayList<MusicFrame> listaFrames;
	
	
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
	
	public MusicFrame statusMusica() {
	
		return this.atualFrame;
		
	
	}
	
//ver qual vai ser o tipo de parametro!
	//60 62 64 65 67 69 71 codigos das notas
	public void mudaNota(int codigoNovaNota){

		final MusicFrame novoFrame;

		final Nota novaNota = new Nota(codigoNovaNota);
		
		novoFrame = new MusicFrame(novaNota, atualFrame);
		
		this.adicionaNovoFrame(novoFrame);
		this.atualFrame = novoFrame;
			System.out.println("nota A adicionada");

	
	}
	
	}