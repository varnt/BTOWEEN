package controlller;

import java.io.*;
import java.util.Scanner;

public class MusicaLivre {

	public MusicaLivre() {
		// TODO Auto-generated constructor stub

		// private ArrayList<char> atualmusica;

	}

	public static void main(String[] args) throws FileNotFoundException {
		// String arquivo = System.in.toString();
		Scanner teclado = new Scanner(System.in);

		System.out.println("Digite o caminho do arquivo: ");
		

		File evidence = new File(teclado.toString());
		System.out.println(evidence);

	}

	public void LeEntrada(String CaminhoArquivo) throws Exception {
		FileReader fr = new FileReader(CaminhoArquivo);
		BufferedReader br = new BufferedReader(fr);

		int i;
		while ((i = br.read()) != -1) {
			System.out.print((char) i);
			manipulaMusica()
		}
		br.close();
		fr.close();

	}

}
