package application;

import java.util.List;

import javax.swing.JOptionPane;

import domain.DomainClassFilm;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
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
			FilmSortInterface fsi = new FilmSortImpl();
			DomainClassFilm domain = new DomainClassFilm();
			domain.setRef(Integer.parseInt(reftext.getText()));
			fsi.sletFilm(domain);
			JOptionPane.showMessageDialog(null, "Filmen er slettet!");
			reftext.clear();
		});
		Button tilbageknap = new Button("tilbage");
		tilbageknap.setOnAction(e->{
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
		navn.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		name.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		arstal.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audio.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		sub.prefWidthProperty().bind(table.widthProperty().multiply(0.174));
		note.prefWidthProperty().bind(table.widthProperty().multiply(0.15));
		table.getColumns().addAll(ref, navn, name, arstal, audio, sub, note);

		
		border.setTop(reftext);
		border.setBottom(sletknap);
		border.setCenter(tilbageknap);
		
		Scene scene = new Scene(border, 1000, 650);
		scene.getStylesheets().add(Main.class.getResource("changeFilm.css").toExternalForm());
		deleteFilm.setScene(scene);
		deleteFilm.show();	
	}
}
