package model;
import java.util.ArrayList;

public class Musica {

	private MusicFrame atualFrame;
	ArrayList<MusicFrame> listaFrames = new ArrayList <MusicFrame>();
	
	
	public Musica() {
		
	}
	
	public Musica(MusicFrame atualFrame){
		
		this.atualFrame = atualFrame;
		this.listaFrames.add(atualFrame);
	
	}
	
	public MusicFrame statusMusica() {
	
		return this.atualFrame;
		
	
	}
	
	public void manipulaSom(int comando) {
		
		
		//switch();
		

		
		}
		
		
		
		
	}
	
