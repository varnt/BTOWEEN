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

	}

	public static void main(String[] args) {
		// public static void main(String[] args) {
		Arquivo arquivo = new Arquivo();

	}

	public void LeArquivo() {
		// TODO Auto-generated method stub
		Scanner diskScanner = null;
		Scanner File = null;
		try {
			diskScanner = new Scanner(new java.io.File("C:\\testanto.txt"));
			File = new Scanner(new java.io.File("C:\\testanto.txt"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		while (diskScanner.hasNextLine()) {
			System.out.println(diskScanner.nextLine());
		}
		while (File.hasNextLine()) {
			this.ConcatenaArquivo(File.nextLine().toString());
		}
	}

	public void ConcatenaArquivo(String Linha) {
		this.arquivo = Linha.toString();
		System.out.println(this.arquivo);
	}

	public void ProcessaArquivo() {
		for (int i = 0; i < this.arquivo.length(); i++) {
			char c0 = this.arquivo.charAt(i - 1);
			char c1 = this.arquivo.charAt(i);
			this.musica.manipulaMusica(c1, c0);

		}
	}
}