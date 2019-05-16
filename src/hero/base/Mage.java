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
	private int i = 0;
	private FireBall fireball;
	
	public Mage(Position position) {
		super(position);
		setStage(1);
	}

	public FireBall getAttack() {
		fireball = new FireBall(new Position(this.getB().getX()+15, this.getB().getY()+90));
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
		g2d.drawImage(Resource.BossAttack,A.getX(),A.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,B.getX(),B.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,C.getX(),C.getY(),5,5);
		g2d.drawImage(Resource.BossAttack,D.getX(),D.getY(),5,5);
		// TODO Auto-generated method stub
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero1_Attack, getB().getX(), getB().getY(), this.getWidth(), this.getHeight());
			GameLogic.setAttack(false);
		}else {
			g2d.drawImage(Resource.Hero1, getB().getX(), getB().getY(), this.getWidth(), this.getHeight());
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
		if(i < 10) {
			Resource.Hero1_Attack_Sound.play();
		}else {
			i = 0;
		}
	}

}
