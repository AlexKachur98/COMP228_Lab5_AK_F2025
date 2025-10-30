package application;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * @author Alex
 * @since 2025-10-29
 * @purpose Top region for the BorderPane. Uses an HBox to display a favorite
 *          book/sport image and a simple title label.
 */
public class CustomHorizonalTop extends HBox {

	/**
	 * Constructs the top HBox and attempts to show an image beside a title. The
	 * image is optional and loaded from the classpath.
	 *
	 * @param title Heading text to show next to the image.
	 */
	public CustomHorizonalTop(String title) {
		setSpacing(10);
		setPadding(new Insets(8));
		setStyle("-fx-border-color: red"); // match the lab's red outline

		try {
			// Try common filenames placed under: src/application/top.png
			Image img = tryLoad("/application/top.png", "/application/top.jpg");
			ImageView iv = new ImageView(img);
			iv.setFitHeight(60); // keep banner compact
			iv.setPreserveRatio(true); // avoid stretching
			getChildren().addAll(iv, new Label(title));
		} catch (Exception ex) {
			// Fallback if no image is packaged — still satisfy "Top HBox" requirement
			getChildren().add(new Label(title));
		}
	}

	/**
	 * Tries multiple resource paths and returns the first image found.
	 *
	 * @param paths candidate resource paths
	 * @return loaded Image
	 * @throws IllegalStateException if none of the paths exist
	 */
	private Image tryLoad(String... paths) {
		for (String p : paths) {
			var in = getClass().getResourceAsStream(p);
			if (in != null)
				return new Image(in);
		}
		throw new IllegalStateException("No top image found on classpath.");
	}
}
