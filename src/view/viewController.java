package view;

import java.io.IOException;
import java.util.Scanner;

import org.jfugue.player.Player;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.MusicFrame;
import model.Musica;
import controlller.Arquivo;
import javafx.application.Application;


public class viewController extends Application {

	private String volumeAtual; //valor que tem no volume
	private String volumeSolicitado;

	
	@Override
	public void start(Stage stage) {
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button btVolUP;
	@FXML
	private Button btVolDOWN;
	@FXML
	private Button playPause;
	@FXML
	private Button MusicaLivre;
	@FXML
	private Button Salvar;

	@FXML
	
	public void setVolumeAtual(String VolumeSolicitado) {
		this.volumeSolicitado = VolumeSolicitado;
	}
	public String getVolumeAtual() {
		return this.volumeAtual;
	}

	public void onbtVolUPAction() {
		System.out.println("Vol UP");

		this.setVolumeAtual("UP");
	}

	@FXML
	public void onbtVolDOWNAction() {
		System.out.println("Vol DOWN");
		this.setVolumeAtual("DOWN");
	}


	@FXML
	public void onPLayPauseAction() {
		System.out.println("PlayPause");
		// mudavolume();
	}

	@FXML
	public void onMusicaLivreAction() {
		System.out.println("MusicaLivre");
		// mudavolume();
	}

	@FXML
	public void onSalvarAction() {
		System.out.println("Salvar");
		// mudavolume();
	}

	public viewController() {
		// TODO Auto-generated constructor stub

	}

	public static void main(String[] args) {

		launch(args); //descomentar
		// Arquivo arquivo = new Arquivo();
		Musica musica = new Musica(this.getVolumeAtual());
		Arquivo arquivo = new Arquivo(musica);

		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o comando: ");
		char caractereAnterior = 'a';
		for (int i = 0; i < 5; i++) {
			char entrada = ler.nextLine().charAt(0);
			musica.manipulaMusica(entrada, caractereAnterior);

			caractereAnterior = entrada;

			if (musica.ehNota(entrada))
				musica.executaFrameAtual(); // ignorar caso caractere nao seja nota

			System.out.println(musica.getAtualFrame());

		}

		System.out.println("Elementos na lista: ");
		for (MusicFrame model : musica.getListaFrames()) {
			System.out.println(model.toString());
		}
		musica.salvaMIDI();

		ler.close();

	}

}
