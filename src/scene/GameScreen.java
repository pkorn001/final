package scene;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import render.Irenderable;
import render.RenderableHolder;
import render.Resource;

public class GameScreen extends Canvas {

	public static final int SCENE_WIDTH = 1600;
	public static final int SCENE_HEIGHT = 900;
	private Background background;
	private Image image;
	private Image image2;
	private WritableImage croppedImage;
	private WritableImage croppedImage2;
	private Canvas canvas = new Canvas(1600, 900);
	private boolean inGame = true;

	public GameScreen() {
		super(SCENE_WIDTH, SCENE_HEIGHT);
		this.setVisible(true);
		background = new Background();
		RenderableHolder.getInstance().getEntities().add(background);
	}

	public void update(long time) {
		GraphicsContext g2d = this.getGraphicsContext2D();
		draw(g2d, time);

	}

	public void draw(GraphicsContext g2d, long currentTime) {
//		Background.loadResource();
		image = Resource.Stage0;
		g2d.drawImage(image, currentTime % SCENE_WIDTH, 0, SCENE_WIDTH, SCENE_HEIGHT);

	}

	public void paintComponent() {

		GraphicsContext gc = this.getGraphicsContext2D();
		for (Irenderable entity : RenderableHolder.getInstance().getEntities()) {
			// System.out.println(entity.getZ());
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

}
