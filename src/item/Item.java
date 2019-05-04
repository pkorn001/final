package item;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import render.Irenderable;
import render.Resource;

public class Item extends Hitbox implements Irenderable {
	
	private int itemType;
	private int stage;
	/* 0 = normal 
	 1 = red 
	 2 = green
	 3 = black
	 4 = purple */
	public static final String[] HERO_ITEM = {"Mage", "Boomeranger", "Swordman", "Assassin"};
	/* 0 = mage
	   1 = boomeranger
	   2 = swordman
	   3 = assassin
	*/

	public Item(Position a, int fps, int stage) {
		super(a, fps);
		super.A = new Position(a.getX(), a.getY());
		super.B = new Position(a.getX(), a.getY()+1);
		super.C = new Position(a.getX()+1, a.getY()+1);
		super.D = new Position(a.getX()+1, a.getY());
		this.itemType = stage;
		}
	
		@Override
		public void draw(GraphicsContext g2d) {

		switch(HERO_ITEM[itemType]) {
		case("Mage"):
			g2d.drawImage(Resource.Coin1,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
			break;
		case("Boomeranger"):
			g2d.drawImage(Resource.Coin2,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
			break;
		case("Swordman"):
			g2d.drawImage(Resource.Coin3,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
			break;
		case("Assassin"):
			g2d.drawImage(Resource.Coin4,this.getB().getX(),this.getB().getY(),this.getWidth(),this.getHeight());
			break;
		}	
	}
	public String getItemType() {
		return HERO_ITEM[this.itemType];
	}

	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

	public int getStage() {
		return stage;
	}

	public void setStage(int stage) {
		this.stage = stage;
	}

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
}
