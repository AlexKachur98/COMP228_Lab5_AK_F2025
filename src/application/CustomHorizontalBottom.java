package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

/**
 * @author Alex
 * @since 2025-10-29
 * @purpose Bottom region for the BorderPane. Uses an HBox to display today's
 *          date.
 */
public class CustomHorizontalBottom extends HBox {

	/** Default formatter for the date line. */
	private static final DateTimeFormatter DATE_FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	/** Builds the bottom HBox with the current date. */
	public CustomHorizontalBottom() {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red"); // match lab border
		String today = LocalDate.now().format(DATE_FMT);
		getChildren().add(new Label("Today's Date: " + today));
	}
}
