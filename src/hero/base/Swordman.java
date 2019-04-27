package hero.base;

import hero.action.Attackable;
import logic.Hitbox;
import logic.Position;

public class Swordman extends Hero implements Attackable {

	private Hitbox attack = new Hitbox(new Position(this.C.getX()+1, this.C.getY()), 1, 1) {
	};
	
	public Swordman(int speed) {
		super(0);
	}

	@Override
	public void attack() {
		if(attack.collide(monster)) {
			score += monster.getMonsterPoint();
			monster.setDestroyed(true);
		}
		return;
	}

}
