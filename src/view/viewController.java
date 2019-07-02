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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import model.MusicFrame;
import model.Musica;
import org.jfugue.midi.MidiFileManager;
import org.jfugue.pattern.Pattern;
import org.jfugue.player.Player;

public class viewController extends Application {

	private static final int VOLUME_MAX = 127;

	private int volumeAtual; // valor que tem no volume do frame + o volume solicitado

	private int volumeSolicitado = 0;

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
//			this.atualizaGUI();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	private Button btVolUP;
	@FXML
	private Button btVolDOWN;
	@FXML
	private Button Play;
	//@FXML
	//private Button MusicaLivre;
	@FXML
	private Button Salvar;
	@FXML
	private Button AbrirArquivo;

	@FXML
	private TextArea AreaTexto;

	@FXML
	private TextField txtVolumeAtual;

	@FXML
	private TextField txtNotaAtual;

	@FXML
	private TextField txtInstrumentoAtual;

	@FXML
	private TextField txtBPMAtual;

	@FXML
	private TextField txtOitavaAtual;

	@FXML
	private void atualizaGUI() {
		txtVolumeAtual.setText(Integer.toString(this.volumeAtual));
		txtNotaAtual.setText(this.musica.getAtualFrame().getCodigoNota().getCodigoNota());
		txtInstrumentoAtual.setText(this.musica.getAtualFrame().getCodigotInstrumento());
		txtBPMAtual.setText(this.musica.getAtualFrame().getCodigoBPM());
		txtOitavaAtual.setText(this.musica.getAtualFrame().getCodigoOitava());
	}

	@FXML
	public void setVolumeAtual(int volumeSolicitado) {

		int volume = Integer.parseInt(this.musica.getAtualFrame().getCodigoVolume()) + volumeSolicitado;

		if (volume > VOLUME_MAX)
			this.volumeAtual = VOLUME_MAX;
		else if (volume < 0)
			this.volumeAtual = 0;
		else
			this.volumeAtual = volume;

		atualizaGUI();
	}

	public int getVolumeAtual() {
		return this.volumeAtual;
	}

	@FXML
	public void onbtVolUPAction() {

		System.out.println("Vol UP");

		int vol = this.volumeSolicitado += 1;

		this.setVolumeAtual(vol);
		System.out.println("volume solicitado: " + this.volumeSolicitado);
		System.out.println("volume atual: " + this.volumeAtual);

		atualizaGUI();
		return;

	}

	@FXML
	public void onbtVolDOWNAction() {
		System.out.println("Vol DOWN");

		int vol = this.volumeSolicitado -= 1;
		this.setVolumeAtual(vol);
		System.out.println("volume solicitado: " + this.volumeSolicitado);
		System.out.println("volume atual: " + this.volumeAtual);

		atualizaGUI();
		return;
	}

	/*@FXML
	public void onPLayPauseAction() {
		System.out.println("PlayPause");
		
		for (MusicFrame model : musica.getListaFrames()) {
			model.executaFrameMusicAlterandoVolume(player, volumeSolicitado);
		}

		atualizaGUI();
		return;
	}*/

	@FXML
	public void onPlayButtonAction() {
		System.out.println("MusicaLivre");

		
		String entrada = AreaTexto.getText();
		System.out.println(entrada);
		
		musica.getListaFrames().clear();
		char caractereAnterior = '0';
		for (int i = 0; i < entrada.length(); i++){
			musica.manipulaMusica(entrada.charAt(i), caractereAnterior);
		
		}
		
		for (MusicFrame model : musica.getListaFrames()) {
			model.executaFrameMusicAlterandoVolume(player, volumeSolicitado);
			atualizaGUI();
			
		}

	}

	@FXML
	public void onSalvarAction() {
		System.out.println("Salvar");

		if (this.musica.salvaMIDI()) {
			// inserir text box que diz que arquivo foi salvo
		} else {
			// text box
		}

		atualizaGUI();
		return;
	}

	@FXML
	public void onAbrirArquivoAction() {
		
		FileChooser fc = new FileChooser();
		
		File selectedFile = fc.showOpenDialog(null);
		
		String caminhoArquivo;
		String conteudoParaTextArea="";
		
		if (selectedFile != null) {
			caminhoArquivo = selectedFile.getAbsolutePath();
			conteudoParaTextArea = this.arquivo.LeArquivo(caminhoArquivo);
			System.out.println("processa");
			AreaTexto.setText(conteudoParaTextArea);
			this.arquivo.ProcessaArquivo(musica);
			
		} 
		else {
		}

		atualizaGUI();
		return;
	}

	public viewController() {
		// TODO Auto-generated constructor stub
		this.player = new Player();
		this.musica = new Musica(this.player);
		this.arquivo = new Arquivo(this.musica);
	}

	public static void main(String[] args) {

		launch(args); // descomentar
		// Arquivo arquivo = new Arquivo();

		/*
		 * 
		 * Scanner ler = new Scanner(System.in);
		 * System.out.println("Digite o comando: "); char caractereAnterior = 'a'; for
		 * (int i = 0; i < 5; i++) { char entrada = ler.nextLine().charAt(0);
		 * this.musica.manipulaMusica(entrada, caractereAnterior);
		 * 
		 * caractereAnterior = entrada;
		 * 
		 * if (this.musica.ehNota(entrada)) this.musica.executaFrameAtual(); // ignorar
		 * caso caractere nao seja nota
		 * 
		 * System.out.println(this.musica.getAtualFrame());
		 * 
		 * }
		 * 
		 * System.out.println("Elementos na lista: "); for (MusicFrame model :
		 * this.musica.getListaFrames()) { System.out.println(model.toString()); }
		 * //this.musica.salvaMIDI();
		 * 
		 * ler.close();
		 */

	}

}
