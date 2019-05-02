package hero.action;

import logic.Hitbox;
import logic.Position;

public class Boomerange extends Hitbox {
	
	private Position returnPoint;
	private Position originPoint;
	private boolean doneFirst = false;
	
	public Boomerange(Position position, int xSpeed, int ySpeed) {
		super(position, 1, 1, xSpeed, ySpeed);
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
			this.setA(new Position(this.A.getX()+1, this.A.getY()-2));
			this.setB(new Position(this.B.getX()+1, this.B.getY()-2));
			this.setC(new Position(this.C.getX()+1, this.C.getY()-2));
			this.setD(new Position(this.D.getX()+1, this.D.getY()-2));
		}else if(this.C.getX() >= returnPoint.getX() && this.C.getY() > originPoint.getY()){
			doneFirst = true;
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
	}
}
