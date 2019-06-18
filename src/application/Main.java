package application;
import java.util.Scanner;

import model.MusicFrame;
import model.Musica;

public class Main {

	public static void main(String[] args) {
	
		Musica musica = new Musica();
		
		Scanner ler = new Scanner(System.in);
			
		System.out.println("Digite o comando: ");
	char caractereAnterior = 'a';
	for(int i =0 ; i<4; i++) {
	char entrada = ler.nextLine().charAt(0);
	
	musica.manipulaMusica(entrada, caractereAnterior);
	caractereAnterior = entrada;
	
	}
		
	for(MusicFrame model : musica.getListaFrames()) {
		System.out.println(model.toString());
	}
	
	ler.close();
}
	
}
