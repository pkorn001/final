package hero.action;

import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import move.SineMove;
import render.Irenderable;
import render.Resource;

public class Boomerang extends Hitbox implements Irenderable {

	private double i;
	private boolean isDestroyed = false;

	public Boomerang(Position position) {
		super(position, 150, 150, 20, 0);
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDestroyed() {  //destroyed when return
		// TODO Auto-generated method stub
		return isDestroyed;
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Boomerang, this.B.getX(),this.B.getY(), 90, 90);
	}

	public void setDestroyed(boolean isDestroyed) {
		this.isDestroyed = isDestroyed;
	}
	
	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(this.getB().getX() >= 1000) {
			this.setxSpeed(-20);
		}
		
		for(Position i  : new Position[] {this.A, this.B, this.C, this.D}){
			i.setX(i.getX() + this.xSpeed);
			i.setY(i.getY() + this.ySpeed);
		}
	}
	
	
	
}
