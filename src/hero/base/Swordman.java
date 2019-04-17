package hero.base;

import hero.action.Attackable;
import mechanic.Hitbox;
import mechanic.Position;

public class Swordman extends Hero implements Attackable {

	public Swordman(int speed) {
		super(0);
		Hitbox swordman = new Hitbox(new Position(2, 0), 3, 5, speed) {
		};
		
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		
	}

}
