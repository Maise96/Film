package application;

import java.util.List;

import domain.DomainClassSeries;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import logic.FilmSortImpl;

public class SearchSeries {

	BorderPane border = new BorderPane();
	List<DomainClassSeries> serieliste;
	private ObservableList<DomainClassSeries> observableListSogSerie;
	TableView<DomainClassSeries> table = new TableView<DomainClassSeries>();

	public void start(Stage searchSeries) {
		searchSeries.setTitle("Søg efter en Serie");
		searchSeries.setResizable(false);
		BorderPane border = new BorderPane();

		Label sogLabel = new Label("Søg på den Danske titel\n eller den Engelske titel.");
		sogLabel.setId("sogLabel");
		TextField sogTextField = new TextField();
		sogTextField.setId("sogTextField");

		VBox vbox = new VBox();
		vbox.getChildren().addAll(sogLabel, sogTextField);

		Button sogSogknap = new Button("Søg");
		sogSogknap.setOnAction(e -> {
			String soog = sogTextField.getText();

			FilmSortImpl logicSog = new FilmSortImpl();
			serieliste = logicSog.sogSeriesListe(soog);

			observableListSogSerie = FXCollections.observableArrayList(serieliste);
			table.setItems(observableListSogSerie);
			searchSeries.show();
		});

		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			SeriesMenu seriesMenu = new SeriesMenu();
			seriesMenu.start(new Stage());
			searchSeries.close();
		});

		HBox knapperhbox = new HBox();
		knapperhbox.setSpacing(9);
		knapperhbox.setAlignment(Pos.BOTTOM_LEFT);
		knapperhbox.getChildren().addAll(vbox, sogSogknap, tilbageknap);
		border.setTop(knapperhbox);

		TableColumn<DomainClassSeries, String> navn = new TableColumn<DomainClassSeries, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("navn"));
		TableColumn<DomainClassSeries, String> name = new TableColumn<DomainClassSeries, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("name"));
		TableColumn<DomainClassSeries, String> aarstal = new TableColumn<DomainClassSeries, String>("Årstal");
		aarstal.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("aarstal"));
		TableColumn<DomainClassSeries, String> season = new TableColumn<DomainClassSeries, String>("Season");
		season.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("season"));
		TableColumn<DomainClassSeries, String> audio = new TableColumn<DomainClassSeries, String>("Sprog");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("audio"));
		TableColumn<DomainClassSeries, String> sub = new TableColumn<DomainClassSeries, String>("Undertekster");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("sub"));

		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.22));
		aarstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		season.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.229));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.229));

		table.getColumns().addAll(season, navn, name, aarstal, audio, sub);
		table.autosize();
		border.setBottom(table);

		Scene scene = new Scene(border, 1200, 680);
		scene.getStylesheets().add(Main.class.getResource("searchSeries.css").toExternalForm());
		searchSeries.setScene(scene);
		searchSeries.show();

	}

}
