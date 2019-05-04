package scene;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import render.Irenderable;
import render.Resource;

public class Background implements Irenderable {
	//Stage0 & 2 has only 1 picture
	public static List<Image> stages1;
	public static List<Image> stages3;
	public static List<Image> stages4;
	private int z = Integer.MAX_VALUE;

	static {
		loadResource();
	}

	public static void loadResource() {
		stages1.addAll(Arrays.asList(new Image[] {Resource.Stage10,Resource.Stage11,Resource.Stage12,Resource.Stage13,Resource.Stage14,Resource.Stage15,Resource.Stage16,Resource.Stage17,Resource.Stage1_lava1,Resource.Stage1_lava2} ));
		stages3.addAll(Arrays.asList(new Image[] {Resource.Stage30,Resource.Stage31,Resource.Stage32,Resource.Stage33,Resource.Stage34} ));
		stages4.addAll(Arrays.asList(new Image[] {Resource.Stage40,Resource.Stage41,Resource.Stage42,Resource.Stage43,Resource.Stage44,Resource.Stage4_prisoner1,Resource.Stage4_prisoner2}));
	}

	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		switch(Hero.getStage()) {
		case(0):
			g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
			break;
		case(1):
			g2d.drawImage(getRandomElement(stages1), 0, 0, 1600, 900);
			break;
		case(2):
			g2d.drawImage(Resource.Stage2, 0, 0, 1600, 900);
			break;
		case(3):
			g2d.drawImage(getRandomElement(stages3), 0, 0, 1600, 900);
			break;
		case(4):
			g2d.drawImage(getRandomElement(stages4), 0, 0, 1600, 900);
			break;
		}
	}
	
	public Image getRandomElement(List<Image> list) 
    { 
        Random rand = new Random(); 
        return list.get(rand.nextInt(list.size())); 
    } 

	@Override
	public boolean IsVisible() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public int getZ() {
		// TODO Auto-generated method stub
		return z;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
}
