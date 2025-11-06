package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class CustomHorizonalTop extends HBox {

	public CustomHorizonalTop(String title) {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red");

		ImageView banner = tryLoadImage("/application/top.png", "/application/top.jpg");
		if (banner != null) {
			banner.setFitHeight(60);
			banner.setPreserveRatio(true);
			getChildren().addAll(banner, new Label(title));
		} else {
			getChildren().add(new Label(title));
		}
	}

	private ImageView tryLoadImage(String... paths) {
		for (String p : paths) {
			var in = getClass().getResourceAsStream(p);
			if (in != null)
				return new ImageView(new Image(in));
		}
		return null;
	}
}
