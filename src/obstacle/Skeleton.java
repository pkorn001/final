package obstacle;

import javafx.scene.canvas.GraphicsContext;
import logic.Position;
import move.ForwardMove;
import move.Move;
import render.Resource;

public class Skeleton extends Monster{

	public Skeleton(Position a, int monsterType, double xSpeed, double ySpeed) {
		super(a, monsterType, xSpeed, ySpeed);
		movePattern = new ForwardMove(this);
	}

	@Override
	public void draw(GraphicsContext g2d) {
		if (isDestroyed()) {
			g2d.drawImage(Resource.Monster,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
		}
		else {
		}
	}
}
