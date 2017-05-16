package application;

import javax.swing.JOptionPane;

import domain.DomainClassFilm;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import logic.FilmSortImpl;
import logic.FilmSortInterface;

public class CancelDeleteFilm {

	public void fortryd(Stage cancel) {
			cancel.setTitle("Er du sikker på du vil slette denne film?");
			cancel.setResizable(false);
			BorderPane border = new BorderPane();

			Label refLabel = new Label("Skriv Ref.Nr. på filmen");
			TextField reftext = new TextField();
			Button ja = new Button ();
			Button nej = new Button();
			Button sletknap = new Button("Slet Film");
			sletknap.setOnAction(e -> {
				if (ja.isPressed()){
					JOptionPane.showMessageDialog(null, "Filmen slettes!");
					FilmSortInterface fsi = new FilmSortImpl();
					DomainClassFilm domain = new DomainClassFilm();
					domain.setRef(Integer.parseInt(reftext.getText()));
					fsi.sletFilm(domain);
					JOptionPane.showMessageDialog(null, "Filmen er slettet!");
					reftext.clear();
				}
				else if(nej.isPressed()){
					cancel.close();
				}
			});
			HBox hbox = new HBox();
			HBox hbox2 = new HBox();
			VBox vbox = new VBox();
			hbox2.getChildren().addAll(refLabel, reftext);
			vbox.getChildren().addAll(hbox, hbox2);
			VBox vbox2 = new VBox();
			vbox2.getChildren().addAll(sletknap;
			
			border.setLeft(vbox);
			border.setRight(vbox2);

			Scene scene = new Scene(border, 1000, 650);
			scene.getStylesheets().add(Main.class.getResource("changeFilm.css").toExternalForm());
			cancel.setScene(scene);
			cancel.show();
		}
	}