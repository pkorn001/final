package hero.base;

import hero.action.Attackable;
import mechanic.Hitbox;
import mechanic.Position;

public class Mage extends Hero implements Attackable {
	
	public Mage(int speed) {
		super(0);
		Hitbox mage = new Hitbox(new Position(2, 0), 3, 5, speed) {
		};
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {

	}

}
