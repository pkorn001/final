package boss;


import javafx.scene.canvas.GraphicsContext;
import logic.Position;
import render.Irenderable;
import render.Resource;

public class ParriedBall extends BossAttack implements Irenderable {
	
	private int z;
	private boolean isParried;

	public ParriedBall(Position a, int width, int height, int xSpeed, int ySpeed) {
		super(a, width, height, xSpeed, ySpeed);
		z = Integer.MAX_VALUE;
		isParried = false;
	}
	
	@Override
	public void draw(GraphicsContext g2d) {
		if (!isParried) {
			g2d.drawImage(Resource.ParriedBall1,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
	}
		else {
			IsVisible();
		}
	}
	
	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return !isParried();
	}
	
	public boolean isParried() {
		return isParried;
	}

	public void setParried(boolean isParried) {
		this.isParried = isParried;
	}
}
