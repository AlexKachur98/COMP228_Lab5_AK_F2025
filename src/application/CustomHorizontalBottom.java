package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class CustomHorizontalBottom extends HBox {

	private static final DateTimeFormatter FMT = DateTimeFormatter.ofPattern("yyyy-MM-dd");

	public CustomHorizontalBottom() {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red");
		String today = LocalDate.now().format(FMT);
		getChildren().add(new Label("Today's Date: " + today));
	}
}
