package controlller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import model.Musica;

public class Arquivo {
	String arquivo;
	Musica musica;

	public Arquivo() {
		// TODO Auto-generated constructor stub
		this.arquivo = "";
		this.LeArquivo();
		this.ProcessaArquivo();
		

	}

	public static void main(String[] args) {
		// public static void main(String[] args) {
		Arquivo arquivo = new Arquivo();

	}

	public void LeArquivo() {
		// TODO Auto-generated method stub

		Scanner File = null;
		try {

			File = new Scanner(new java.io.File("C:\\testanto.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		while (File.hasNextLine()) {
			this.ConcatenaArquivo(File.nextLine().toString());
		}
	}

	public void ConcatenaArquivo(String Linha) {
		this.arquivo = this.arquivo + Linha.toString();
		// System.out.println(this.arquivo);
	}

	public void ProcessaArquivo() {
		this.musica = new Musica(); 
		for (int i = 0; i < this.arquivo.length(); i++) {
			if (i > 1) {
				char c0 = this.arquivo.charAt(i - 1);
				char c1 = this.arquivo.charAt(i);
				this.musica.manipulaMusica(c1, c0);
				
			} else {
				char c0 = ' ';
				char c1 = this.arquivo.charAt(i);
				
				this.musica.manipulaMusica(c1, c0);
			}

		}
	}
}