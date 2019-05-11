package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Assassin extends Hero implements Attackable{

	private static Hitbox attackBox;
	private static boolean didShort = false;
	public static boolean isDidShort() {
		return didShort;
	}

	private boolean isJumped = false;
	private boolean isAttacked = false;
	
	public Assassin(Position position, int speed) {
		super(position);
	}
	
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		if (!didShort) {
			attackBox = new Hitbox(new Position(this.getC().getX() + 1, this.getC().getY()/2), 1, 1) {
			};
			didShort = true;
		} else {
			attackBox = new Hitbox(new Position(this.getC().getX()+5, this.getC().getY()/2), 1, 1){
			};
			didShort = false;
		}
	}
	
	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}

	public static Hitbox getAttackBox() {
		return attackBox;
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		if(GameLogic.isAttack()) {
			if(!didShort) {
				g2d.drawImage(Resource.Hero4_Attack1, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
			}else {
				g2d.drawImage(Resource.Hero4_Attack2, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
			}
		}else {
			g2d.drawImage(Resource.Hero4, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
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
		return z--;
	}

}
