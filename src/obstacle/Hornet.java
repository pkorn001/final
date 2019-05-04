package obstacle;

import javafx.scene.canvas.GraphicsContext;
import logic.Position;
import move.ForwardMove;
import render.Resource;

public class Hornet extends Monster{

	public Hornet(Position a,int width,int height,int monsterType, double xSpeed, double ySpeed) {
		super(a,width,height,monsterType, xSpeed, ySpeed);
		movePattern = new ForwardMove(this);
	}
	
	@Override
	public void draw(GraphicsContext g2d) {
		if (isDestroyed()) {
			g2d.drawImage(Resource.Dead,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
		else {
			g2d.drawImage(Resource.Monster3,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
	}
}