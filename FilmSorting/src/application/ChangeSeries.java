package application;

import java.util.List;

import javax.swing.JOptionPane;

import domain.DomainClassSeries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.SeriesSortImpl;
import logic.SeriesSortInterface;

public class ChangeSeries {
	List<DomainClassSeries> serieliste;
	private ObservableList<DomainClassSeries> observableListSogSerie;
	TableView<DomainClassSeries> table = new TableView<DomainClassSeries>();

	public void start(Stage aendreSerie) {
		aendreSerie.setTitle("Ændre i Serier");
		aendreSerie.setResizable(false);
		BorderPane border = new BorderPane();

		SeriesSortImpl logicSog = new SeriesSortImpl();
		serieliste = logicSog.sogSeriesListe("");
		observableListSogSerie = FXCollections.observableArrayList(serieliste);
		table.setItems(observableListSogSerie);

		Label sogTextLabel = new Label("Søg på Seriens navn");
		Label navnLabel = new Label("Navn");
		Label nameLabel = new Label("Name");
		Label seasonLabel = new Label("Season");
		Label aarstalLabel = new Label("Årstal");
		Label audioLabel = new Label("Audio");
		Label subLabel = new Label("Undertekst");
		Label noteLabel = new Label("Note");
		TextField reftext = new TextField();
		TextField navnText = new TextField();
		TextField nameText = new TextField();
		TextField seasonText = new TextField();
		TextField aarstalText = new TextField();
		TextField audioText = new TextField();
		TextField subText = new TextField();
		TextField noteText = new TextField();
		TextField sogText = new TextField();
		sogText.setId("sogtext");
		sogText.setOnKeyReleased(e -> {
			String sogeord = sogText.getText();
			SeriesSortImpl logicsog = new SeriesSortImpl();
			serieliste = logicsog.sogSeriesListe(sogeord);
			observableListSogSerie = FXCollections.observableArrayList(serieliste);
			table.setItems(observableListSogSerie);
		});

		// Knapper
		Button tilfojknap = new Button("Tilføj Ændringer");
		tilfojknap.setOnAction(e -> {
				SeriesSortInterface ssi = new SeriesSortImpl();
				DomainClassSeries domain = new DomainClassSeries();
				domain.setRefs(Integer.parseInt(reftext.getText()));
				domain.setNavn(navnText.getText());
				domain.setName(nameText.getText());
				domain.setSeason(Integer.parseInt(seasonText.getText()));
				domain.setAarstal(aarstalText.getText());
				domain.setAudio(audioText.getText());
				domain.setSub(subText.getText());
				domain.setNote(noteText.getText());
				ssi.redigerSerie(domain);
				JOptionPane.showMessageDialog(null, "Seriens oplysninger er ændret");
				navnText.clear();
				nameText.clear();
				aarstalText.clear();
				audioText.clear();
				subText.clear();
				noteText.clear();
				ChangeSeries change = new ChangeSeries();
				change.start(new Stage());
				aendreSerie.close();
		});

		Button sletknap = new Button("Slet en Serie");
		sletknap.setOnAction(e -> {
			 DeleteSeries deleteserie = new DeleteSeries();
			 deleteserie.start(new Stage());
			aendreSerie.close();
		});

		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			MenuSeries serieMenu = new MenuSeries();
			serieMenu.start(new Stage());
			aendreSerie.close();
		});

		// Opsætning af felter
		HBox sogh = new HBox();
		sogh.getChildren().addAll(sogTextLabel, sogText);
		HBox navnh = new HBox();
		navnh.getChildren().addAll(navnLabel, navnText);
		HBox nameh = new HBox();
		nameh.getChildren().addAll(nameLabel, nameText);
		HBox seasonh = new HBox();
		seasonh.getChildren().addAll(seasonLabel, seasonText);
		HBox aarstalh = new HBox();
		aarstalh.getChildren().addAll(aarstalLabel, aarstalText);
		HBox audioh = new HBox();
		audioh.getChildren().addAll(audioLabel, audioText);
		HBox subh = new HBox();
		subh.getChildren().addAll(subLabel, subText);
		HBox noteh = new HBox();
		noteh.getChildren().addAll(noteLabel, noteText);
		VBox knapperv = new VBox();
		knapperv.getChildren().addAll(tilfojknap, sletknap, tilbageknap);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(sogh, navnh, nameh, seasonh, aarstalh, audioh, subh, noteh);
		// Table
		TableColumn<DomainClassSeries, String> navn = new TableColumn<DomainClassSeries, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("navn"));
		TableColumn<DomainClassSeries, String> name = new TableColumn<DomainClassSeries, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("name"));
		TableColumn<DomainClassSeries, String> season = new TableColumn<DomainClassSeries, String>("Season");
		season.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("season"));
		TableColumn<DomainClassSeries, String> arstal = new TableColumn<DomainClassSeries, String>("Årstal");
		arstal.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("aarstal"));
		TableColumn<DomainClassSeries, String> audio = new TableColumn<DomainClassSeries, String>("Audio");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("audio"));
		TableColumn<DomainClassSeries, String> sub = new TableColumn<DomainClassSeries, String>("Undertekst");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("sub"));
		TableColumn<DomainClassSeries, String> note = new TableColumn<DomainClassSeries, String>("Note");
		note.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("note"));

		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.194));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.194));
		season.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.154));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.154));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		table.getColumns().addAll(navn, name, season, arstal, audio, sub, note);

		table.setRowFactory(e -> {
			TableRow<DomainClassSeries> row = new TableRow<>();
			row.setOnMouseClicked(e2 -> {
				reftext.setText(row.getItem().getRefs() + "");
				navnText.setText(row.getItem().getNavn());
				nameText.setText(row.getItem().getName());
				aarstalText.setText(row.getItem().getAarstal());
				audioText.setText(row.getItem().getAudio());
				subText.setText(row.getItem().getSub());
				noteText.setText(row.getItem().getNote());
			});
			return row;
		});

		border.setLeft(vbox);
		border.setBottom(table);
		border.setRight(knapperv);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("changeSeries.css").toExternalForm());
		aendreSerie.setScene(scene);
		aendreSerie.show();
	}
}
