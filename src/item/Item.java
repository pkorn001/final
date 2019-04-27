package item;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import logic.Hitbox;
import logic.Position;

public abstract class Item extends Hitbox {
	
	private Image img;
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

	public Item(Position a, int fps, int type, int stage) {
		super(fps);
		this.itemType = type;
		Position A = new Position(a.getX(), a.getY());
		Position B = new Position(a.getX(), a.getY()+1);
		Position C = new Position(a.getX()+1, a.getY()+1);
		Position D = new Position(a.getX()+1, a.getY());
		
		switch(HERO_ITEM[itemType]) {
		case("Mage"):
			this.setStage(1);
			Image mgImage = new Image("file:res/" + "Mage_item.png");
			//this.setGraphic(new ImageView(mgImage));
			break;
		case("Boomeranger"):
			this.setStage(2);
			Image bmImage = new Image("file:res/" + "Boomeranger_item.png");
			break;
		case("Swordman"):
			this.setStage(3);
			Image swImage = new Image("file:res/" + "Swordman_item.png");
			break;
		case("Assassin"):
			this.setStage(4);
			Image asImage = new Image("file:res/" + "Assassin_item.png");
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
