package view;

import java.io.File;
import java.io.IOException;
import controlller.Arquivo;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import model.MusicFrame;
import model.Musica;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;


public class viewController extends Application {

	private String volumeAtual; //valor que tem no volume
	private String volumeSolicitado;
	private Musica musica;
	private Arquivo arquivo;
	private Player player;


	
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
	private Button AbrirArquivo;
	
	@FXML
	private TextArea AreaTexto;
	
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
		for (MusicFrame model : musica.getListaFrames()) {
			//musica.executaFrameAtual(player);
			model.executaFrameMusic(player);
		}
	}

	@FXML
	public void onMusicaLivreAction() {
		System.out.println("MusicaLivre");
		// mudavolume();
	}

	@FXML
	public void onSalvarAction() {
		System.out.println("Salvar");
		
		if(this.musica.salvaMIDI()) {
			//inserir text box que diz que arquivo foi salvo
		}
		else {
			//text box 
		}
			
	
	}
	
	@FXML
	public void onAbrirArquivoAction() {
		FileChooser fc = new FileChooser();
		File selectedFile = fc.showOpenDialog(null);
		String caminhoArquivo;
		if (selectedFile != null) {
			 caminhoArquivo = selectedFile.getAbsolutePath();
			 this.arquivo.LeArquivo(caminhoArquivo);
			 System.out.println("processa");
			 this.arquivo.ProcessaArquivo(musica);
		}
		else
		{}
		
		
	}
	
	
	


	public viewController() {
		// TODO Auto-generated constructor stub
		this.player = new Player();
		 this.musica = new Musica(this.player);
		 this.arquivo = new Arquivo(this.musica);
	}

	public static void main(String[] args) {

		launch(args); //descomentar
		// Arquivo arquivo = new Arquivo();
	
		/*

		Scanner ler = new Scanner(System.in);
		System.out.println("Digite o comando: ");
		char caractereAnterior = 'a';
		for (int i = 0; i < 5; i++) {
			char entrada = ler.nextLine().charAt(0);
			this.musica.manipulaMusica(entrada, caractereAnterior);

			caractereAnterior = entrada;

			if (this.musica.ehNota(entrada))
				this.musica.executaFrameAtual(); // ignorar caso caractere nao seja nota

			System.out.println(this.musica.getAtualFrame());

		}

		System.out.println("Elementos na lista: ");
		for (MusicFrame model : this.musica.getListaFrames()) {
			System.out.println(model.toString());
		}
		//this.musica.salvaMIDI();

		ler.close();
		*/

	}

}
