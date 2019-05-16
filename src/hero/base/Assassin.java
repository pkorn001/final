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
			attackBox = new Hitbox(new Position(this.getC().getX() + 1, this.getC().getY()/2), 1, 1) {
			};
			didShort = true;
		} else {
			attackBox = new Hitbox(new Position(this.getC().getX()+5, this.getC().getY()/2), 1, 1){
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
		if(GameLogic.isAttack()) {
			if(!didShort) {
				g2d.drawImage(Resource.Hero4_Attack1, this.position.getX(), this.position.getY(), 167, 300);
			}else {
				g2d.drawImage(Resource.Hero4_Attack2, this.position.getX(), this.position.getY(), 167, 300);
			}
		}else {
			g2d.drawImage(Resource.Hero4, this.position.getX(), this.position.getY(), 167, 300);
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
				setSound(Resource.Hero4_Attack1_Sound);
			}else {
				setSound(Resource.Hero4_Attack2_Sound);
			}
			getSound().play();
		}
		if(i == 19) {
			GameLogic.setAttack(false);
		}else if(i > 19) {
			i = 0;
		}
	}
		
}

