package hero.base;

import hero.action.Attackable;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Hitbox;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;
import render.Resource;

public class Assassin extends Hero implements Attackable,Irenderable{

	private static Hitbox attackBox;
	private static boolean didShort = false;
	private int i = 0;
	
	public Assassin(Position position) {
		super(position);
		setStage(4);
	}
	
	@Override
	public Hitbox getAttack() {
		// TODO Auto-generated method stub
		if (!didShort) {
			attackBox = new Hitbox(new Position(this.getC().getX() + 50, this.getC().getY()), 130, 250) {
			};
			didShort = true;
		} else {
			attackBox = new Hitbox(new Position(this.getC().getX() + 70, this.getC().getY()), 130, 250){
			};
			didShort = false;
		}
		return attackBox;
	}
	
	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Hero4, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
		g2d.drawImage(Resource.BossAttack, getA().getX(), getA().getY(),10,10);
		g2d.drawImage(Resource.BossAttack, getB().getX(), getB().getY(),10,10);
		g2d.drawImage(Resource.BossAttack, getC().getX(), getC().getY(),10,10);
		g2d.drawImage(Resource.BossAttack, getD().getX(), getD().getY(),10,10);
		if(GameLogic.isAttack()) {
			if(!didShort) {
				g2d.drawImage(Resource.Hero4_Attack1, B.getX(), B.getY(), this.getWidth(), this.getHeight());
			}else {
				g2d.drawImage(Resource.Hero4_Attack2, B.getX(), B.getY(), this.getWidth(), this.getHeight());
			}
		}else {
			g2d.drawImage(Resource.Hero4, B.getX(), B.getY(), this.getWidth(), this.getHeight());
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

	public static boolean isDidShort() {
		return didShort;
	}
	

	public static Hitbox getAttackBox() {
		return attackBox;
	}

	@Override
	public void attack() {
		// TODO Auto-generated method stub
		i++;
		if(i <= 4) {
			if(!didShort) {
				Resource.Hero4_Attack1_Sound.play();
			}else {
				Resource.Hero4_Attack2_Sound.play();
			}
		}
		if(i == 10) {
			GameLogic.setAttack(false);
		}else if(i > 10) {
			i = 0;
		}
	}
		
}

