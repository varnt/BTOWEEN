package application;
import java.util.Scanner;

import org.jfugue.player.Player;

import model.MusicFrame;
import model.Musica;
import model.Nota;
import controlller.Arquivo;

public class Main {

	public static void main(String[] args) {
				
		//Arquivo arquivo = new Arquivo();
		Musica musica = new Musica();
		
	Scanner ler = new Scanner(System.in);
			
	System.out.println("Digite o comando: ");
	char caractereAnterior = 'a';

	for(int i =0 ; i<4; i++) {
	
	char entrada = ler.nextLine().charAt(0);
	
	musica.manipulaMusica(entrada, caractereAnterior);
	caractereAnterior = entrada;
	musica.executaFrameAtual();	
	}
	
	System.out.println("Elementos na lista: ");
	for(MusicFrame model : musica.getListaFrames()) {
		System.out.println(model.toString());
	}
	
	ler.close();
}

}
