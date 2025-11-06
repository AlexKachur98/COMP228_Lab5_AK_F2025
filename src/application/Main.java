package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Alex
 * @since 2025-11-05
 * @purpose Assembles the BorderPane for Lab 5: Top = HBox (image + label),
 *          Bottom = HBox (today's date), Left/Right = labeled panes, Center =
 *          Employment form GridPane.
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane pane = new BorderPane();

		// Top/Bottom per lab spec (HBoxes)
		pane.setTop(new CustomHorizonalTop("Top"));
		pane.setBottom(new CustomHorizontalBottom());

		// Left/Right keep the prof's simple red-bordered panes
		pane.setLeft(new CustomPane("Left"));
		pane.setRight(new CustomPane("Right"));

		// Center = employment application form
		pane.setCenter(new EmploymentForm());

		// Scene & Stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowBorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
