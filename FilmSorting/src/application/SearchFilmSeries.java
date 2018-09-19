package application;

import java.util.List;

import domain.DomainClassFilm;
import domain.DomainClassSeries;
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
import logic.SeriesSortImpl;

public class SearchFilmSeries {
	List<DomainClassFilm> listeF;
	List<DomainClassSeries> listeS;
	private ObservableList<DomainClassFilm> sogObservableListF;
	private ObservableList<DomainClassSeries> sogObservableListS;
	TableView<DomainClassFilm> tableF = new TableView<DomainClassFilm>();
	TableView<DomainClassSeries> tableS	= new TableView<DomainClassSeries>();
	
	// start stage view
	public void start(Stage sogFilmSerie) {
		sogFilmSerie.setTitle("Søg efter Titel");
		BorderPane border = new BorderPane();

		// Gør at tablet bliver vist fra start
		FilmSortImpl logiclayerSearchF = new FilmSortImpl();
		SeriesSortImpl logiclayerSearchS = new SeriesSortImpl();
		listeF = logiclayerSearchF.sogFilmListdata("");
		sogObservableListF = FXCollections.observableArrayList(listeF);
		tableF.setItems(sogObservableListF);
		listeS = logiclayerSearchS.sogSerieListdata("");
		sogObservableListS = FXCollections.observableArrayList(listeS);
		tableS.setItems(sogObservableListS);

		// Sogetekstfelt med soge funktion on keyrelease
		TextField sogTextField = new TextField();
		sogTextField.setOnKeyReleased(e -> {
			String searchwordtextfield = sogTextField.getText();
			//for film
			FilmSortImpl logicsearchimplF = new FilmSortImpl();
			listeF = logicsearchimplF.sogFilmListdata(searchwordtextfield);
			sogObservableListF = FXCollections.observableArrayList(listeF);
			tableF.setItems(sogObservableListF);
			//for serier
			SeriesSortImpl logicsearchimplS = new SeriesSortImpl();
			listeS = logicsearchimplS.sogSerieListdata(searchwordtextfield);
			sogObservableListS = FXCollections.observableArrayList(listeS);
			tableS.setItems(sogObservableListS);
			sogFilmSerie.show();
		});
		
		//Knap til hvor mange film
		Button hvormangeknap = new Button();
		hvormangeknap.setText("Hvor mange Film er der?");
		hvormangeknap.setOnAction(e->{
			SearchFilmSeriesPopup popupstage = new SearchFilmSeriesPopup();
			popupstage.start(new Stage());
		});
		Button btnCloseSearchFilmSerie = new Button("Luk");
		btnCloseSearchFilmSerie.setOnAction(e-> {
			sogFilmSerie.close();
		});
		
		HBox hboxtextknap = new HBox();
		hboxtextknap.getChildren().addAll(sogTextField, hvormangeknap, btnCloseSearchFilmSerie);
		
		
		
		// Table for film
		TableColumn<DomainClassFilm, String> navnf = new TableColumn<DomainClassFilm, String>("Titel");
		navnf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("navnf"));
		TableColumn<DomainClassFilm, String> namef = new TableColumn<DomainClassFilm, String>("");
		namef.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("namef"));
		TableColumn<DomainClassFilm, String> audiof = new TableColumn<DomainClassFilm, String>("Sprog");
		audiof.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("audiof"));
		TableColumn<DomainClassFilm, String> subf = new TableColumn<DomainClassFilm, String>("Undertekst");
		subf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("subf"));
		TableColumn<DomainClassFilm, String> blurayf = new TableColumn<DomainClassFilm, String>("Blu-ray");
		blurayf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("blurayf"));
		TableColumn<DomainClassFilm, String> burned = new TableColumn<DomainClassFilm, String>("Brændt");
		burned.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("burned"));

		//Table for serier
		TableColumn<DomainClassSeries, String> navns = new TableColumn<DomainClassSeries, String>("Titel");
		navns.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("names"));
		TableColumn<DomainClassSeries, String> names = new TableColumn<DomainClassSeries, String>("");
		names.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("names"));
		TableColumn<DomainClassSeries, String> cs = new TableColumn<DomainClassSeries, String>("Komplet Sæson");
		cs.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("cs"));
		TableColumn<DomainClassSeries, String> season = new TableColumn<DomainClassSeries, String>("Sæson");
		season.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("season"));
		TableColumn<DomainClassSeries, String> number = new TableColumn<DomainClassSeries, String>("Nummer");
		number.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("number"));
		TableColumn<DomainClassSeries, String> episode = new TableColumn<DomainClassSeries, String>("Episode");
		episode.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("episode"));
		TableColumn<DomainClassSeries, String> volume = new TableColumn<DomainClassSeries, String>("Volume");
		volume.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("volumes"));
		TableColumn<DomainClassSeries, String> audios = new TableColumn<DomainClassSeries, String>("Sprog");
		audios.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("audios"));
		TableColumn<DomainClassSeries, String> subs = new TableColumn<DomainClassSeries, String>("Undertekst");
		subs.setCellValueFactory(new PropertyValueFactory<DomainClassSeries, String>("subs"));
		
		// størrelsen på de forskellige koloner
		navnf.prefWidthProperty().bind(tableF.widthProperty().multiply(0.2));
		namef.prefWidthProperty().bind(tableF.widthProperty().multiply(0.2));
		audiof.prefWidthProperty().bind(tableF.widthProperty().multiply(0.25));
		subf.prefWidthProperty().bind(tableF.widthProperty().multiply(0.25));
		blurayf.prefWidthProperty().bind(tableF.widthProperty().multiply(0.05));
		burned.prefWidthProperty().bind(tableF.widthProperty().multiply(0.05));
		
		navns.prefWidthProperty().bind(tableS.widthProperty().multiply(0.2));
		names.prefWidthProperty().bind(tableS.widthProperty().multiply(0.2));
		cs.prefWidthProperty().bind(tableS.widthProperty().multiply(0.09));
		season.prefWidthProperty().bind(tableS.widthProperty().multiply(0.05));
		number.prefWidthProperty().bind(tableS.widthProperty().multiply(0.05));
		episode.prefWidthProperty().bind(tableS.widthProperty().multiply(0.05));
		volume.prefWidthProperty().bind(tableS.widthProperty().multiply(0.05));
		audios.prefWidthProperty().bind(tableS.widthProperty().multiply(0.25));
		subs.prefWidthProperty().bind(tableS.widthProperty().multiply(0.25));
		
		tableF.getColumns().addAll(navnf, namef,audiof, subf,blurayf,burned);
		tableS.getColumns().addAll(navns, names, cs, season, episode, number, volume, audios, subs);
		
		VBox tableVbox = new VBox();
		tableVbox.getChildren().addAll(tableF, tableS);
		border.setTop(hboxtextknap);
		border.setCenter(tableVbox);
//		 1300, 710
		Scene scene = new Scene(border, 1300, 710);
		scene.getStylesheets().add(Main.class.getResource("searchFilmSeries.css").toExternalForm());
		sogFilmSerie.setScene(scene);
		sogFilmSerie.show();
	}
}
