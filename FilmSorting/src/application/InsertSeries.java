package application;

import javax.swing.JOptionPane;

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

		Label navnLabel = new Label("Tilføj Danske Titel");
		Label nameLabel = new Label("Tilføj Engelske Titel");
		Label aarstalLabel = new Label("Tilføj Udgivelsesår");
		Label seasonLabel = new Label("Tilføj Season.Nr.");
		Label audioLabel = new Label("Tilføj Audio Sprog");
		Label subLabel = new Label("Tilføj Undertekst Sprog");
		Label noteLabel = new Label("Tilføj Note");
		Label labelLabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		Label textLabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		labelLabel.setId("labellabel");
		textLabel.setId("textlabel");
		TextField navnTekstfelt = new TextField();
		TextField nameTekstfelt = new TextField();
		TextField aarstalTekstfelt = new TextField();
		TextField seasonTekstfelt = new TextField();
		TextField audioTekstfelt = new TextField();
		TextField subTekstfelt = new TextField();
		TextField noteTekstfelt = new TextField();

		Button indsetTilfojKnap = new Button("Tilføj");
		indsetTilfojKnap.setOnAction(e -> {
			try {
				SeriesSortInterface fsi = new SeriesSortImpl();
				DomainClassSeries sdomain = new DomainClassSeries();
				sdomain.setNavn(navnTekstfelt.getText());
				sdomain.setName(nameTekstfelt.getText());
				sdomain.setAarstal(aarstalTekstfelt.getText());
				sdomain.setSeason(Integer.parseInt(seasonTekstfelt.getText()));
				sdomain.setAudio(audioTekstfelt.getText());
				sdomain.setSub(subTekstfelt.getText());
				sdomain.setNote(noteTekstfelt.getText());
				fsi.tilfojEnSerie(sdomain);
				JOptionPane.showMessageDialog(null, "Serien er tilføjet");
				navnTekstfelt.clear();
				nameTekstfelt.clear();
				aarstalTekstfelt.clear();
				seasonTekstfelt.clear();
				audioTekstfelt.clear();
				subTekstfelt.clear();
				noteTekstfelt.clear();
			} catch (Exception e1) {
				e1.printStackTrace();
				ExceptionView view = new ExceptionView();
				view.start(new Stage());
				seasonTekstfelt.clear();
			}
		});
		Button indsetTilbageKnap = new Button("Tilbage");
		indsetTilbageKnap.setOnAction(e -> {
			MenuSeries menuSeries = new MenuSeries();
			menuSeries.start(new Stage());
			insertSeries.close();
		});

		VBox indsetLabelVBox = new VBox();
		indsetLabelVBox.getChildren().addAll(navnLabel, nameLabel, aarstalLabel, seasonLabel, labelLabel, audioLabel,
				subLabel, noteLabel);
		indsetLabelVBox.setSpacing(10);
		VBox indsetTextFieldVBox = new VBox();
		indsetTextFieldVBox.getChildren().addAll(navnTekstfelt, nameTekstfelt, aarstalTekstfelt, seasonTekstfelt,
				textLabel, audioTekstfelt, subTekstfelt, noteTekstfelt);
		indsetTextFieldVBox.setSpacing(10);
		HBox indsetKnapperHBox = new HBox();
		indsetKnapperHBox.getChildren().addAll(indsetTilfojKnap, indsetTilbageKnap);
		indsetKnapperHBox.setSpacing(310);

		border.setBottom(indsetKnapperHBox);
		border.setRight(indsetTextFieldVBox);
		border.setLeft(indsetLabelVBox);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("insertSeries.css").toExternalForm());
		insertSeries.setScene(scene);
		insertSeries.show();
	}
}
