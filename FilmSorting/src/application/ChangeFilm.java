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
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.FilmSortImpl;
import logic.FilmSortInterface;

public class ChangeFilm {
	List<DomainClassFilm> filmliste;
	private ObservableList<DomainClassFilm> observableListSogFilm;
	TableView<DomainClassFilm> table = new TableView<DomainClassFilm>();

	public void start(Stage aendreFilm) {
		aendreFilm.setTitle("Ændre i Film");
		aendreFilm.setResizable(false);
		BorderPane border = new BorderPane();

		FilmSortImpl logicSog = new FilmSortImpl();
		filmliste = logicSog.sogFilmListe("");
		observableListSogFilm = FXCollections.observableArrayList(filmliste);
		table.setItems(observableListSogFilm);

		// Labels og tekstfelterne til redigering af en film
		Label sogTextLabel = new Label("Søg på filmens navn");
		Label reflabel = new Label("Skriv Ref.Nr her");
		Label navnLabel = new Label("Navn");
		Label nameLabel = new Label("Name");
		Label aarstalLabel = new Label("Årstal");
		Label audioLabel = new Label("Audio");
		Label subLabel = new Label("Undertekst");
		Label noteLabel = new Label("Note");
		TextField reftext = new TextField();
		TextField navnTextField = new TextField();
		TextField nameTextField = new TextField();
		TextField aarstalTextField = new TextField();
		TextField audioTextField = new TextField();
		TextField subTextField = new TextField();
		TextField noteTextField = new TextField();
		TextField sogTextField = new TextField();
		sogTextField.setId("sogtext");
		sogTextField.setOnKeyReleased(e -> {
			String sogeord = sogTextField.getText();
			FilmSortImpl logicsog = new FilmSortImpl();
			filmliste = logicsog.sogFilmListe(sogeord);
			observableListSogFilm = FXCollections.observableArrayList(filmliste);
			table.setItems(observableListSogFilm);
		});

		Button tilfojknap = new Button("Tilføj Ændringer");
		tilfojknap.setOnAction(e -> {
			FilmSortInterface fsi = new FilmSortImpl();
			DomainClassFilm domain = new DomainClassFilm();
			domain.setRef(Integer.parseInt(reftext.getText()));
			domain.setNavn(navnTextField.getText());
			domain.setName(nameTextField.getText());
			domain.setAarstal(aarstalTextField.getText());
			domain.setAudio(audioTextField.getText());
			domain.setSub(subTextField.getText());
			domain.setNote(noteTextField.getText());
			fsi.redigerFilm(domain);
			JOptionPane.showMessageDialog(null, "Filmens oplysninger er ændret");
			reftext.clear();
			navnTextField.clear();
			nameTextField.clear();
			aarstalTextField.clear();
			audioTextField.clear();
			subTextField.clear();
			noteTextField.clear();
		});

		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			FilmMenu filmMenu = new FilmMenu();
			filmMenu.start(new Stage());
			aendreFilm.close();
		});

		HBox sogh = new HBox();
		sogh.getChildren().addAll(sogTextLabel, sogTextField);
		HBox refh = new HBox();
		refh.getChildren().addAll(reflabel, reftext);
		HBox navnh = new HBox();
		navnh.getChildren().addAll(navnLabel, navnTextField);
		HBox nameh = new HBox();
		nameh.getChildren().addAll(nameLabel, nameTextField);
		HBox aarstalh = new HBox();
		aarstalh.getChildren().addAll(aarstalLabel, aarstalTextField);
		HBox audioh = new HBox();
		audioh.getChildren().addAll(audioLabel, audioTextField);
		HBox subh = new HBox();
		subh.getChildren().addAll(subLabel, subTextField);
		HBox noteh = new HBox();
		noteh.getChildren().addAll(noteLabel, noteTextField);
		VBox knapperv = new VBox();
		knapperv.getChildren().addAll(tilfojknap, tilbageknap);
		VBox vbox = new VBox();
		vbox.getChildren().addAll(sogh, refh, navnh, nameh, aarstalh, audioh, subh, noteh);

		TableColumn<DomainClassFilm, String> ref = new TableColumn<DomainClassFilm, String>("Ref.Nr");
		ref.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("ref"));
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

		ref.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		table.getColumns().addAll(ref, navn, name, arstal, audio, sub, note);

		border.setLeft(vbox);
		border.setBottom(table);
		border.setRight(knapperv);

		Scene scene = new Scene(border, 1200, 680);
		scene.getStylesheets().add(Main.class.getResource("changeFilm.css").toExternalForm());
		aendreFilm.setScene(scene);
		aendreFilm.show();
	}
}