package hero.base;

import hero.action.Attackable;
import hero.action.Boomerang;
import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Position;
import obstacle.Monster;
import render.Resource;

public class Boomeranger extends Hero implements Attackable {

	private boolean isJumped =  false;
	private boolean isAttacked = false;
	private Boomerang boomerang;
	

	public Boomeranger(Position position) {
		super(position);
		setStage(2);
	}
	
	@Override
	public void attack() {
		boomerang = new Boomerang(new Position(this.getC().getX() + 1, this.getC().getY() / 2));
		new AnimationTimer() {

			@Override
			public void handle(long now) {
				boomerang.move();
			}
		}.start();
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}

	@Override
	public void draw(GraphicsContext g2d, long  time) {
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero2_Attack, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
		}else {
			g2d.drawImage(Resource.Hero2, this.getA().getX(), this.getA().getY(), this.getWidth(), this.getHeight());
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

	public boolean isJumped() {
		return isJumped;
	}

	public Boomerang getBoomerang() {
		return boomerang;
	}

	public void setJumped(boolean isJumped) {
		this.isJumped = isJumped;
	}

	public boolean isAttacked() {
		return isAttacked;
	}

	public void setAttacked(boolean isAttacked) {
		this.isAttacked = isAttacked;
	}
}
