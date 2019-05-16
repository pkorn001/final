package hero.action;


import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.EvilFairy;
import obstacle.Monster;
import obstacle.Slime;
import render.Irenderable;
import render.Resource;

public class Boomerang extends Hitbox implements Irenderable {
	
	private Position returnPoint;
	private Position originPoint;
	private Hitbox hero;
	private boolean isReturn = false;
	private boolean doneFirst = false;
	
	public Boomerang(Position position) {
		super(position, 1, 1, 0, 0);
		originPoint = new Position(position.getX(), position.getY());
		returnPoint = new Position(position.getX() + 8, position.getY()/2 + 4);
	}
	
	public void move() {
		if(this.C.getX() < returnPoint.getX() && this.C.getY()/2 < returnPoint.getY()) {
			this.setA(new Position(this.A.getX()+2, this.A.getY()+1));
			this.setB(new Position(this.B.getX()+2, this.B.getY()+1));
			this.setC(new Position(this.C.getX()+2, this.C.getY()+1));
			this.setD(new Position(this.D.getX()+2, this.D.getY()+1));
		}else if(this.C.getX() >= returnPoint.getX() && this.C.getY() > returnPoint.getY()) {
			doneFirst = true;
			this.setA(new Position(this.A.getX()+1, this.A.getY()-2));
			this.setB(new Position(this.B.getX()+1, this.B.getY()-2));
			this.setC(new Position(this.C.getX()+1, this.C.getY()-2));
			this.setD(new Position(this.D.getX()+1, this.D.getY()-2));
		}else if(this.C.getX() >= returnPoint.getX() && this.C.getY() > originPoint.getY()){
			this.setA(new Position(this.A.getX()-1, this.A.getY()-2));
			this.setB(new Position(this.B.getX()-1, this.B.getY()-2));
			this.setC(new Position(this.C.getX()-1, this.C.getY()-2));
			this.setD(new Position(this.D.getX()-1, this.D.getY()-2));
		}else if(doneFirst  && this.C.getX() > originPoint.getX() && this.C.getY() == originPoint.getY()) {
			this.setA(new Position(this.A.getX()-2, this.A.getY()));
			this.setB(new Position(this.B.getX()-2, this.B.getY()));
			this.setC(new Position(this.C.getX()-2, this.C.getY()));
			this.setD(new Position(this.D.getX()-2, this.D.getY()));	
		}
		if(this.collide(hero)) {
			setReturn(true);
		}
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return this.collide(hero);
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Boomerang, originPoint.getX(), originPoint.getY());
	}

	public boolean isReturn() {
		return isReturn;
	}

	public void setReturn(boolean isReturn) {
		this.isReturn = isReturn;
	}
}
