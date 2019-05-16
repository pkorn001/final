package scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import logic.GameLogic;
import render.Irenderable;
import render.RenderableHolder;

public class GameScreen extends Scene {

	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;

	private boolean inGame = true;
	GraphicsContext gc;

	public GameScreen(StackPane stackpane) {
		super(stackpane);
		stackpane.setPrefHeight(SCENE_HEIGHT);
		stackpane.setPrefWidth(SCENE_WIDTH);
		
		Canvas canvas = createCanvas();
		stackpane.getChildren().add(canvas);
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
			}
		});
	}
}
