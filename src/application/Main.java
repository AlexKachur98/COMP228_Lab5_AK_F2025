package application;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {

		BorderPane pane = new BorderPane();
		// Place nodes in the pane
		pane.setTop(new CustomHorizonalTop("Top"));

		pane.setRight(new CustomPane("Right"));
		pane.setBottom(new CustomHorizontalBottom());
		pane.setLeft(new CustomPane("Left"));
		pane.setCenter(new EmploymentForm());
		/*
		 * pane.setCenter(Embed the code for the Gridpane - employment form. );
		 */

		// Create a scene and place it in the stage
		Scene scene = new Scene(pane);
		primaryStage.setTitle("ShowBorderPane"); // Set the stage title
		primaryStage.setScene(scene); // Place the scene in the stage
		primaryStage.show(); // Display the stage

	}

	public static void main(String[] args) {
		launch(args);
	}
}
