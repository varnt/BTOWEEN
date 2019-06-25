package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import model.Musica;

public class viewController {

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
	public void onbtVolUPAction() {
		System.out.println("Vol UP");
		//mudavolume();
	}
	
	@FXML
	public void onbtVolDOWNAction() {
		System.out.println("Vol DOWN");
		//mudavolume();
	}
	
	@FXML
	public void onPLayPauseAction() {
		System.out.println("PlayPause");
		//mudavolume();
	}
	
	@FXML
	public void onMusicaLivreAction() {
		System.out.println("MusicaLivre");
		//mudavolume();
	}
	
	@FXML
	public void onSalvarAction() {
		System.out.println("Salvar");
		//mudavolume();
	}

	public viewController() {
		// TODO Auto-generated constructor stub

	}

	/*
	 * public static void main(String[] args) { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
