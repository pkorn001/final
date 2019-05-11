package scene;

import hero.base.Hero;
import javafx.animation.AnimationTimer;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.effect.InnerShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.Position;
import render.Resource;

public class StartScreen extends StackPane{
	
	private Hero hero;
	private Background background;
	
	public StartScreen() {
		hero = new Hero(new Position(50.00, 00.00));
		background = new Background();
		setPrefHeight(GameScreen.SCENE_HEIGHT);
		setPrefWidth(GameScreen.SCENE_WIDTH);
		
		// ui part
		StackPane ui = new StackPane();
		
		Image logo = Resource.Logo;
		ImageView imageView = new ImageView(logo);
		imageView.setFitHeight(400);
		imageView.setFitWidth(700);
		
		Label gameTitle = new Label();
		gameTitle.setGraphic(imageView);
		gameTitle.setAlignment(Pos.TOP_CENTER);
		gameTitle.setPadding(new Insets(10.));
		
		HBox title = new HBox();
		title.setAlignment(Pos.TOP_CENTER);
		title.setPrefHeight(300);
		title.getChildren().add(gameTitle);
		title.setPrefHeight(300);
		
		/////////////
		InnerShadow is = new InnerShadow();
		is.setOffsetX(4.0);
		is.setOffsetY(4.0);
		
		HBox startText = new HBox();
		Text text = new Text("Press any key to start");
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font(22));
		text.setEffect(is);
		text.setFill(Color.PALEGOLDENROD);
		startText.setPadding(new Insets(50.));
		startText.getChildren().add(text);
		startText.setAlignment(Pos.BOTTOM_CENTER);
		
		ui.getChildren().addAll(title, startText);
		
		//drawing part
		Canvas canvas = new Canvas();
		GraphicsContext gc = canvas.getGraphicsContext2D();
		hero.draw(gc, 0);
		background.draw(gc, 0);
		
		getChildren().addAll(canvas, ui);
		
		
	}
}
