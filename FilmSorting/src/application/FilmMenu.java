package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FilmMenu {
	public void start(Stage filmMenu) {
		filmMenu.setTitle("Film Menu");
		filmMenu.setResizable(false);
		BorderPane border = new BorderPane();

		Button filmMenuSogFilm = new Button("Søg efter Film");
		filmMenuSogFilm.setOnAction(e -> {
			SearchFilm searchFilm = new SearchFilm();
			searchFilm.start(new Stage());
			filmMenu.close();
		});
		Button filmMenuTilfojFilm = new Button("Tilføj en Film");
		filmMenuTilfojFilm.setOnAction(e -> {
			InsertFilm insertFilm = new InsertFilm();
			insertFilm.start(new Stage());
			filmMenu.close();
		});
		Button filmMenuAendringer = new Button("Ændrer i en Film");
		filmMenuAendringer.setOnAction(e -> {
			ChangeFilm changeFilm = new ChangeFilm();
			changeFilm.start(new Stage());
			filmMenu.close();
		});

		Button filmTilbageKnap = new Button("Tilbage");
		filmTilbageKnap.setId("indsetTilbageKnap");
		filmTilbageKnap.setOnAction(e -> {
			Program program = new Program();
			program.start(new Stage());
			filmMenu.close();
		});

		VBox vboxKnapper = new VBox(); // top, right, bottom, left
		vboxKnapper.setPadding(new Insets(100, 0, 0, 300));
		vboxKnapper.getChildren().addAll(filmMenuSogFilm, filmMenuTilfojFilm, filmMenuAendringer, filmTilbageKnap);
		vboxKnapper.setSpacing(20);
		border.setCenter(vboxKnapper);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("filmMenu.css").toExternalForm());
		filmMenu.setScene(scene);
		filmMenu.show();
	}
}