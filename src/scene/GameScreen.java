package scene;

import hero.base.Hero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import logic.GameLogic;
import main.Main;
import render.Irenderable;
import render.RenderableHolder;

public class GameScreen extends Scene {

	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;
	private static Label sc;

	private boolean inGame = true;
	GraphicsContext gc;

	public GameScreen(StackPane stackpane) {
		super(stackpane);
		stackpane.setPrefHeight(SCENE_HEIGHT);
		stackpane.setPrefWidth(SCENE_WIDTH);
		
		VBox score = createScore();
		Canvas canvas = createCanvas();
		stackpane.getChildren().addAll(canvas, score);
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
	
	public VBox createScore() {
		sc = new Label();
		sc.setText("Score : " + 0);
		sc.setAlignment(Pos.TOP_LEFT);
		sc.setPadding(new Insets(.10));
		sc.setFont(Font.font(36));
		
		VBox score = new VBox();
		score.getChildren().add(sc);
		
		return score;
	}
	
	public static void updateScore() {
		sc.setText("Score  : " + Hero.getScore());
	}
	
	public void paintComponent() {
		//System.out.println("-----------------------------------------");
		for (Irenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.IsVisible() && !entity.isDestroyed()) {
				//System.out.println(entity);
				entity.draw(gc);
			}
		}
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

	public void setKey() {
		this.setOnKeyPressed(e -> {
			
			if(e.getCode() == KeyCode.SPACE) {
				GameLogic.setJump(true);
			}else if(e.getCode() == KeyCode.A) {
				GameLogic.setAttack(true);
			}else if(e.getCode() == KeyCode.ENTER) {
				Main.ui.setVisible(false);
				StartScreen.setStart(true);
			}
		});
	}
}
