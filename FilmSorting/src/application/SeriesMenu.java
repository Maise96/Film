package application;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SeriesMenu {
	public void start(Stage addSeriesMenu) {
		BorderPane border = new BorderPane();
		
		Scene scene = new Scene(border, 1000, 650);
				scene.getStylesheets().add(Main.class.getResource("addSeriesMenu.css").toExternalForm());
				addSeriesMenu.setScene(scene);
				addSeriesMenu.show();
		}
}
