package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Swordman extends Hero implements Attackable {

	private static Hitbox attackBox;
	private boolean isAttacked = false;
	private int i = 0;

	public Swordman(Position position) {
		super(position);
		setStage(3);
	}

	@Override
	public Hitbox getAttack() {
		attackBox = new Hitbox(new Position(this.position.getX() + 50, this.position.getY()), 130, 250) {
		};
		return attackBox;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		i++;
		if(i <= 4) {
			Resource.Hero3_Attack_Sound.play();
		}
		if(i == 19) {
			GameLogic.setAttack(false);
		}else if(i > 19) {
			i = 0;
		}
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}


	@Override
	public void draw(GraphicsContext g2d) {
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero3_Attack, this.getB().getX(), this.getB().getY(), this.getWidth()+60, this.getHeight());
		}else {
			g2d.drawImage(Resource.Hero3, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
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

	public boolean isAttacked() {
		return isAttacked;
	}
	
	public static Hitbox getAttackBox() {
		return attackBox;
	}

	public void setAttacked(boolean isAttacked) {
		this.isAttacked = isAttacked;
	}
}
