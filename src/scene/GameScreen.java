package scene;

import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import logic.GameLogic;
import render.Irenderable;
import render.RenderableHolder;

public class GameScreen extends Scene {

	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;

	private boolean inGame = true;
	GraphicsContext gc;

	public GameScreen(Pane pane) {
		super(pane);
		Canvas canvas = new Canvas();
		pane.setPrefWidth(SCENE_WIDTH);
		pane.setPrefHeight(SCENE_HEIGHT);
		pane.getChildren().add(canvas);
		canvas.setVisible(true);
		gc = canvas.getGraphicsContext2D();
	}

	public void paintComponent() {
		System.out.println("--------------------------------------------------");
		for (Irenderable entity : RenderableHolder.getInstance().getEntities()) {
			System.out.println(entity.toString());
			if (entity.IsVisible() && !entity.isDestroyed()) {
				entity.draw(gc, 0); // edit later
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
			GameLogic.keyPressed(e);
		});
		this.setOnKeyReleased(e -> {
			GameLogic.keyRelease(e);
		});
	}

}
