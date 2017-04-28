package application;

import domain.DomainClass;
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

public class InsertFilm {

	public void start(Stage insertFilm) {
		insertFilm.setTitle("Tilføj En Film");
		insertFilm.setResizable(false);
		BorderPane border = new BorderPane();

		Label indsetNavnLabel = new Label("Tilføj Danske Titel: ");
		Label indsetNameLabel = new Label("Tilføj Engelske Titel: ");
		Label indsetAarstalLabel = new Label("Tilføj Udgivelsesår: ");
		Label indsetSprogLabel = new Label("Tilføj Audio Sprog: ");
		Label indsetUndertekstLabel = new Label("Tilføj Undertekst Sprog: ");
		indsetNavnLabel.setId("indsetNavnLabel");
		indsetNameLabel.setId("indsetNameLabel");
		indsetAarstalLabel.setId("indsetAarstalLabel");
		indsetSprogLabel.setId("indsetSprogLabel");
		indsetUndertekstLabel.setId("indsetUndertekstLabel");
		
		TextField indsetNavnTekstfelt = new TextField();
		TextField indsetNameTekstfelt = new TextField();
		TextField indsetAarstalTekstfelt = new TextField();
		TextField indsetSprogTekstfelt = new TextField();
		TextField indsetUndertekstTekstfelt = new TextField();
		indsetNavnTekstfelt.setId("indsetNavnTekstfelt");
		indsetNameTekstfelt.setId("indsetNameTekstfelt");
		indsetAarstalTekstfelt.setId("indsetAarstalTekstfelt");
		indsetSprogTekstfelt.setId("indsetSprogTekstfelt");
		indsetUndertekstTekstfelt.setId("indsetUndertekstTekstfelt");
		
		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(indsetNavnLabel, indsetNameLabel, indsetAarstalLabel, indsetSprogLabel, indsetUndertekstLabel);
		indsetLabelVBox.setSpacing(15);
		border.setLeft(indsetLabelVBox);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(indsetNavnTekstfelt, indsetNameTekstfelt, indsetAarstalTekstfelt, indsetSprogTekstfelt, indsetUndertekstTekstfelt);
		indsetTextFieldVBox.setSpacing(15);
		border.setRight(indsetTextFieldVBox);
		
		Button indsetTilfojKnap = new Button("Tilføj");
		indsetTilfojKnap.setId("indsetTilfojKnap");
		indsetTilfojKnap.setOnAction(e -> {
			try {
				FilmSortInterface fsi = new FilmSortImpl();
				DomainClass sdomain = new DomainClass();
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
			FilmMenu filmMenu = new FilmMenu();
			filmMenu.start(new Stage());
			insertFilm.close();
		});

		HBox indsetKnapperHBox = new HBox();
		indsetKnapperHBox.getChildren().addAll(indsetTilfojKnap, indsetTilbageKnap);
		indsetKnapperHBox.setSpacing(310);
		border.setBottom(indsetKnapperHBox);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("insertfilm.css").toExternalForm());
		insertFilm.setScene(scene);
		insertFilm.show();
	}
}