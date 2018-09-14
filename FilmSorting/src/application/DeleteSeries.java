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

public class DeleteSeries {
	List<DomainClassSeries> serieListe;
	private ObservableList<DomainClassSeries> observableListSeries;
	TableView<DomainClassSeries> table = new TableView<DomainClassSeries>();
	
	public void start(Stage deleteSeries) {
		deleteSeries.setTitle("Slet en Sæson/Serie");
		deleteSeries.setResizable(false);
		BorderPane border = new BorderPane();

		SeriesSortImpl logicSog = new SeriesSortImpl();
		serieListe = logicSog.sogSeriesListe("");
		observableListSeries = FXCollections.observableArrayList(serieListe);
		table.setItems(observableListSeries);

		Label sogLabel = new Label("Søg på Seriens titel");
		TextField reftext = new TextField();
		reftext.setDisable(true);
		TextField sogtext = new TextField();
		sogtext.setOnKeyReleased(e -> {
			String sogeord = sogtext.getText();
			SeriesSortImpl logicsog = new SeriesSortImpl();
			serieListe = logicsog.sogSeriesListe(sogeord);
			observableListSeries = FXCollections.observableArrayList(serieListe);
			table.setItems(observableListSeries);
		});

		// Knapper
		Button slet = new Button("Slet");
		Button regret = new Button("Tilbage");
		slet.setOnAction(e -> {
			JOptionPane.showMessageDialog(null, "Serien slettes!");
			SeriesSortInterface fsi = new SeriesSortImpl();
			DomainClassSeries domain = new DomainClassSeries();
			domain.setRefs(Integer.parseInt(reftext.getText()));
			fsi.sletSerie(domain);
			JOptionPane.showMessageDialog(null, "Serien er slettet");
		});
		regret.setOnAction(e -> {
			ChangeSeries change = new ChangeSeries();
			change.start(new Stage());
			deleteSeries.close();
		});

		// Table start
		TableColumn<DomainClassSeries, String> navn = new TableColumn<DomainClassSeries, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("navn"));
		TableColumn<DomainClassSeries, String> name = new TableColumn<DomainClassSeries, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("name"));
		TableColumn<DomainClassSeries, String> arstal = new TableColumn<DomainClassSeries, String>("Årstal");
		arstal.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("aarstal"));
		TableColumn<DomainClassSeries, String> audio = new TableColumn<DomainClassSeries, String>("Audio");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("audio"));
		TableColumn<DomainClassSeries, String> sub = new TableColumn<DomainClassSeries, String>("Undertekst");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("sub"));
		TableColumn<DomainClassSeries, String> note = new TableColumn<DomainClassSeries, String>("Note");
		note.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("note"));
		TableColumn<DomainClassSeries, String> season = new TableColumn<DomainClassSeries, String>("Sæson");
		season.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("season"));

		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.188));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.188));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
		season.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		table.getColumns().addAll(navn, name, arstal,season, audio, sub, note);

		table.setRowFactory(e -> {
			TableRow<DomainClassSeries> row = new TableRow<>();
			row.setOnMouseClicked(e2 -> {
				reftext.setText(row.getItem().getRefs() + "");
			});
			return row;
		});

		// View opsætning
		HBox hboxPlaceringAfTexteltogKnap = new HBox();
		VBox vboxTextfelter = new VBox();
		VBox vboxKnapper = new VBox();
		vboxTextfelter.getChildren().addAll(sogtext, reftext);
		hboxPlaceringAfTexteltogKnap.getChildren().addAll(sogLabel, vboxTextfelter);
		vboxKnapper.getChildren().addAll(slet, regret);

		border.setLeft(hboxPlaceringAfTexteltogKnap);
		border.setRight(vboxKnapper);
		border.setBottom(table);
		
		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("deleteSeries.css").toExternalForm());
		deleteSeries.setScene(scene);
		deleteSeries.show();
	}
}
