package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage program) {
		Program view = new Program();
		view.start(program);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
