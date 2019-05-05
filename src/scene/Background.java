package scene;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import render.Irenderable;
import render.Resource;

public class Background implements Irenderable {
	// Stage0 & 2 has only 1 picture
	private int z = Integer.MAX_VALUE;

	private int x;
	private Image image;

	public Background(int x) {
		this.x = x;
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
		switch (Hero.getStage()) {
		case (0):
			g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
			break;
		case (1):
			g2d.drawImage(Resource.Stage10, 0, 0, 1600, 900);
			break;
		case (2):
			g2d.drawImage(Resource.Stage2, 0, 0, 1600, 900);
			break;
		case (3):
			g2d.drawImage(Resource.Stage30, 0, 0, 1600, 900);
			break;
		case (4):
			g2d.drawImage(Resource.Stage40, 0, 0, 1600, 900);
			break;
		}
		
		
	}

	public Image getImage() {
		return this.image;
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

}
