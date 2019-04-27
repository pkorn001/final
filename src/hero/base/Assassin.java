package hero.base;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;

public class Assassin extends Hero implements Attackable {

	private Hitbox attack;

	public Assassin(int speed) {
		super(0);
//		assassin = new Hitbox(new Position(2, 0), 3, 5, speed) {
//		};
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		boolean didShort = false;
		if (!didShort) {
			attack = new Hitbox(new Position(this.C.getX() + 1, this.C.getY()), 1, 1) {
			};
		} else {
			attack = new Hitbox(new Position(this.C.getX()+5, this.C.getY()), 1, 1) {
			};
		}
		if(attack.collide(monster)) {
			monster.setDestroyed(true);
		}
	}

}
