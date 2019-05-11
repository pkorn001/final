package scene;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import render.Irenderable;
import render.Resource;

public class Background implements Irenderable {
	// Stage0 & 2 has only 1 picture

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		switch (Hero.getStage()) {
		case (0):
			g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
			g2d.drawImage(Resource.Ground0, 0, 400, 1600, 500);
			break;
		case (1):
			g2d.drawImage(Resource.Stage10, 0, 0, 1600, 900);
			g2d.drawImage(Resource.Ground1, 0, 400, 1600, 500);
			break;
		case (2):
			g2d.drawImage(Resource.Stage2, 0, 0, 1600, 900);
			g2d.drawImage(Resource.Ground2, 0, 400, 1600, 500);
			break;
		case (3):
			g2d.drawImage(Resource.Stage30, 0, 0, 1600, 900);
			g2d.drawImage(Resource.Ground3, 0, 400, 1600, 500);
			break;
		case (4):
			g2d.drawImage(Resource.Stage40, 0, 0, 1600, 900);
			g2d.drawImage(Resource.Ground4, 0, 400, 1600, 500);
			break;
		}
	}


	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}

}
