package controlller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import org.jfugue.player.Player;

import model.MusicFrame;
import model.Musica;

public class Arquivo {
	String arquivo;
	// Musica musica;
	Player player;

	public Arquivo(Musica musica) {
		// TODO Auto-generated constructor stub
		this.arquivo = "";
		// String caminhoArquivo = this.caminhoArquivo(); // escreve caminho arquivo
		// this.LeArquivo(caminhoArquivo); // le caminho arquivo
		// this.ProcessaArquivo(musica); // coloca tudo num string
		// this.player = new Player();

		// for (MusicFrame model : musica.getListaFrames()) {
		// System.out.println(model.toString());
		// model.executaFrameMusic(this.player);
		// }

	}

	/*
	 * public String caminhoArquivo() {
	 * System.out.println("Digite o caminho do arquivo: "); Scanner scan = new
	 * Scanner(System.in);
	 * 
	 * String caminhoArquivo = scan.nextLine(); scan.close(); return caminhoArquivo;
	 * }
	 */

	public String LeArquivo(String caminhoArquivo) {
		System.out.println(caminhoArquivo);
		String conteudoArquivo="";
		
		try {
			Scanner File = new Scanner(new File(caminhoArquivo));

			while (File.hasNextLine()) {
				
				conteudoArquivo += File.nextLine().toString();
				//ConcatenaArquivo(File.nextLine().toString());
			}
			File.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conteudoArquivo;

	}
	
	public void ExibeArquivo(String caminhoArquivo) {
		//System.out.println(caminhoArquivo);

		try {

			Scanner File = new Scanner(new File(caminhoArquivo));

			while (File.hasNextLine()) {

				ConcatenaArquivo(File.nextLine().toString());
			}
			File.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void ConcatenaArquivo(String Linha) {

		this.arquivo = this.arquivo + Linha.toString();
		// System.out.println(this.arquivo);
	}

	public void ProcessaArquivo(Musica musica) {

		for (int i = 0; i < arquivo.length(); i++) {
			if (i > 1) {
				char c0 = arquivo.charAt(i - 1);
				char c1 = arquivo.charAt(i);
				musica.manipulaMusica(c1, c0);
				

			} else {
				char c0 = ' ';
				char c1 = arquivo.charAt(i);

				musica.manipulaMusica(c1, c0);
				// musica.executaFrameAtual();
			}

		}

	}
}