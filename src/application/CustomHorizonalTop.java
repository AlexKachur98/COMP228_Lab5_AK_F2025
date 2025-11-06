package application;

import java.io.InputStream;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * @author Alex Kachur
 * @since 2025-11-05
 * @purpose Top region for the BorderPane. Uses an HBox to display a favorite
 *          sport image and a simple title label.
 */
public class CustomHorizonalTop extends HBox {

	/**
	 * Build the HBox; try to load an image from the classpath.
	 *
	 * @param title heading text to show next to the image
	 */
	public CustomHorizonalTop(String title) {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red"); // match the lab outline

		// Try two common names; fall back to just the label if not found
		ImageView banner = tryLoadImage("/application/top.png", "/application/top.jpg");
		if (banner != null) {
			banner.setFitHeight(60);
			banner.setPreserveRatio(true);
			getChildren().addAll(banner, new Label(title));
		} else {
			getChildren().add(new Label(title));
		}
	}

	/** Utility: attempt to load the first existing image from the given paths. */
	private ImageView tryLoadImage(String... candidatePaths) {
		for (String path : candidatePaths) {
			InputStream in = getClass().getResourceAsStream(path);
			if (in != null) {
				return new ImageView(new Image(in));
			}
		}
		return null; // no image packaged; UI will show the label only
	}
}
