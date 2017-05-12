package application;

import domain.DomainClassSeries;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.SeriesSortImpl;
import logic.SeriesSortInterface;

public class InsertSeries {
	public void start(Stage insertSeries) {
		insertSeries.setTitle("Tilføj en Serie");
		insertSeries.setResizable(false);
		BorderPane border = new BorderPane();

		Label indsetNavnLabel = new Label("Tilføj Danske Titel   : ");
		Label indsetNameLabel = new Label("Tilføj Engelske Titel : ");
		Label indsetAarstalLabel = new Label("Tilføj Udgivelsesår    : ");
		Label indsetSeasonLabel = new Label("Tilføj Season/Nr.    : ");
		TextField indsetNavnTekstfelt = new TextField();
		TextField indsetNameTekstfelt = new TextField();
		TextField indsetAarstalTekstfelt = new TextField();
		TextField indsetSeasonTekstfelt = new TextField();

		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(indsetNavnLabel, indsetNameLabel, indsetAarstalLabel, indsetSeasonLabel);
		indsetLabelVBox.setSpacing(10);
		border.setLeft(indsetLabelVBox);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(indsetNavnTekstfelt, indsetNameTekstfelt, indsetAarstalTekstfelt,
				indsetSeasonTekstfelt);
		indsetTextFieldVBox.setSpacing(10);
		border.setRight(indsetTextFieldVBox);

		Button indsetTilfojKnap = new Button("Tilføj");
		indsetTilfojKnap.setOnAction(e -> {
			try {
				SeriesSortInterface fsi = new SeriesSortImpl();
				DomainClassSeries sdomain = new DomainClassSeries();
				sdomain.setNavn(indsetNavnTekstfelt.getText());
				sdomain.setName(indsetNameTekstfelt.getText());
				sdomain.setAarstal(indsetAarstalTekstfelt.getText());
				sdomain.setSeason(Integer.parseInt(indsetSeasonTekstfelt.getText()));
				fsi.tilfojEnSerie(sdomain);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Button indsetTilbageKnap = new Button("Tilbage");
		indsetTilbageKnap.setOnAction(e -> {
			SeriesMenu seriesMenu = new SeriesMenu();
			seriesMenu.start(new Stage());
			insertSeries.close();
		});

		HBox indsetKnapperHBox = new HBox();
		indsetKnapperHBox.getChildren().addAll(indsetTilfojKnap, indsetTilbageKnap);
		indsetKnapperHBox.setSpacing(400);
		border.setBottom(indsetKnapperHBox);

		Scene scene = new Scene(border, 1200, 680);
		scene.getStylesheets().add(Main.class.getResource("insertSeries.css").toExternalForm());
		insertSeries.setScene(scene);
		insertSeries.show();
	}
}
