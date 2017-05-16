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

public class DeleteFilm {
	List<DomainClassFilm> filmliste;
	private ObservableList<DomainClassFilm> observableListSogFilm;
	TableView<DomainClassFilm> table = new TableView<DomainClassFilm>();

	public void start(Stage deleteFilm) {
		deleteFilm.setTitle("Slet en Film");
		deleteFilm.setResizable(false);
		BorderPane border = new BorderPane();
		BorderPane grid = new BorderPane();
		Scene sceneJaNej = new Scene(grid, 200, 400);

		FilmSortImpl logicSog = new FilmSortImpl();
		filmliste = logicSog.sogFilmListe("");
		observableListSogFilm = FXCollections.observableArrayList(filmliste);
		table.setItems(observableListSogFilm);

		Label sikkerLabel = new Label("Er du sikker på at du vil \n slette denne film?");
		sikkerLabel.setId("sikkerlabel");
		Label refLabel = new Label("Skriv Ref.Nr. på filmen");
		Label sogLabel = new Label("Søg på filmens titel");
		TextField reftext = new TextField();
		TextField sogtext = new TextField();
		sogtext.setOnKeyReleased(e -> {
			String sogeord = sogtext.getText();
			FilmSortImpl logicsog = new FilmSortImpl();
			filmliste = logicsog.sogFilmListe(sogeord);
			observableListSogFilm = FXCollections.observableArrayList(filmliste);
			table.setItems(observableListSogFilm);
		});

		Button sletknap = new Button("Slet Film");
		sletknap.setOnAction(e -> {
			deleteFilm.setScene(sceneJaNej);
			deleteFilm.show();
		});

		Button ja = new Button("Ja");
		ja.setOnAction(e -> {
			JOptionPane.showMessageDialog(null, "Filmen slettes!");
			FilmSortInterface fsi = new FilmSortImpl();
			DomainClassFilm domain = new DomainClassFilm();
			domain.setRef(Integer.parseInt(reftext.getText()));
			fsi.sletFilm(domain);
			JOptionPane.showMessageDialog(null, "Filmen er slettet");
		});
		Button nej = new Button("Nej");
		nej.setOnAction(e -> {
			ChangeFilm ch = new ChangeFilm();
			ch.start(new Stage());
			deleteFilm.close();
		});
		HBox gridh = new HBox();
		gridh.getChildren().addAll(ja, nej);
		grid.setCenter(gridh);
		grid.setTop(sikkerLabel);

		Button tilbageknap = new Button("tilbage");
		tilbageknap.setOnAction(e -> {
			ChangeFilm change = new ChangeFilm();
			change.start(new Stage());
			deleteFilm.close();
		});

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
		TableColumn<DomainClassFilm, String> burned = new TableColumn<DomainClassFilm, String>("Brændt");
		burned.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("burned"));

		ref.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		burned.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		table.getColumns().addAll(ref, navn, name, arstal, audio, sub, note, burned);

		HBox hbox = new HBox();
		HBox hbox2 = new HBox();
		VBox vbox = new VBox();
		hbox.getChildren().addAll(sogLabel, sogtext);
		hbox2.getChildren().addAll(refLabel, reftext);
		vbox.getChildren().addAll(hbox, hbox2);
		VBox vbox2 = new VBox();
		vbox2.getChildren().addAll(sletknap, tilbageknap);

		border.setLeft(vbox);
		border.setRight(vbox2);
		border.setBottom(table);

		Scene scene = new Scene(border, 1000, 650);
		sceneJaNej.getStylesheets().add(Main.class.getResource("deleteFilm.css").toExternalForm());
		scene.getStylesheets().add(Main.class.getResource("changeFilm.css").toExternalForm());
		deleteFilm.setScene(scene);
		deleteFilm.show();
	}
}
