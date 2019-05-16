package scene;

import hero.base.Hero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import render.Resource;

public class OverScreen extends StackPane {

	public OverScreen() {
		setPrefWidth(626);
		setPrefHeight(417);
		
//		ImageView img = new ImageView(Resource.WoodenSign);
//		this.getChildren().add(img);
		
		HBox root = new HBox();
		
		HBox top = new HBox();
		Label textLabel = new Label("GAME OVER !!");
		textLabel.setFont(Font.font(72));
		textLabel.setAlignment(Pos.CENTER);
		textLabel.setPadding(new Insets(10));
		
		HBox bottom = new HBox();
		Label scoreLabel = new Label("Total score : " + Hero.getScore());
		scoreLabel.setFont(Font.font(36));
		scoreLabel.setPadding(new Insets(10));
		
		root.getChildren().addAll(top, bottom);
		this.getChildren().add(root);
	}
}
