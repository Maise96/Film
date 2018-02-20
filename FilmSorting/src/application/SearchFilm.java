package application;

import java.util.List;

import javax.swing.JOptionPane;

import domain.DomainClassFilm;
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
	List<DomainClassFilm> filmliste;
	private ObservableList<DomainClassFilm> observableListSogFilm;
	TableView<DomainClassFilm> table = new TableView<DomainClassFilm>();

	public void start(Stage sogFilm) {
		sogFilm.setTitle("Søg efter en film");
		sogFilm.setResizable(false);
		BorderPane border = new BorderPane();

		// Gør at tablet bliver vist fra start
		FilmSortImpl logicSog = new FilmSortImpl();
		filmliste = logicSog.sogFilmListe("");
		observableListSogFilm = FXCollections.observableArrayList(filmliste);
		table.setItems(observableListSogFilm);

		// Textfelt
		Label sogLabel = new Label("Søg på den Danske \n eller den Engelske titel.");
		sogLabel.setId("sogLabel");
		TextField sogTextField = new TextField();
		sogTextField.setOnKeyReleased(e -> {
			String sogeord = sogTextField.getText();
			FilmSortImpl logicSoge = new FilmSortImpl();
			filmliste = logicSoge.sogFilmListe(sogeord);
			observableListSogFilm = FXCollections.observableArrayList(filmliste);
			table.setItems(observableListSogFilm);
			sogFilm.show();
		});
		// Knapper
		Button hvormange = new Button("Hvor mange film er der i alt?");
		hvormange.setOnAction(e -> {
			FilmSortImpl logicSoge = new FilmSortImpl();
			filmliste = logicSoge.sogFilmListe("");
			JOptionPane.showMessageDialog(null, filmliste.size());
		});
		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			MenuFilm menuFilm = new MenuFilm();
			menuFilm.start(new Stage());
			sogFilm.close();
		});

		HBox knapperhbox = new HBox();
		knapperhbox.setSpacing(2);
		knapperhbox.setAlignment(Pos.BOTTOM_LEFT);
		knapperhbox.getChildren().addAll(sogLabel, hvormange, tilbageknap);
		VBox vboxknapper = new VBox();
		vboxknapper.getChildren().addAll(knapperhbox, sogTextField);

		TableColumn<DomainClassFilm, String> navn = new TableColumn<DomainClassFilm, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("navn"));
		TableColumn<DomainClassFilm, String> name = new TableColumn<DomainClassFilm, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("name"));
		TableColumn<DomainClassFilm, String> aarstal = new TableColumn<DomainClassFilm, String>("Årstal");
		aarstal.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("aarstal"));
		TableColumn<DomainClassFilm, String> audio = new TableColumn<DomainClassFilm, String>("Sprog");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("audio"));
		TableColumn<DomainClassFilm, String> sub = new TableColumn<DomainClassFilm, String>("Undertekster");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("sub"));
		TableColumn<DomainClassFilm, String> note = new TableColumn<DomainClassFilm, String>("Note");
		note.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("note"));

		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		aarstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.249));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.249));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		table.getColumns().addAll(aarstal, navn, name, audio, sub, note);

		border.setBottom(table);
		border.setTop(vboxknapper);

		Scene scene = new Scene(border, 1200, 680);
		scene.getStylesheets().add(Main.class.getResource("searchFilm.css").toExternalForm());
		sogFilm.setScene(scene);
		sogFilm.show();
	}
}