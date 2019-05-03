package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;

public class Assassin extends Hero implements Attackable {

	private Hitbox attackBox;
	private boolean didShort = false;
	
	public Assassin(Position position, int speed) {
		super(position, speed);
	}

	@Override
	public void attack() {
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
	}
	
	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		score += monster.getMonsterPoint();
		monster.setDestroyed(true);
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

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		
	}

}
