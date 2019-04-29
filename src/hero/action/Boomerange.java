package hero.action;

import logic.Hitbox;
import logic.Position;

public class Boomerange extends Hitbox {
	
	public Boomerange(Position position, int xSpeed, int ySpeed) {
		super(position, 1, 1, xSpeed, ySpeed);
	}
	private Position returnPoint = new Position(this.C.getX() + 8, 4);
	
	public void move() {
		for(int i=0; i < this.returnPoint.getX(); i+=2) {
			this.setA(new Position(this.A.getX()+2, this.A.getY()+1));
			this.setB(new Position(this.B.getX()+2, this.B.getY()+1));
			this.setC(new Position(this.C.getX()+2, this.C.getY()+1));
			this.setD(new Position(this.D.getX()+2, this.D.getY()+1));
		}
		for(int i=0; i < this.returnPoint.getY()/2; i+=2) {
			this.setA(new Position(this.A.getX()+1, this.A.getY()-2));
			this.setB(new Position(this.B.getX()+1, this.B.getY()-2));
			this.setC(new Position(this.C.getX()+1, this.C.getY()-2));
			this.setD(new Position(this.D.getX()+1, this.D.getY()-2));
		}
		for(int i=0; i < this.returnPoint.getX(); i+=2) {
			this.setA(new Position(this.A.getX()-2, this.A.getY()));
			this.setB(new Position(this.B.getX()-2, this.B.getY()));
			this.setC(new Position(this.C.getX()-2, this.C.getY()));
			this.setD(new Position(this.D.getX()-2, this.D.getY()));		
		}
	}
}
