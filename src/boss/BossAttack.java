package boss;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import render.Irenderable;
import render.Resource;

public class BossAttack  extends Hitbox implements Irenderable {
	private int z;
	
	public BossAttack(Position a, int width, int height, int xSpeed, int ySpeed) {
		super(a, width, height, xSpeed, ySpeed);
		z = Integer.MAX_VALUE;
	}


	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.BossAttack,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());

	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z--;
	}


	@Override
	public boolean isDestroyed() {
		return false;
	}
	
}
