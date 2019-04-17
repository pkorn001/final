package hero.base;

import item.Item;
import mechanic.Hitbox;
import mechanic.Position;

public class Hero extends Hitbox {
	
	public static final int HEIGHT = 100;
	private Hitbox hero;
	private boolean isDead = false;
	
	public Hero(int speed) {
		super(0);
		hero = new Hitbox(new Position(2, 0), 3, 5, speed) {
		};
	}

	public static int getHeight() {
		return HEIGHT;
	}

	public void setDead(boolean isDead) {
		this.isDead = isDead;
	}
	
	public void transform(Item item) {
		switch(item.getItemType()) {
		case("Assassin"):
			Hero assassin = new Assassin(0);
			break;
		case("Boomeranger"):
			Hero boomeranger = new Boomeranger(0);
			break;
		case("Mage"):
			Hero mage = new Mage(0);
			break;
		case("Swordman"):
			Hero swordman = new Swordman(0);
			break;
		}
		
		
	}
	
	public void jump() throws InterruptedException {
		this.setA(new Position(this.getA().getX(), this.getA().getY()+2)); //PosA same X increase Y by 2
		this.setB(new Position(this.getB().getX(), this.getB().getY()+2)); //PosB same X increase Y by 2
		this.setC(new Position(this.getC().getX(), this.getC().getY()+2)); //PosC same X increase Y by 2
		this.setD(new Position(this.getD().getX(), this.getD().getY()+2)); //PosD same X increase Y by 2
		wait(1000);            											   //wait 1 second before fall down
		this.setA(new Position(this.getA().getX(), this.getA().getY()-2)); //PosA get back to first Y-position
		this.setB(new Position(this.getB().getX(), this.getB().getY()-2)); //PosB get back to first Y-position
		this.setC(new Position(this.getC().getX(), this.getC().getY()-2)); //PosC get back to first Y-position
		this.setD(new Position(this.getD().getX(), this.getD().getY()-2)); //PosD get back to first Y-position
		
		//                        ****** Edit later; have no idea to code at all ******
	}
	
	public boolean isDead() {
		return isDead();
	}
	
	
}
