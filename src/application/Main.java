package application;
import java.util.Scanner;

import model.Musica;

public class Main {

	public static void main(String[] args) {
	
		Musica musica = new Musica();
		
		Scanner ler = new Scanner(System.in);
			
		System.out.println("Digite o comando: ");
		
		char entrada = ler.nextLine().charAt(0);

		switch(entrada){
		
		case 'A':
			//LA = 69
			musica.mudaNota(69);
		break;
		
		case 'B':
			//RE = 62
			musica.mudaNota(62);
		break;
		
			}
		
		System.out.println("Elementos na lista: " + musica.tamanhoLista() + "\n" + musica.frameAtual().toString());


}
	
}
