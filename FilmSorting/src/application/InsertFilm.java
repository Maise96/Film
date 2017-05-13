package application;

import javax.swing.JOptionPane;

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

public class InsertFilm {

	public void start(Stage insertFilm) {
		insertFilm.setTitle("Tilføj en Film");
		insertFilm.setResizable(false);
		BorderPane border = new BorderPane();

		Label indsetNavnLabel = new Label("Tilføj Danske Titel");
		Label indsetNameLabel = new Label("Tilføj Engelske Titel");
		Label indsetAarstalLabel = new Label("Tilføj Udgivelsesår");
		Label indsetAudioLabel = new Label("Tilføj Audio Sprog");
		Label indsetSubLabel = new Label("Tilføj Undertekst Sprog");
		Label sprogsublabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		Label subsproglabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		Label indsetNoteLabel = new Label("Tilføj Note");
		sprogsublabel.setId("sprogsublabel");
		subsproglabel.setId("subsproglabel");

		TextField indsetNavnTekstfelt = new TextField();
		TextField indsetNameTekstfelt = new TextField();
		TextField indsetAarstalTekstfelt = new TextField();
		TextField indsetAudioTekstfelt = new TextField();
		TextField indsetSubTekstfelt = new TextField();
		TextField indsetNoteTekstfelt = new TextField();

		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(indsetNavnLabel, indsetNameLabel, indsetAarstalLabel, sprogsublabel,
				indsetAudioLabel, indsetSubLabel, indsetNoteLabel);
		indsetLabelVBox.setSpacing(10);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(indsetNavnTekstfelt, indsetNameTekstfelt, indsetAarstalTekstfelt,
				subsproglabel, indsetAudioTekstfelt, indsetSubTekstfelt, indsetNoteTekstfelt);
		indsetTextFieldVBox.setSpacing(10);
		border.setLeft(indsetLabelVBox);
		border.setRight(indsetTextFieldVBox);

		Button indsetTilfojKnap = new Button("Tilføj");
		indsetTilfojKnap.setOnAction(e -> {
			try {
				FilmSortInterface fsi = new FilmSortImpl();
				DomainClassFilm domain = new DomainClassFilm();
				domain.setNavn(indsetNavnTekstfelt.getText());
				domain.setName(indsetNameTekstfelt.getText());
				domain.setAarstal(indsetAarstalTekstfelt.getText());
				domain.setAudio(indsetAudioTekstfelt.getText());
				domain.setSub(indsetSubTekstfelt.getText());
				domain.setNote(indsetNoteTekstfelt.getText());
				fsi.tilfojFilm(domain);

				JOptionPane.showMessageDialog(null, "Film er tilføjet");

			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		Button indsetTilbageKnap = new Button("Tilbage");
		indsetTilbageKnap.setOnAction(e -> {
			MenuFilm menuFilm = new MenuFilm();
			menuFilm.start(new Stage());
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