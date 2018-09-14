package application;

import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {
	@Override

	public void start(Stage program) {
		// Program view = new Program();
		// view.start(program);
		DeleteSeries view = new DeleteSeries();
		view.start(program);

	}

	public static void main(String[] args) {
		launch(args);

	}
}

/*
 * Dette er noter: - Søg i alt knap og stage - Tilføje brændt yes or no i Tilføj
 * film data og interface - Tilføj brændt bool i rediger film data og inerface -
 * Alle exceptions skal vise et Noget gik galt view - Tilpasse Views med farver
 * osv - Exception View skal laves - En knap man kan trykke på for at få
 * oplysninger: UO mv. - Det hele for Serier
 * original eller brændt flueben.boolean.
 */

/*
 * x engelsk og dansk of ref kolonner service metode klasser til lavning af
 * lables og textboxes x sætte en størrelse på colonner i tableview x gøre sådan
 * man kan søge på både engelsk og dansk x Udgivelses år kolonne funktion indset
 * årstal, navn senere. ALTER TABLE table_name x ALTER COLUMN column_name
 * datatype; x audio og subtitles til film og serie tabellerne. x Slette knap
 * hvis man tilføjer en forkert film. Sletteknap for serie Vise hvor mange
 * serier CSS til allersidst Ryde op css messig evt flere klasser til at
 * indeholde ting for at klassen ikke bliver for stor x Film menuen x serie
 * menuen x tilføj serie x Søg i serier x kan slette en film i databasen x kan
 * tilføje en detalje til en eksisterende film i databasen kan slette en serie i
 * databasen x kan tilføje en detalje til en eksisterende serie i databasen x
 * film menuen x serie menuen x Vise hvor mange film der er Vise hvor mange
 * serier der er x rette alle windows til css mæssigt Læser filmtitlerne i en
 * source folder Åbne database automatisk når progrmmet starter (efter
 * færdiggørelse) x Tilføje en Disney/Marvel/DC/Børne sektion med klassikerne
 * mm. fra Disney. Hvilket nummer de har. Barbie, Disney Pixar. x En vampyr
 * sektion? x Flere sektioner Action, Børnefilm, colonne med disney klassiker i
 * en ny tabel.. Lave det samme program med bøger... Sådan jeg kan få fuldent
 * min serier? Evt. i samme program med ny tabel i databasen?
 */