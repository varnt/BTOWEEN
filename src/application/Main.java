package application;
import java.util.Scanner;

import model.MusicFrame;
import model.Musica;

public class Main {

	public static void main(String[] args) {
	
		Musica musica = new Musica();
		
		Scanner ler = new Scanner(System.in);
			
		System.out.println("Digite o comando: ");
	
	for(int i =0 ; i<4; i++) {
	char entrada = ler.nextLine().charAt(0);
	//colocar esse switch na classe Musica. Onde vai ter um método "controladorDeSom"
	//e para cada codigo faz-se a ação necessária
	//não enviar um magic number, mas sim o objeto a ser adicionado no novo frameMusic
	switch(entrada){
	
	case 'A':
		//LA = 69
		musica.mudaOitava(69);
	break;
	
	case 'B':
		//RE = 62
		musica.mudaNota(62);
	break;
	
		}
	
	}
		
	for(MusicFrame model : musica.getListaFrames()) {
		System.out.println(model.toString());
	}
	
	ler.close();
}
	
}
