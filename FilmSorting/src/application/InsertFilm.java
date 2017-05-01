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
		Label indsetAudioLabel = new Label("Tilføj Audio Sprog: ");
		Label indsetSubLabel = new Label("Tilføj Undertekst Sprog: ");
		indsetNavnLabel.setId("indsetNavnLabel");
		indsetNameLabel.setId("indsetNameLabel");
		indsetAarstalLabel.setId("indsetAarstalLabel");
		indsetAudioLabel.setId("indsetSprogLabel");
		indsetSubLabel.setId("indsetUndertekstLabel");
		
		Label sprogsublabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		Label subsproglabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		sprogsublabel.setId("sprogsublabel");
		subsproglabel.setId("subsproglabel");
		
		TextField indsetNavnTekstfelt = new TextField();
		TextField indsetNameTekstfelt = new TextField();
		TextField indsetAarstalTekstfelt = new TextField();
		TextField indsetAudioTekstfelt = new TextField();
		TextField indsetSubTekstfelt = new TextField();
		indsetNavnTekstfelt.setId("indsetNavnTekstfelt");
		indsetNameTekstfelt.setId("indsetNameTekstfelt");
		indsetAarstalTekstfelt.setId("indsetAarstalTekstfelt");
		indsetAudioTekstfelt.setId("indsetSprogTekstfelt");
		indsetSubTekstfelt.setId("indsetUndertekstTekstfelt");
		
		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(indsetNavnLabel, indsetNameLabel, indsetAarstalLabel, sprogsublabel, indsetAudioLabel, indsetSubLabel);
		indsetLabelVBox.setSpacing(15);
		border.setLeft(indsetLabelVBox);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(indsetNavnTekstfelt, indsetNameTekstfelt, indsetAarstalTekstfelt, subsproglabel, indsetAudioTekstfelt, indsetSubTekstfelt);
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
				sdomain.setAudio(indsetAudioTekstfelt.getText());
				sdomain.setSub(indsetSubTekstfelt.getText());
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