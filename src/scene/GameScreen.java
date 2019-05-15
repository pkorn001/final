package scene;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import render.Irenderable;
import render.RenderableHolder;

public class GameScreen extends Canvas {

	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;

	private boolean inGame = true;
	GraphicsContext gc;

	public GameScreen() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		this.setVisible(true);
		gc = this.getGraphicsContext2D();
	}
	
	public void paintComponent() {
		System.out.println("-----------------------------------------");
		for (Irenderable entity : RenderableHolder.getInstance().getEntities()) {
			if (entity.IsVisible() && !entity.isDestroyed()) {
				System.out.println(entity);
				entity.draw(gc); // edit later
			}
		}
	}

	public boolean isInGame() {
		return inGame;
	}

	public void setInGame(boolean inGame) {
		this.inGame = inGame;
	}

}
