package application;

import java.util.List;

import javax.swing.JOptionPane;

import domain.DomainClassFilm;
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
import logic.FilmSortImpl;
import logic.FilmSortInterface;

public class DeleteFilm {
	List<DomainClassFilm> filmliste;
	private ObservableList<DomainClassFilm> observableListSogFilm;
	TableView<DomainClassFilm> table = new TableView<DomainClassFilm>();

	public void start(Stage deleteFilm) {
		deleteFilm.setTitle("Slet en Film");
		deleteFilm.setResizable(false);
		BorderPane border = new BorderPane();

		FilmSortImpl logicSog = new FilmSortImpl();
		filmliste = logicSog.sogFilmListe("");
		observableListSogFilm = FXCollections.observableArrayList(filmliste);
		table.setItems(observableListSogFilm);

		Label sogLabel = new Label("Søg på filmens titel");
		TextField reftext = new TextField();
		reftext.setDisable(true);
		TextField sogtext = new TextField();
		sogtext.setOnKeyReleased(e -> {
			String sogeord = sogtext.getText();
			FilmSortImpl logicsog = new FilmSortImpl();
			filmliste = logicsog.sogFilmListe(sogeord);
			observableListSogFilm = FXCollections.observableArrayList(filmliste);
			table.setItems(observableListSogFilm);
		});

		// Knapper
		Button slet = new Button("Slet");
		Button regret = new Button("Tilbage");
		slet.setOnAction(e -> {
			JOptionPane.showMessageDialog(null, "Filmen slettes!");
			FilmSortInterface fsi = new FilmSortImpl();
			DomainClassFilm domain = new DomainClassFilm();
			domain.setRef(Integer.parseInt(reftext.getText()));
			fsi.sletFilm(domain);
			JOptionPane.showMessageDialog(null, "Filmen er slettet");
		});
		regret.setOnAction(e -> {
			ChangeFilm change = new ChangeFilm();
			change.start(new Stage());
			deleteFilm.close();
		});

		// Table start
		TableColumn<DomainClassFilm, String> navn = new TableColumn<DomainClassFilm, String>("Dansk Titel");
		navn.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("navn"));
		TableColumn<DomainClassFilm, String> name = new TableColumn<DomainClassFilm, String>("Engelsk Titel");
		name.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("name"));
		TableColumn<DomainClassFilm, String> arstal = new TableColumn<DomainClassFilm, String>("Årstal");
		arstal.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("aarstal"));
		TableColumn<DomainClassFilm, String> audio = new TableColumn<DomainClassFilm, String>("Audio");
		audio.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("audio"));
		TableColumn<DomainClassFilm, String> sub = new TableColumn<DomainClassFilm, String>("Undertekst");
		sub.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("sub"));
		TableColumn<DomainClassFilm, String> note = new TableColumn<DomainClassFilm, String>("Note");
		note.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("note"));
		TableColumn<DomainClassFilm, String> burned = new TableColumn<DomainClassFilm, String>("Brændt");
		burned.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("burned"));

		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.188));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.188));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.17));
		burned.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		table.getColumns().addAll(navn, name, arstal, audio, sub, note, burned);

		table.setRowFactory(e -> {
			TableRow<DomainClassFilm> row = new TableRow<>();
			row.setOnMouseClicked(e2 -> {
				reftext.setText(row.getItem().getRef() + "");
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
		scene.getStylesheets().add(Main.class.getResource("changeFilm.css").toExternalForm());
		deleteFilm.setScene(scene);
		deleteFilm.show();
	}

}
