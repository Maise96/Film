package application;

import javax.swing.JOptionPane;

import domain.DomainClassFilm;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
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
		// Oprettelse af Labels og textfields
		Label labelNavnf = new Label("Tilføj Danske Titel");
		Label labelNamef = new Label("Tilføj Engelske Titel");
		Label labelYearf = new Label("Tilføj Udgivelsesår");
		Label labelBlurayf = new Label("Blu-ray film?");
		Label labelBurned = new Label("Brændt film?");
		Label labelKids = new Label("Børnefilm?");
		Label labelAnimation = new Label("Animationsfilm?");
		Label labelDanish = new Label("Dansk film?");
		Label labelHorror = new Label("Gyser film?");
		Label labelNotef = new Label("Tilføj Note");
		Label labelAudiof = new Label("Tilføj Audio Sprog");
		Label labelSubf = new Label("Tilføj Undertekst Sprog");
		Label audiofTextlabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		Label subfTextlabel = new Label("Dansk, Norsk, Svensk, Engelsk, Suomi, Thai, Tysk, Andet");
		audiofTextlabel.setId("sprogsublabel");
		subfTextlabel.setId("subsproglabel");
		TextField textfieldNavnf = new TextField();
		TextField textfieldNamef = new TextField();
		TextField textfieldYearf = new TextField();
		CheckBox checkboxBluerayf = new CheckBox();
		CheckBox checkboxBurned = new CheckBox();
		CheckBox checkboxKids = new CheckBox();
		CheckBox checkboxAnimation = new CheckBox();
		CheckBox checkboxDanish = new CheckBox();
		CheckBox checkboxHorror = new CheckBox();
		TextField textfieldNotef = new TextField();
		TextField textfieldAudiof = new TextField();
		TextField textfieldSubf = new TextField();
		checkboxBluerayf.setSelected(false);
		checkboxBluerayf.setAllowIndeterminate(false);
		checkboxBurned.setSelected(false);
		checkboxBurned.setAllowIndeterminate(false);
		checkboxKids.setSelected(false);
		checkboxKids.setAllowIndeterminate(false);
		checkboxAnimation.setSelected(false);
		checkboxAnimation.setAllowIndeterminate(false);
		checkboxDanish.setSelected(false);
		checkboxDanish.setAllowIndeterminate(false);
		checkboxHorror.setSelected(false);
		checkboxHorror.setAllowIndeterminate(false);
		HBox hboxNavn = new HBox();
		hboxNavn.getChildren().addAll(labelNavnf, textfieldNavnf);
		HBox hboxName = new HBox();
		hboxName.getChildren().addAll(labelNamef, textfieldNamef);
		HBox hboxYear = new HBox();
		hboxYear.getChildren().addAll(labelYearf, textfieldYearf);
		HBox hboxAudio = new HBox();
		hboxAudio.getChildren().addAll(labelAudiof, textfieldAudiof);
		HBox hboxSub = new HBox();
		hboxSub.getChildren().addAll(labelSubf, textfieldSubf);
		HBox hboxBluray = new HBox();
		hboxBluray.getChildren().addAll(labelBlurayf, checkboxBluerayf);
		HBox hboxBurned = new HBox();
		hboxBurned.getChildren().addAll(labelBurned, checkboxBurned);
		HBox hboxAnimation = new HBox();
		hboxAnimation.getChildren().addAll(labelAnimation, checkboxAnimation);
		HBox hboxKids = new HBox();
		hboxKids.getChildren().addAll(labelKids, checkboxKids);
		HBox hboxDanish = new HBox();
		hboxDanish.getChildren().addAll(labelDanish, checkboxDanish);
		HBox hboxHorror = new HBox();
		hboxHorror.getChildren().addAll(labelHorror, checkboxHorror);
		HBox hboxNote = new HBox();
		hboxNote.getChildren().addAll(labelNotef, textfieldNotef);
		
		VBox labelVBox = new VBox();
		labelVBox.getChildren().addAll(hboxNavn, hboxName, hboxYear, hboxAudio, hboxSub, hboxBluray,
				hboxBurned, hboxAnimation, hboxKids, hboxDanish, hboxHorror, hboxNote);
		labelVBox.setSpacing(5);
		border.setCenter(labelVBox);
		
		Button tilfojKnap = new Button("Tilføj");
		tilfojKnap.setOnAction(e -> {
			try {
				FilmSortInterface fsi = new FilmSortImpl();
				DomainClassFilm domain = new DomainClassFilm();
				domain.setNavnf(textfieldNavnf.getText());
				domain.setNamef(textfieldNamef.getText());
				domain.setYearf(textfieldYearf.getText());
				domain.setAudiof(textfieldAudiof.getText());
				domain.setSubf(textfieldSubf.getText());
				if(checkboxBluerayf.isSelected()){
					domain.setBlurayf(true);
				}
				if(checkboxBurned.isSelected()){
					domain.setBurned(true);
				}
				if(checkboxAnimation.isSelected()){
					domain.setAnimation(true);
				}
				if(checkboxKids.isSelected()){
					domain.setKids(true);
				}
				if(checkboxDanish.isSelected()){
					domain.setDanish(true);
				}
				if(checkboxHorror.isSelected()){
					domain.setHorror(true);
				}
				domain.setNotef(textfieldNotef.getText());
				fsi.opretEnFilm(domain);
				JOptionPane.showMessageDialog(null, "Film er tilføjet");
				textfieldNavnf.clear();
				textfieldNamef.clear();
				textfieldYearf.clear();
				textfieldAudiof.clear();
				textfieldSubf.clear();
				checkboxBluerayf.setSelected(false);
				checkboxBurned.setSelected(false);
				checkboxAnimation.setSelected(false);
				checkboxKids.setSelected(false);
				checkboxDanish.setSelected(false);
				checkboxHorror.setSelected(false);
				textfieldNotef.clear();
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
		indsetKnapperHBox.getChildren().addAll(tilfojKnap, indsetTilbageKnap);
		indsetKnapperHBox.setSpacing(310);
		border.setBottom(indsetKnapperHBox);

		Scene scene = new Scene(border, 1200, 730);
		scene.getStylesheets().add(Main.class.getResource("insertFilm.css").toExternalForm());
		insertFilm.setScene(scene);
		insertFilm.show();
	}
}