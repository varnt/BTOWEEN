package controlller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfugue.player.Player;

import model.MusicFrame;
import model.Musica;

public class Arquivo {
	String arquivo;
	Musica musica;
	Player player;

	public Arquivo() {
		// TODO Auto-generated constructor stub
		this.arquivo = "";
		String caminhoArquivo = this.caminhoArquivo(); // escreve caminho arquivo
		this.LeArquivo(caminhoArquivo);				// le caminho arquivo
		this.ProcessaArquivo();						//coloca tudo num string
		this.player = new Player();
		
		for(MusicFrame model : musica.getListaFrames()) {
			System.out.println(model.toString());
				model.executaFrameMusic(this.player);
		}

	}

	public static void main(String[] args) {
		// public static void main(String[] args) {
		Arquivo arquivo = new Arquivo();

	}

	public String caminhoArquivo() {
		System.out.println("Digite o caminho do arquivo: ");
		Scanner scan = new Scanner(System.in);

		String caminhoArquivo = scan.nextLine();
		scan.close();
		return caminhoArquivo;
	}

	public void LeArquivo(String caminhoArquivo) {

		Scanner File = null;
		try {

			File = new Scanner(new java.io.File(caminhoArquivo));
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
				//musica.executaFrameAtual();
			}

		}
	}
}