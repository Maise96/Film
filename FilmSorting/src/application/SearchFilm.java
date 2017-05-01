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

public class SearchFilm {

	List<DomainClass> filmliste;
	private ObservableList<DomainClass> observableListSogFilm;
	TableView<DomainClass> table = new TableView<DomainClass>();

	public void start(Stage sogFilm) {
		sogFilm.setTitle("Søg efter film");
		sogFilm.setResizable(false);
		BorderPane border = new BorderPane();

		Label sogLabel = new Label(
				"Søg på den Danske titel\n eller den Engelske titel.\n Eller søg på Udgivelsesåret.");
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
			sogeFunkNavnName.setAarstal(sogTextField.getText());

			FilmSortImpl logicSog = new FilmSortImpl();
			filmliste = logicSog.sogFilmListe(sogeFunkNavnName);

			observableListSogFilm = FXCollections.observableArrayList(filmliste);
			table.setItems(observableListSogFilm);
			sogFilm.show();
		});

		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			FilmMenu filmMenu = new FilmMenu();
			filmMenu.start(new Stage());
			sogFilm.close();
		});

		HBox knapperhbox = new HBox();
		knapperhbox.setSpacing(9);
		knapperhbox.setAlignment(Pos.BOTTOM_LEFT);
		knapperhbox.getChildren().addAll(sogSogknap, tilbageknap);
		border.setBottom(knapperhbox);

		border.setCenter(table);
		TableColumn<DomainClass, String> ref = new TableColumn<DomainClass, String>("Nr.");
		ref.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("ref"));
		TableColumn<DomainClass, String> navn = new TableColumn<DomainClass, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("navn"));
		TableColumn<DomainClass, String> name = new TableColumn<DomainClass, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("name"));
		TableColumn<DomainClass, String> aarstal = new TableColumn<DomainClass, String>("Årstal");
		aarstal.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("aarstal"));
		TableColumn<DomainClass, String> audio = new TableColumn<DomainClass, String>("Sprog");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("audio"));
		TableColumn<DomainClass, String> sub = new TableColumn<DomainClass, String>("Undertekster");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClass, String>("sub"));
		
		table.getColumns().addAll(ref,navn, name, aarstal, audio, sub);

		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("searchFilm.css").toExternalForm());
		sogFilm.setScene(scene);
		sogFilm.show();
	}

}
