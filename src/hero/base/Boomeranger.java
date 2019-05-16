package hero.base;

import hero.action.Attackable;
import hero.action.Boomerang;
import javafx.scene.canvas.GraphicsContext;
import logic.GameLogic;
import logic.Position;
import obstacle.Monster;
import render.Irenderable;
import render.Resource;

public class Boomeranger extends Hero implements Attackable,Irenderable {

	private boolean isAttacked = false;
	private Boomerang boomerang;
	

	public Boomeranger(Position position) {
		super(position);
		setStage(2);
	}
	
	@Override
	public Boomerang getAttack() {
		boomerang = new Boomerang(new Position(this.position.getX() + 10, this.position.getY() + 70));
		return boomerang;
	}

	@Override
	public void updateScore(Monster monster) {
		// TODO Auto-generated method stub
		setScore( getScore() + monster.getMonsterPoint());
	}

	@Override
	public void draw(GraphicsContext g2d) {
		if(GameLogic.isAttack()) {
			g2d.drawImage(Resource.Hero2_Attack, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
		}else {
			g2d.drawImage(Resource.Hero2, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
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

	public void setAttacked(boolean isAttacked) {
		this.isAttacked = isAttacked;
	}

	@Override
	public void attack() {
		Resource.Hero2_Attack_Sound.play();
		// TODO Auto-generated method stub
		
	}
}
