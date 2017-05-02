package application;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SeriesMenu {
	public void start(Stage seriesMenu) {
		seriesMenu.setTitle("Serie Menu");
		seriesMenu.setResizable(false);

		BorderPane border = new BorderPane();

		Button seriesMenuSogSeries = new Button("Søg efter en Serie");
		seriesMenuSogSeries.setOnAction(e -> {
			SearchSeries searchSeries = new SearchSeries();
			searchSeries.start(new Stage());
			seriesMenu.close();
		});
		Button seriesMenuTilfojSerie = new Button("Tilføj en Serie");
		seriesMenuTilfojSerie.setOnAction(e -> {
			InsertSeries insertSeries = new InsertSeries();
			insertSeries.start(new Stage());
			seriesMenu.close();
		});
		Button seriesMenuAendringer = new Button("Ændrer i en Serie");
		seriesMenuAendringer.setOnAction(e -> {
			seriesMenu.close();
		});

		Button seriesMenuTilbageKnap = new Button("Tilbage");
		seriesMenuTilbageKnap.setId("indsetTilbageKnap");
		seriesMenuTilbageKnap.setOnAction(e -> {
			Program program = new Program();
			program.start(new Stage());
			seriesMenu.close();
		});

		VBox vboxKnapper = new VBox(); // top, right, bottom, left
		vboxKnapper.setPadding(new Insets(100, 0, 0, 300));
		vboxKnapper.getChildren().addAll(seriesMenuSogSeries, seriesMenuTilfojSerie, seriesMenuAendringer,
				seriesMenuTilbageKnap);
		vboxKnapper.setSpacing(20);
		border.setCenter(vboxKnapper);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("seriesMenu.css").toExternalForm());
		seriesMenu.setScene(scene);
		seriesMenu.show();
	}
}
