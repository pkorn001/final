package scene;

import hero.base.Hero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import render.Irenderable;
import render.Resource;

public class Logo {

	public Logo() {
		
		StackPane root = new StackPane();
		
		Image logo = Resource.Logo;
		
		Label bg = new Label();
		bg.setGraphic(new ImageView(logo));
		bg.setAlignment(Pos.TOP_RIGHT);
		bg.setPadding(new Insets(.10));
		
		root.getChildren().add(bg);
		
	}
}