package render;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

public class Resource {
	private static BufferedImage getImage(String directory) {
		BufferedImage im;
		try {
			ClassLoader loader = Resource.class.getClassLoader();
			im = ImageIO.read(loader.getResource(directory));
		} catch (Exception e) {
			im = null;
		}
		return im;
	}
	
	// stage 1
	public static BufferedImage Stage1,Ground1,ObstacleTall_11,ObstacleTall_12,ObstacleTall_13
				,Obstacl_11,Obstacl_12,Obstacl_13,Hero1;
	
	// stage 2
	public static BufferedImage Stage2,Ground2,ObstacleTall_21,ObstacleTall_22,ObstacleTall_23
				,Obstacl_21,Obstacl_22,Obstacl_23,Hero2,Boss2;
	
	// stage 3
	public static BufferedImage Stage3,Ground3,ObstacleTall_31,ObstacleTall_32,ObstacleTall_33
				,Obstacl_31,Obstacl_32,Obstacl_33,Hero3,Boss3;
	
	// stage 4
	public static BufferedImage Stage4,Ground4,ObstacleTall_41,ObstacleTall_42,ObstacleTall_43
				,Obstacl_41,Obstacl_42,Obstacl_43,Hero4,Boss4;
	
	// stage 5
	public static BufferedImage Stage5,Ground5,ObstacleTall_51,ObstacleTall_52,ObstacleTall_53
				,Obstacl_51,Obstacl_52,Obstacl_53,Hero5,Boss5;
	
	//monster
	public static BufferedImage Monster0,Monster1,Monster2,Monster3,Monster4,Monster5;
	
	//coin
	public static BufferedImage Coin2,Coin3,Coin4,Coin5;
	
	//DeadHero
	public static BufferedImage DeadHero1,DeadHero2,DeadHero3,DeadHero4,DeadHero5;
	
	static {
		
		//Monster ; monster0 = dead
		Monster0 = getImage("image/Monster0.png"); 
		Monster1 = getImage("image/Monster1.png");
		Monster2 = getImage("image/Monster2.png");
		Monster3 = getImage("image/Monster3.png");
		Monster4 = getImage("image/Monster4.png");
		Monster5 = getImage("image/Monster5.png");
		
		//Deadhero
		DeadHero1 = getImage("image/DeadHero1.png");
		DeadHero2 = getImage("image/DeadHero2.png");
		DeadHero3 = getImage("image/DeadHero3.png");
		DeadHero4 = getImage("image/DeadHero4.png");
		DeadHero5 = getImage("image/DeadHero5.png");
		
		//coin 
		Coin2 = getImage("image/Coin2.png"); 
		Coin3 = getImage("image/Coin3.png"); 
		Coin4 = getImage("image/Coin4.png"); 
		Coin5 = getImage("image/Coin5.png"); 
		
		//stage1
		Stage1 = getImage("image/Stage1.png");
		Ground1 = getImage("image/Ground1.png");
		ObstacleTall_11 = getImage("image/ObstacleTall_11.png");
		ObstacleTall_12 = getImage("image/ObstacleTall_12.png");
		ObstacleTall_13 = getImage("image/ObstacleTall_13.png");
		Obstacl_11 = getImage("image/Ostacl_11 .png");
		Obstacl_12 = getImage("image/Obstacl_12.png");
		Obstacl_13 = getImage("image/Obstacl_13.png");
		Hero1 = getImage("image/Hero1.png");
		
		//stage2
		Stage2 = getImage("image/Stage2.png");
		Ground2 = getImage("image/Ground2.png");
		ObstacleTall_21 = getImage("image/ObstacleTall_21.png");
		ObstacleTall_22 = getImage("image/ObstacleTall_22.png");
		ObstacleTall_23 = getImage("image/ObstacleTall_23.png");
		Obstacl_21 = getImage("image/Ostacl_21 .png");
		Obstacl_22 = getImage("image/Obstacl_22.png");
		Obstacl_23 = getImage("image/Obstacl_23.png");
		Hero2 = getImage("image/Hero2.png");
		
		//stage3
		Stage3 = getImage("image/Stage3.png");
		Ground3 = getImage("image/Ground3.png");
		ObstacleTall_31 = getImage("image/ObstacleTall_31.png");
		ObstacleTall_32 = getImage("image/ObstacleTall_32.png");
		ObstacleTall_33 = getImage("image/ObstacleTall_33.png");
		Obstacl_31 = getImage("image/Ostacl_31 .png");
		Obstacl_32 = getImage("image/Obstacl_32.png");
		Obstacl_33 = getImage("image/Obstacl_33.png");
		Hero3 = getImage("image/Hero3.png");
		
		//stage4
		Stage4 = getImage("image/Stage4.png");
		Ground4 = getImage("image/Ground4.png");
		ObstacleTall_41 = getImage("image/ObstacleTall_41.png");
		ObstacleTall_42 = getImage("image/ObstacleTall_42.png");
		ObstacleTall_43 = getImage("image/ObstacleTall_43.png");
		Obstacl_41 = getImage("image/Ostacl_41 .png");
		Obstacl_42 = getImage("image/Obstacl_42.png");
		Obstacl_43 = getImage("image/Obstacl_43.png");
		Hero4 = getImage("image/Hero4.png");
		
		//stage5
		Stage5 = getImage("image/Stage5.png");
		Ground5 = getImage("image/Ground5.png");
		ObstacleTall_51 = getImage("image/ObstacleTall_51.png");
		ObstacleTall_52 = getImage("image/ObstacleTall_52.png");
		ObstacleTall_53 = getImage("image/ObstacleTall_53.png");
		Obstacl_51 = getImage("image/Ostacl_51 .png");
		Obstacl_52 = getImage("image/Obstacl_52.png");
		Obstacl_53 = getImage("image/Obstacl_53.png");
		Hero5 = getImage("image/Hero5.png");
		
	}
	
}
