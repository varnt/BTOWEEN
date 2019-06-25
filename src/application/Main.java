package application;

import java.io.IOException;

import controlller.Arquivo;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import model.Musica;

public class Main extends Application {
	@Override
	public void start(Stage stage)
	{
		try {
			Parent parent = FXMLLoader.load(getClass().getResource("/view/View.fxml"));
			Scene scene = new Scene(parent);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);

		Arquivo arquivo = new Arquivo();
		Musica musica = new Musica();
		// Arquivo arquivo = new Arquivo();

		/*
		 * Scanner ler = new Scanner(System.in);
		 * System.out.println("Digite o comando: "); char caractereAnterior = 'a'; for
		 * (int i = 0; i < 10; i++) { char entrada = ler.nextLine().charAt(0);
		 * musica.manipulaMusica(entrada, caractereAnterior);
		 * 
		 * caractereAnterior = entrada;
		 * 
		 * if (musica.ehNota(entrada)) musica.executaFrameAtual(); // ignorar caso
		 * caractere nao seja nota
		 * 
		 * System.out.println(musica.getAtualFrame());
		 * 
		 * }
		 * 
		 * System.out.println("Elementos na lista: "); for (MusicFrame model :
		 * musica.getListaFrames()) { System.out.println(model.toString()); }
		 * 
		 * ler.close();
		 */

	}

}
