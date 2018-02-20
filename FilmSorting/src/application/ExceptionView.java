package application;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ExceptionView {
	
	public void start(Stage exception) {
		exception.setTitle("Noget gik galt");
		exception.setResizable(false);
		BorderPane border = new BorderPane();
		
		Button close = new Button("Der opstod en fejl, beklager! \nLuk ved at trykke her");
		border.setLeft(close);
		close.setOnAction(e->{
			exception.close();
		});
		
		
		Scene scene = new Scene(border, 346, 90);
		scene.getStylesheets().add(Main.class.getResource("exceptionView.css").toExternalForm());
		exception.setScene(scene);
		exception.show();
	}
}
