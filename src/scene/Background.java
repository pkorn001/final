package scene;

import hero.base.Hero;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.media.AudioClip;
import logic.GameLogic;
import render.Irenderable;
import render.Resource;

public class Background implements Irenderable {
	// Stage0 & 2 has only 1 picture

	private double xSpeed;
	private double[] xlist = new double[10]; 
	private double xG = 0;
	private AudioClip sound;
	
	public Background() {
		// TODO Auto-generated constructor stub
		for (int i = 0; i < 10; i++) {
			xlist[i] = 1600*i;
		}
	}
	
	@Override
	public void draw(GraphicsContext g2d) {
		// TODO Auto-generated method stub
		switch (Hero.getStage()) {
		case (0):
			sound = Resource.Stage0_Music;
			if(!sound.isPlaying()) {
				sound.play();
			}
			g2d.drawImage(Resource.Stage0, xlist[0] , 0, 1600, 770);
			g2d.drawImage(Resource.Stage0, (xlist[1]), 0, 1600  , 770);
			g2d.drawImage(Resource.Stage0, xlist[2] , 0, 1600, 770);
			g2d.drawImage(Resource.Stage0, (xlist[3]), 0, 1600  , 770);
			g2d.drawImage(Resource.Stage0, xlist[4] , 0, 1600, 770);
			g2d.drawImage(Resource.Stage0, (xlist[5]), 0, 1600  , 770);
			g2d.drawImage(Resource.Stage0, xlist[6] , 0, 1600, 770);
			g2d.drawImage(Resource.Stage0, (xlist[7]), 0, 1600  , 770);
			g2d.drawImage(Resource.Stage0, xlist[8] , 0, 1600, 770);
			g2d.drawImage(Resource.Stage0, (xlist[9]), 0, 1600  , 770);
			g2d.drawImage(Resource.Ground0, xG, 330, 1600, 570);
			g2d.drawImage(Resource.Ground0, (xG + 1600), 330, 1600, 570);
			break;
		case (1):
			sound = Resource.Stage1_Music;
			if(!sound.isPlaying()) {
				sound.play();
			}
			g2d.drawImage(Resource.Stage10, xlist[0], 0, 1600, 780);
			g2d.drawImage(Resource.Stage13, xlist[1] , 0, 1600, 780);
			g2d.drawImage(Resource.Stage16, xlist[2] , 0, 1600, 780);
			g2d.drawImage(Resource.Stage12, xlist[3], 0, 1600  , 780);
			g2d.drawImage(Resource.Stage1_lava2, xlist[4] , 0, 1600, 780);
			g2d.drawImage(Resource.Stage11, xlist[5] , 0, 1600, 780);
			g2d.drawImage(Resource.Stage1_lava1, xlist[6], 0, 1600  , 780);
			g2d.drawImage(Resource.Stage16, xlist[7], 0, 1600, 780);
			g2d.drawImage(Resource.Stage12, xlist[8], 0, 1600  , 780);
			g2d.drawImage(Resource.Stage17, xlist[9] , 0, 1600, 780);
			g2d.drawImage(Resource.Ground1, xG, 330, 1600, 570);
			g2d.drawImage(Resource.Ground1, (xG + 1600), 330, 1600, 570);
			break;
		case (2):
			sound = Resource.Stage2_Music;
			if(!sound.isPlaying()) {
				sound.play();
			}
			g2d.drawImage(Resource.Stage21, xlist[0], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[1], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[0], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[1], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[2], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[3], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[4], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[5], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[6], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[7], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[8], 0, 1600, 820);
			g2d.drawImage(Resource.Stage21, xlist[9], 0, 1600, 820);
			g2d.drawImage(Resource.Ground2, xG, 330, 1600, 570);
			g2d.drawImage(Resource.Ground2, xG+1600, 330, 1600, 570);
			break;
		case (3):
			sound = Resource.Stage3_Music;
			if(!sound.isPlaying()) {
				sound.play();
			}
			g2d.drawImage(Resource.Stage32, xlist[0], 0, 1600, 770);
			g2d.drawImage(Resource.Stage33, xlist[1], 0, 1600, 770);
			g2d.drawImage(Resource.Stage31, xlist[2], 0, 1600, 770);
			g2d.drawImage(Resource.Stage30, xlist[3], 0, 1600, 770);
			g2d.drawImage(Resource.Stage34, xlist[4], 0, 1600, 770);
			g2d.drawImage(Resource.Stage30, xlist[5], 0, 1600, 770);
			g2d.drawImage(Resource.Stage31, xlist[6], 0, 1600, 770);
			g2d.drawImage(Resource.Stage33, xlist[7], 0, 1600, 770);
			g2d.drawImage(Resource.Stage32, xlist[8], 0, 1600, 770);
			g2d.drawImage(Resource.Ground3, xG, 330, 1600, 570);
			g2d.drawImage(Resource.Ground3, xG+1600, 330, 1600, 570);
			break;
		case (4):
			sound = Resource.Stage4_Music;
			if(!sound.isPlaying()) {
				sound.play();
			}
			g2d.drawImage(Resource.Stage44, xlist[0], 0, 1600, 770);
			g2d.drawImage(Resource.Stage40, xlist[1], 0, 1600, 770);
			g2d.drawImage(Resource.Stage41, xlist[2], 0, 1600, 770);
			g2d.drawImage(Resource.Stage40, xlist[3], 0, 1600, 770);
			g2d.drawImage(Resource.Stage4_prisoner2, xlist[4], 0, 1600, 770);
			g2d.drawImage(Resource.Stage43, xlist[5], 0, 1600, 770);
			g2d.drawImage(Resource.Stage40, xlist[6], 0, 1600, 770);
			g2d.drawImage(Resource.Stage4_prisoner1, xlist[7], 0, 1600, 770);
			g2d.drawImage(Resource.Stage41, xlist[8], 0, 1600, 770);
			g2d.drawImage(Resource.Ground4, xG, 330, 1600, 570);
			g2d.drawImage(Resource.Ground4, xG+1600, 330, 1600, 570);
			break;
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
		return Integer.MIN_VALUE;
	}

	@Override
	public boolean isDestroyed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public void update() {
		if(!GameLogic.getHero().isDestroyed()) {
			xSpeed = -20 * GameLogic.getSpeedFactor();
		}else {
			xSpeed = 0;
		}
		for (int i = 0; i < 10 ; i++) {
			xlist[i] += xSpeed/3;
		}
		
		xG += xSpeed;
		
		switch (Hero.getStage()) {
		case (0):	
			for (int i = 0; i < 10 ; i++) {
				if (xlist[i] < -1600) {
					xlist[i] = 1600*9;
				}
			}
			break;
		case (1):
			for (int i = 0; i < 10 ; i++) {
				if (xlist[i] < -1600) {
					xlist[i] = 1600*9;
				}
			}
			break;
		case (2):
			for (int i = 0; i < 10 ; i++) {
				if (xlist[i] < -1600) {
					xlist[i] = 1600*9;
				}
			}
			break;
		case (3):
			for (int i = 0; i < 9 ; i++) {
				if (xlist[i] < -1600) {
					xlist[i] = 1600*8;
				}
			} 
			break;
		case (4):
			for (int i = 0; i < 9 ; i++) {
				if (xlist[i] < -1600) {
					xlist[i] = 1600*8;
				}
			}
			break;
		}
		
		if (xG < -1600) {
			xG = 0;
		}
	}
}
