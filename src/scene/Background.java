package scene;

import java.awt.image.BufferedImage;
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
	// Stage0 & 2 has only 1 picture
	public static List<Image> stages1;
	public static List<Image> stages3;
	public static List<Image> stages4;
	private int z = Integer.MAX_VALUE;

	private int x;
	private int y;
	private Image image;

	public Background() {
		this(0);
	}

	public Background(int x) {
		this.x = x;
	}

	public static void loadResource() {
		stages1.add(Resource.Stage10);
		stages1.add(Resource.Stage11);
		stages1.add(Resource.Stage12);
		stages1.add(Resource.Stage13);
		stages1.add(Resource.Stage14);
		stages1.add(Resource.Stage15);
		stages1.add(Resource.Stage16);
		stages1.add(Resource.Stage17);
		stages1.add(Resource.Stage1_lava1);
		stages1.add(Resource.Stage1_lava2);
		
		stages3.add(Resource.Stage30);
		stages3.add(Resource.Stage31);
		stages3.add(Resource.Stage32);
		stages3.add(Resource.Stage33);
		stages3.add(Resource.Stage34);
		
		stages4.add(Resource.Stage40);
		stages4.add(Resource.Stage41);
		stages4.add(Resource.Stage42);
		stages4.add(Resource.Stage43);
		stages4.add(Resource.Stage44);
		stages4.add(Resource.Stage4_prisoner1);
		stages4.add(Resource.Stage4_prisoner2);
	}

	@Override
	public void draw(GraphicsContext g2d, long time) {
		// TODO Auto-generated method stub
		g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
//		switch (Hero.getStage()) {
//		case (0):
//			g2d.drawImage(Resource.Stage0, 0, 0, 1600, 900);
//			image = Resource.Stage0;
//			break;
//		case (1):
//			image = getRandomElement(stages1);
//			g2d.drawImage(image, 0, 0, 1600, 900);
//			break;
//		case (2):
//			g2d.drawImage(Resource.Stage2, 0, 0, 1600, 900);
//			image = Resource.Stage2;
//			break;
//		case (3):
//			image = getRandomElement(stages3);
//			g2d.drawImage(image, 0, 0, 1600, 900);
//			break;
//		case (4):
//			image = getRandomElement(stages4);
//			g2d.drawImage(image, 0, 0, 1600, 900);
//			break;
//		}
		
	}

	public Image getImage() {
		return this.image;
	}

	public Image getRandomElement(List<Image> list) {
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
