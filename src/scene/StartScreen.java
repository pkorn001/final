package scene;

import hero.base.Hero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import logic.Position;
import render.Irenderable;
import render.RenderableHolder;
import render.Resource;

public class StartScreen extends Scene {

	public static boolean isStart = false;
	private Hero hero;
	private Background background;
	GraphicsContext gc;

	public StartScreen(StackPane stackpane) {
		super(stackpane);
		hero = new Hero(new Position(10, 430));
		background = new Background();
		RenderableHolder.getInstance().getEntities().add(background);
		RenderableHolder.getInstance().getEntities().add(hero);
		
		Canvas canvas = createCanvas();
		StackPane ui = createUI();
		stackpane.setPrefHeight(GameScreen.SCENE_HEIGHT);
		stackpane.setPrefWidth(GameScreen.SCENE_WIDTH);
		stackpane.getChildren().addAll(canvas, ui);

		setKey();
	}

	public Canvas createCanvas() {
		Canvas canvas = new Canvas();
		canvas.setWidth(GameScreen.SCENE_WIDTH);
		canvas.setHeight(GameScreen.SCENE_HEIGHT);
		canvas.setVisible(true);
		gc = canvas.getGraphicsContext2D();
		return canvas;
	}

	public StackPane createUI() {
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

		HBox startText = new HBox();
		Text text = new Text("Press any key to start");
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(Font.font("Verdana", FontWeight.BOLD, 22));
		text.setFill(Color.WHITE);
		startText.setPadding(new Insets(150.));
		startText.getChildren().add(text);
		startText.setAlignment(Pos.BOTTOM_CENTER);

		ui.getChildren().addAll(title, startText);

		return ui;
	}

	public void paintComponent() {
		// System.out.println("--------------------------------------------------");
		for (Irenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.toString());
			if (entity.IsVisible() && !entity.isDestroyed()) {
				entity.draw(gc, 0); // edit later for 0
			}
		}
	}

	public void setKey() {
		this.setOnKeyPressed(e -> {
			setStart(true);
			System.out.println("It's work!!");
		});
	}

	public static boolean isStart() {
		return isStart;
	}

	public static void setStart(boolean isStart) {
		StartScreen.isStart = isStart;
	}

}
