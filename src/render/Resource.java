package render;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;

public class Resource {
	
	private static Image getImage(String directory) {
		Image im;
		try {
			String image_path = ClassLoader.getSystemResource(directory).toString();
			im = new Image(image_path);
		} catch (Exception e) {
			im = null;
		}
		return im;
	}
	
	// stage 0 normal
	public static Image Stage0,ObstacleTall_0,Obstacle_0,Hero0,Ground0;
	
	// stage 1 red
	public static Image Stage10,Stage11,Stage12,Stage13,Stage14,Stage15,Stage16,Stage17,Stage1_lava1,Stage1_lava2,ObstacleTall_1
						,Obstacle_1,Hero1,Hero1_Attack,Ground1;
	
	// stage 2 green
	public static Image Stage2,ObstacleTall_2,Obstacle_2,Hero2,Hero2_Attack,Ground2;
	
	// stage 3 black
	public static Image Stage30,Stage31,Stage32,Stage33,Stage34,ObstacleTall_3,Obstacle_3,Hero3,Hero3_Attack,Ground3;
	
	// stage 4 purple
	public static Image Stage40,Stage41,Stage42,Stage43,Stage44,Stage4_prisoner1,Stage4_prisoner2,ObstacleTall_4,Obstacle_4,Hero4,Hero4_Attack1,Hero4_Attack2,Ground4;
	
	//monster
	public static Image Dead,Monster1,Monster2,Monster3,Monster4,Monster5,Monster6,Monster6_Jump1,Boss,HardBoss;
	
	//coin
	public static Image Coin1,Coin2,Coin3,Coin4;
	
	//HeroAttack
	public static Image FireBall, Boomerang;
	
	//BossAttack
	public static Image BossAttack,ParriedBall1,ParriedBall2;
	
	//GameLogo
	public static Image Logo;
	
	static {
		
		Logo = getImage("image/Logo.png");
		
		//HeroAttack
		FireBall = getImage("image/FireBall.png");
		Boomerang  = getImage("image/Boomerange.png");
		Hero1_Attack = getImage("image/Hero1_Attack.gif");
		Hero2_Attack = getImage("image/Hero2_Attack.gif");
		Hero3_Attack = getImage("image/Hero3_Attack.gif");
		Hero4_Attack1 = getImage("image/Hero4_Attack1.gif");
		Hero4_Attack2 = getImage("image/Hero4_Attack2.gif");
		
		//BossAttack
		BossAttack = getImage("image/BossAttack.png");
		ParriedBall1 = getImage("image/ParriedBall1.png");
		ParriedBall2 = getImage("image/ParriedBall2.png");
		
		
		
		//Monster  Dead for dead object
		Dead = getImage("image/Dead.png"); 
		Monster1 = getImage("image/Monster1.gif");
		Monster2 = getImage("image/Monster2.gif");
		Monster3 = getImage("image/Monster3.gif");
		Monster4 = getImage("image/Monster4.gif");
		Monster5 = getImage("image/Monster5.gif");
		Monster6 = getImage("image/Monster6.gif");
		Monster6_Jump1 = getImage("image/Monster6_Jump1.png");
		Boss = getImage("image/Boss.gif");
		HardBoss = getImage("image/HardBoss.gif");
		
		//coin 
		Coin1 = getImage("image/Coin1.gif"); 
		Coin2 = getImage("image/Coin2.gif"); 
		Coin3 = getImage("image/Coin3.gif"); 
		Coin4 = getImage("image/Coin4.gif");
		
		//stage0
		Stage0 = getImage("image/Stage0.png");
		Ground0 = getImage("image/Ground0.png");
		ObstacleTall_0 = getImage("image/ObstacleTall_00.png");
		Obstacle_0 = getImage("image/Ostacl_00.png");
		Hero0 = getImage("image/Hero0.png");
		
		//stage1
		Stage10 = getImage("image/Stage10.png");
		Stage11 = getImage("image/Stage11.png");
		Stage12 = getImage("image/Stage12.png");
		Stage13 = getImage("image/Stage13.png");
		Stage14 = getImage("image/Stage14.png");
		Stage15 = getImage("image/Stage15.png");
		Stage16 = getImage("image/Stage16.png");
		Stage17 = getImage("image/Stage17.png");
		Stage1_lava1 = getImage("image/Stage1_lava1.png");
		Stage1_lava2 = getImage("image/Stage1_lava2.png");
		Ground1 = getImage("image/Ground1.gif");
		ObstacleTall_1 = getImage("image/ObstacleTall_01.png");
		Obstacle_1 = getImage("image/Ostacl_01.png");
		Hero1 = getImage("image/Hero1.gif");

		
		//stage2
		Stage2 = getImage("image/Stage2.png");
		Ground2 = getImage("image/Ground0.png");  //use the same as start
		ObstacleTall_2 = getImage("image/ObstacleTall_00.png");
		Obstacle_2 = getImage("image/Ostacl_00.png");
		Hero2 = getImage("image/Hero2.gif");
		
		
		//stage3
		Stage30 = getImage("image/Stage3.png");
		Stage31 = getImage("image/Stage31.png");
		Stage32 = getImage("image/Stage32.png");
		Stage33 = getImage("image/Stage33.png");
		Stage34 = getImage("image/Stage34.png");
		Ground3 = getImage("image/Ground3.png");
		ObstacleTall_3 = getImage("image/ObstacleTall_03.gif");
		Obstacle_3 = getImage("image/Ostacl_03.png");
		Hero3 = getImage("image/Hero3.gif");

		
		//stage4
		Stage40 = getImage("image/Stage40.png");
		Stage41 = getImage("image/Stage41.png");
		Stage42 = getImage("image/Stage42.png");
		Stage43 = getImage("image/Stage43.png");
		Stage44 = getImage("image/Stage44.png");
		Stage4_prisoner1 = getImage("image/Stage4_prisoner1.gif");
		Stage4_prisoner2 = getImage("image/Stage4_prisoner2.gif");
		Ground4 = getImage("image/Ground4.png");
		ObstacleTall_4 = getImage("image/ObstacleTall_04.png");
		Obstacle_4 = getImage("image/Ostacl_04.png");
		Hero4 = getImage("image/Hero4.gif");
		
	}
}
