package application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * @author Alex
 * @since 2025-10-29
 * @purpose Assembles the BorderPane-based layout for the Week-8 lab: Top HBox
 *          (image/title), Bottom HBox (today's date), Left/Right labeled panes,
 *          and the Center EmploymentForm GridPane.
 */
public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		root.setTop(new CustomHorizonalTop("Top"));
		root.setBottom(new CustomHorizontalBottom());

		root.setLeft(new CustomPane("Left"));
		root.setRight(new CustomPane("Right"));

		root.setCenter(new EmploymentForm());

		Scene scene = new Scene(root, 800, 600);
		primaryStage.setTitle("ShowBorderPane");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
