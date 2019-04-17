package hero.base;

import hero.action.Attackable;
import mechanic.Hitbox;
import mechanic.Position;

public class Assassin extends Hero implements Attackable {
	
	private Hitbox assassin;

	public Assassin(int speed) {
		super(0);
		assassin = new Hitbox(new Position(2, 0), 3, 5, speed) {
		};
		// TODO Auto-generated constructor stub
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		boolean didShort = false;
		if(!didShort) {
			
		}
	}

}
