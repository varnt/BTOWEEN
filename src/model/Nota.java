package model;
import org.jfugue.*;
import org.jfugue.pattern.PatternProducer;
import org.jfugue.player.Player; 

public class Nota {

	private String codigoNota;

	public Nota(String codigoNota) {
		this.codigoNota = codigoNota;
	}

	public String getCodigoNota() {
		return codigoNota;
	}

	public void setCodigoNota(String codigoNota) {
		this.codigoNota = codigoNota;
		return;
	}

	public String toString() {
		return "Nota codigoNota=" + this.codigoNota;

	}
	
	public void tocaNota (String codigoNota, Player player) {     
		player.play(codigoNota);
		return;
	}

}
