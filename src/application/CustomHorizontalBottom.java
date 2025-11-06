package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * @author Alex Kachur
 * @since 2025-11-05
 * @purpose Bottom region for the BorderPane. Uses an HBox to display today's
 *          date.
 */
public class CustomHorizontalBottom extends HBox {

	/** Date format used for the bottom status line. */
	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/** Construct the bottom HBox and render the date text. */
	public CustomHorizontalBottom() {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red");

		String today = LocalDate.now().format(FMT);
		getChildren().add(new Label("Today's Date: " + today));
	}
}
