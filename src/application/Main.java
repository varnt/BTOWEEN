package application;
import java.util.Scanner;

import model.Musica;

public class Main {

	public static void main(String[] args) {
	
		Musica musica = new Musica();
		
		Scanner ler = new Scanner(System.in);
		
		//1 para auemntar oitava
		//2 para diminuir oitava
		while(ler.nextInt()!=0) {
			
		System.out.println("Digite o comando: ");
		
		
		int oitava = ler.nextInt();
		
		musica.manipulaSom(oitava);
		
		}
		
		ler.close();
		
		
	}

}
