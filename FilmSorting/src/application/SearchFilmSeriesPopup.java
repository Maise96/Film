package application;

import java.util.List;

import domain.DomainClassFilm;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import logic.FilmSortImpl;

public class SearchFilmSeriesPopup {
	List<DomainClassFilm> domainfilmliste;

	public void start(Stage sogFilmSeriePopup) {
		sogFilmSeriePopup.setTitle("Hvor mange film er der?");
		sogFilmSeriePopup.setResizable(false);
		BorderPane border = new BorderPane();
		// soger efter hvor mange film der er ved at gennemgå logiklagets antal
		// rækker i db
		FilmSortImpl logicSogehvormangefilmderer = new FilmSortImpl();
		domainfilmliste = logicSogehvormangefilmderer.sogFilmListdata("");

		Label popupLabelDerer = new Label("Der er");
		popupLabelDerer.setId("popupLabelDerer");
		Label popupLabelmedAntal = new Label("" + domainfilmliste.size() + " " + "film i alt");
		popupLabelmedAntal.setId("popupLabelmedAntal");

		Button buttonClose = new Button("OK");
		buttonClose.setId("popupbuttonClose");
		buttonClose.setOnAction(e -> {
			sogFilmSeriePopup.close();
		});

		border.setTop(popupLabelDerer);
		border.setCenter(popupLabelmedAntal);
		border.setBottom(buttonClose);

		Scene scene = new Scene(border, 200, 200);
		scene.getStylesheets().add(Main.class.getResource("searchFilmSeries.css").toExternalForm());
		sogFilmSeriePopup.setScene(scene);
		sogFilmSeriePopup.show();
	}
}
