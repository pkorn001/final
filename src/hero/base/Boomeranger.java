package hero.base;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;

public class Boomeranger extends Hero implements Attackable {
	
	private Hitbox attackBox;
	private Position returnPoint = new Position(this.C.getX() + 8, 4);
	
	public Boomeranger(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public boolean attack() {
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
		return false;
	}

	@Override
	public void updateScore() {
		// TODO Auto-generated method stub
		if(this.attack()) {
			score += monster.getMonsterPoint();
		}
	}
	
}
