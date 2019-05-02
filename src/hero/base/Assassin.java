package hero.base;

import java.awt.Graphics2D;

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

	@Override
	public void draw(Graphics2D g2d) {
		// TODO Auto-generated method stub
		
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

}
