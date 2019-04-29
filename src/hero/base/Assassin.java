package hero.base;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;

public class Assassin extends Hero implements Attackable {

	private Hitbox attackBox;
	private boolean didShort = false;
	
	public Assassin(Position position, int speed) {
		super(position, speed);
//		assassin = new Hitbox(new Position(2, 0), 3, 5, speed) {
//		};
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean attack() {
		// TODO Auto-generated method stub
		if (!didShort) {
			this.attackBox = new Hitbox(new Position(this.C.getX() + 1, this.C.getY()/2), 1, 1) {
			};
			this.didShort = true;
		} else {
			this.attackBox = new Hitbox(new Position(this.C.getX()+5, this.C.getY()/2), 1, 1){
			};
			this.didShort = false;
		}
		if(this.attackBox.collide(monster)) {
			monster.setDestroyed(true);
			return true;
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
