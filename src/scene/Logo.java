package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import render.Resource;

public class Logo extends VBox{

	public Logo() {
		
		Image logo = Resource.Logo;
		
		Label bg = new Label();
		bg.setGraphic(new ImageView(logo));
		bg.setAlignment(Pos.TOP_RIGHT);
		bg.setPadding(new Insets(.10));

		getChildren().add(bg);
		
	}
}