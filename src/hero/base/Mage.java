package hero.base;

import hero.action.Attackable;
import hero.action.FireBall;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;
import render.Resource;

public class Mage extends Hero implements Attackable, Irenderable {
	private int i;
	private FireBall fireball;
	
	public Mage(Position position) {
		super(position);
		this.position = position;
		setStage(1);
	}

	public FireBall getAttack() {
		fireball = new FireBall(new Position(this.position.getX(), this.position.getY()+20));
		return fireball;
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore(getStage()+monster.getMonsterPoint());
		monster.setDestroyed(true);
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero1_Attack, this.position.getX(), this.position.getY(), 167, 300);
		}else {
			g2d.drawImage(Resource.Hero1, this.position.getX(), this.position.getY(),167,300);
		}
	}
	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return 5;
	}

	@Override
	public void attack() {
		i++;
		if(i <= 10) {
			setSound(Resource.Hero1_Attack_Sound);
			getSound().play();
		}else {
			i = 0;
		}
	}

}
