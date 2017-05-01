package application;

import domain.DomainClassFilm;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.FilmSortImpl;
import logic.FilmSortInterface;

public class InsertSeries {
	public void start(Stage insertSeries) {
		insertSeries.setTitle("Tilføj En Serie");
		insertSeries.setResizable(false);
		BorderPane border = new BorderPane();

		Label indsetNavnLabel = new Label("Tilføj Danske Titel   : ");
		indsetNavnLabel.setId("indsetNavnLabel");
		TextField indsetNavnTekstfelt = new TextField();
		indsetNavnTekstfelt.setId("indsetNavnTekstfelt");
		Label indsetNameLabel = new Label("Tilføj Engelske Titel : ");
		indsetNameLabel.setId("indsetNameLabel");
		TextField indsetNameTekstfelt = new TextField();
		indsetNameTekstfelt.setId("indsetNameTekstfelt");
		Label indsetAarstalLabel = new Label("Tilføj Udgivelsesår    : ");
		indsetAarstalLabel.setId("indsetAarstalLabel");
		TextField indsetAarstalTekstfelt = new TextField();
		indsetAarstalTekstfelt.setId("indsetAarstalTekstfelt");
		Label indsetSeasonLabel = new Label("Tilføj Season/Nr.    : ");
		indsetSeasonLabel.setId("indsetSeasonLabel");
		TextField indsetSeasonTekstfelt = new TextField();
		indsetSeasonTekstfelt.setId("indsetSeasonTekstfelt");
		
		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(indsetNavnLabel, indsetNameLabel, indsetAarstalLabel);
		indsetLabelVBox.setSpacing(15);
		border.setLeft(indsetLabelVBox);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(indsetNavnTekstfelt, indsetNameTekstfelt, indsetAarstalTekstfelt);
		indsetTextFieldVBox.setSpacing(15);
		border.setRight(indsetTextFieldVBox);

		Button indsetTilfojKnap = new Button("Tilføj");
		indsetTilfojKnap.setId("indsetTilfojKnap");
		indsetTilfojKnap.setOnAction(e -> {
			try {
				FilmSortInterface fsi = new FilmSortImpl();
				DomainClassFilm sdomain = new DomainClassFilm();
				sdomain.setNavn(indsetNavnTekstfelt.getText());
				sdomain.setName(indsetNameTekstfelt.getText());
				sdomain.setAarstal(indsetAarstalTekstfelt.getText());
				fsi.tilfojFilm(sdomain);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Button indsetTilbageKnap = new Button("Tilbage");
		indsetTilbageKnap.setId("indsetTilbageKnap");
		indsetTilbageKnap.setOnAction(e -> {
			Program program = new Program();
			program.start(new Stage());
			insertSeries.close();
		});

		HBox indsetKnapperHBox = new HBox();
		indsetKnapperHBox.getChildren().addAll(indsetTilfojKnap, indsetTilbageKnap);
		indsetKnapperHBox.setSpacing(410);
		border.setBottom(indsetKnapperHBox);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("insertSeries.css").toExternalForm());
		insertSeries.setScene(scene);
		insertSeries.show();
	}
}
