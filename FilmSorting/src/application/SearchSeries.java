package application;

import java.util.List;

import domain.DomainClass;
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
		List<DomainClass> serieliste;
		private ObservableList<DomainClass> observableListSogSerie;
		TableView<DomainClass> table = new TableView<DomainClass>();

		public void start(Stage searchSeries) {
			searchSeries.setTitle("Søg efter film");
			searchSeries.setResizable(false);
			BorderPane border = new BorderPane();

			Label sogLabel = new Label(
					"Søg på den Danske titel\n eller den Engelske titel.");
			sogLabel.setId("sogLabel");
			TextField sogTextField = new TextField();
			sogTextField.setId("sogTextField");

			VBox vbox = new VBox();
			vbox.getChildren().addAll(sogLabel, sogTextField);
			border.setRight(vbox);

			/*
			 * Action buttons som søger i databasen efter whatever man søger på
			 */

			Button sogSogknap = new Button("Søg");
			sogSogknap.setOnAction(e -> {
				DomainClass sogeFunkNavnName = new DomainClass();
				sogeFunkNavnName.setNavn(sogTextField.getText());
				sogeFunkNavnName.setName(sogTextField.getText());

				FilmSortImpl logicSog = new FilmSortImpl();
				serieliste = logicSog.sogSeriesListe(sogeFunkNavnName);

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
			knapperhbox.getChildren().addAll(sogSogknap, tilbageknap);
			border.setBottom(knapperhbox);

			border.setCenter(table);
			TableColumn<DomainClass, String> refs = new TableColumn<DomainClass, String>("Nr.");
			refs.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("refs"));
			TableColumn<DomainClass, String> navn = new TableColumn<DomainClass, String>("Dansk Titel");
			navn.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("navn"));
			TableColumn<DomainClass, String> name = new TableColumn<DomainClass, String>("Engelsk Titel");
			name.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("name"));
			TableColumn<DomainClass, String> aarstal = new TableColumn<DomainClass, String>("Årstal");
			aarstal.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("aarstal"));
			TableColumn<DomainClass, String> season = new TableColumn<DomainClass, String>("Season");
			season.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("season"));
			
			table.getColumns().addAll(refs, season, navn, name, aarstal);

		
		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("searchSeries.css").toExternalForm());
		searchSeries.setScene(scene);
		searchSeries.show();
		
	}

}
