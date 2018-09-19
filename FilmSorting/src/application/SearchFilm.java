package application;

import java.util.List;

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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import logic.FilmSortImpl;

public class SearchFilm {
	List<DomainClassFilm> soglisteFilm;
	private ObservableList<DomainClassFilm> observableListSogFilm;
	TableView<DomainClassFilm> table = new TableView<DomainClassFilm>();

	public void start(Stage sogFilmStage) {
		sogFilmStage.setTitle("Søg efter titel på en Film");
		sogFilmStage.setResizable(false);
		BorderPane border = new BorderPane();
		FilmSortImpl logicSogFilm = new FilmSortImpl();

		// Gør at tablet bliver vist fra start
		soglisteFilm = logicSogFilm.sogFilmListdata("");
		observableListSogFilm = FXCollections.observableArrayList(soglisteFilm);
		table.setItems(observableListSogFilm);

		// Textfelt til sog og knapper
		TextField antalfilm = new TextField("Der er " + soglisteFilm.size() + " film i alt");
		antalfilm.setId("antalfilm");
		antalfilm.setDisable(true);
		TextField sogTextField = new TextField();
		sogTextField.setOnKeyReleased(e -> {
			String sogeord = sogTextField.getText();
			soglisteFilm = logicSogFilm.sogFilmListdata(sogeord);
			observableListSogFilm = FXCollections.observableArrayList(soglisteFilm);
			table.setItems(observableListSogFilm);
			sogFilmStage.show();
		});
		Button tilbageknap = new Button("Tilbage");
		tilbageknap.setOnAction(e -> {
			// MenuFilm menuFilm = new MenuFilm();
			// menuFilm.start(new Stage());
			sogFilmStage.close();
		});
		HBox hboxItems = new HBox();
		hboxItems.setSpacing(2);
		hboxItems.getChildren().addAll(sogTextField, antalfilm, tilbageknap);
		

		// Tabellen
		TableColumn<DomainClassFilm, String> navnf = new TableColumn<DomainClassFilm, String>("Dansk Titel");
		navnf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("navnf"));
		TableColumn<DomainClassFilm, String> namef = new TableColumn<DomainClassFilm, String>("Engelsk Titel");
		namef.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("namef"));
		TableColumn<DomainClassFilm, String> yearf = new TableColumn<DomainClassFilm, String>("Årstal");
		yearf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("yearf"));
		TableColumn<DomainClassFilm, String> audiof = new TableColumn<DomainClassFilm, String>("Sprog");
		audiof.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("audiof"));
		TableColumn<DomainClassFilm, String> subf = new TableColumn<DomainClassFilm, String>("Undertekster");
		subf.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("subf"));
		TableColumn<DomainClassFilm, String> notef = new TableColumn<DomainClassFilm, String>("Note");
		notef.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("notef"));
		TableColumn<DomainClassFilm, String> bluray = new TableColumn<DomainClassFilm, String>("Blu-ray");
		bluray.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("blurayf"));
		TableColumn<DomainClassFilm, String> burned = new TableColumn<DomainClassFilm, String>("Brændt");
		burned.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("burned"));
		TableColumn<DomainClassFilm, String> kids = new TableColumn<DomainClassFilm, String>("Børne film");
		kids.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("kids"));
		TableColumn<DomainClassFilm, String> danish = new TableColumn<DomainClassFilm, String>("Dansk film");
		danish.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("danish"));
		TableColumn<DomainClassFilm, String> animation = new TableColumn<DomainClassFilm, String>("Animeret");
		animation.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("animation"));
		TableColumn<DomainClassFilm, String> horror = new TableColumn<DomainClassFilm, String>("Gyser");
		horror.setCellValueFactory(new PropertyValueFactory<DomainClassFilm, String>("horror"));

		navnf.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		namef.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		yearf.prefWidthProperty().bind(table.widthProperty().multiply(0.05));
		audiof.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		subf.prefWidthProperty().bind(table.widthProperty().multiply(0.2));
		bluray.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		burned.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		kids.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		animation.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		danish.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		horror.prefWidthProperty().bind(table.widthProperty().multiply(0.1));
		notef.prefWidthProperty().bind(table.widthProperty().multiply(0.3));
		table.getColumns().addAll(yearf, navnf, namef, audiof, subf, notef, bluray, kids, animation, burned, danish, horror);

		// tilføjelse til border
		border.setCenter(table);
		border.setTop(hboxItems);

		Scene scene = new Scene(border, 1200, 680);
		scene.getStylesheets().add(Main.class.getResource("searchFilm.css").toExternalForm());
		sogFilmStage.setScene(scene);
		sogFilmStage.show();
	}
}