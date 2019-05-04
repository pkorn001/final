package item;

import java.awt.Graphics2D;

import javafx.scene.canvas.GraphicsContext;
import logic.Hitbox;
import logic.Position;
import render.Irenderable;
import render.Resource;

public abstract class Item extends Hitbox implements Irenderable {

	private int itemType;
	private int stage;
	/*
	 * 0 = normal 1 = red 2 = green 3 = black 4 = purple
	 */
	public static final String[] HERO_ITEM = { "Mage", "Boomeranger", "Swordman", "Assassin" };
	/*
	 * 0 = mage 1 = boomeranger 2 = swordman 3 = assassin
	 */

	public Item(Position a, int fps, int stage) {
		super(a, 1, 1, fps, 0);
		this.itemType = stage;
	}

	@Override
	public void draw(GraphicsContext g2d) {

		switch (HERO_ITEM[itemType]) {
		case ("Mage"):
			this.setStage(1);
			g2d.drawImage(Resource.Coin1, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
			break;
		case ("Boomeranger"):
			this.setStage(2);
			g2d.drawImage(Resource.Coin2, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
			break;
		case ("Swordman"):
			this.setStage(3);
			g2d.drawImage(Resource.Coin3, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
			break;
		case ("Assassin"):
			this.setStage(4);
			g2d.drawImage(Resource.Coin4, this.getB().getX(), this.getB().getY(), this.getWidth(), this.getHeight());
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
}
