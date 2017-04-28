package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Program {

	public void start(Stage program) {
		program.setTitle("Liste Over Film");
		program.setResizable(false);
		BorderPane border = new BorderPane();
		border.setId("border");

		Button programFilm = new Button("Film");
		programFilm.setOnAction(e -> {
			FilmMenu filmMenu = new FilmMenu();
			filmMenu.start(new Stage());
			program.close();
		});

		Button programSeries = new Button("Serier");
		programSeries.setOnAction(e -> {
			SeriesMenu seriesMenu = new SeriesMenu();
			seriesMenu.start(new Stage());
			program.close();
		});

		Button programLukProgram = new Button("Luk program");
		programLukProgram.setOnAction(e -> {
			program.close();
		});

		VBox vboxKnapper = new VBox(); // top,right,bottom,left
		vboxKnapper.setPadding(new Insets(160, 0, 0, 300));
		vboxKnapper.getChildren().addAll(programFilm, programSeries, programLukProgram);
		vboxKnapper.setSpacing(20);
		border.setCenter(vboxKnapper);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("program.css").toExternalForm());
		program.setScene(scene);
		program.show();
	}

}