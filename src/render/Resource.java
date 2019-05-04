package render;

import javafx.scene.image.Image;

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
	public static Image Stage0,Ground0,ObstacleTall_0,Obstacle_0,Hero0;
	
	// stage 1 red
	public static Image Stage1,Ground1,ObstacleTall_1,Obstacle_1,Hero1;
	
	// stage 2 green
	public static Image Stage2,Ground2,ObstacleTall_2,Obstacle_2,Hero2;
	
	// stage 3 black
	public static Image Stage3,Ground3,ObstacleTall_3,Obstacle_3,Hero3;
	
	// stage 4 purple
	public static Image Stage4,Ground4,ObstacleTall_4,Obstacle_4,Hero4;
	
	//monster
	public static Image Dead,Monster1,Monster2,Monster3,Monster4,Monster5,Monster6,Monster6_Jump2,Monster6_Jump1,Boss,HardBoss;
	
	//coin
	public static Image Coin1,Coin2,Coin3,Coin4;
	
	//HeroAttack
	public static Image FireBall, Boomerang;
	
	//BossAttack
	public static Image BossAttack,ParriedBall1,ParriedBall2;
	
	static {
		
		//HeroAttack
		FireBall = getImage("image/FireBall.png");
		Boomerang  = getImage("image/Boomerange.png");
		
		//BossAttack
		BossAttack = getImage("image/BossAttack.png");
		ParriedBall1 = getImage("image/ParriedBall1.png");
		ParriedBall2 = getImage("image/ParriedBall2.png");
		
		
		
		//Monster  Dead for dead object
		Dead = getImage("image/Dead.png"); 
		Monster1 = getImage("image/Monster1.png");
		Monster2 = getImage("image/Monster2.png");
		Monster3 = getImage("image/Monster3.png");
		Monster4 = getImage("image/Monster4.png");
		Monster5 = getImage("image/Monster5.png");
		Monster6 = getImage("image/Monster6.png");
		Monster6_Jump1 = getImage("image/Monster6_Jump1.png");
		Monster6_Jump2 = getImage("image/Monster6_Jump2.png");
		Boss = getImage("image/Boss.png");
		HardBoss = getImage("image/HardBoss.png");
		
		//coin 
		Coin1 = getImage("image/Coin1.png"); 
		Coin2 = getImage("image/Coin2.png"); 
		Coin3 = getImage("image/Coin3.png"); 
		Coin4 = getImage("image/Coin4.png");
		
		//stage0
		Stage0 = getImage("image/Stage0.png");
		Ground0 = getImage("image/Ground0.png");
		ObstacleTall_0 = getImage("image/ObstacleTall_0.png");
		Obstacle_0 = getImage("image/Ostacl_0.png");
		Hero0 = getImage("image/Hero0.png");
		
		//stage1
		Stage1 = getImage("image/Stage1.png");
		Ground1 = getImage("image/Ground1.png");
		ObstacleTall_1 = getImage("image/ObstacleTall_1.png");
		Obstacle_1 = getImage("image/Ostacl_1.png");
		Hero1 = getImage("image/Hero1.png");

		
		//stage2
		Stage2 = getImage("image/Stage2.png");
		Ground2 = getImage("image/Ground0.png");  //use the same as start
		ObstacleTall_2 = getImage("image/ObstacleTall_2.png");
		Obstacle_2 = getImage("image/Ostacl_2 .png");
		Hero2 = getImage("image/Hero2.png");
		
		
		//stage3
		Stage3 = getImage("image/Stage3.png");
		Ground3 = getImage("image/Ground3.png");
		ObstacleTall_3 = getImage("image/ObstacleTall_3.png");
		Obstacle_3 = getImage("image/Ostacl_3 .png");
		Hero3 = getImage("image/Hero3.png");

		
		//stage4
		Stage4 = getImage("image/Stage4.png");
		Ground4 = getImage("image/Ground4.png");
		ObstacleTall_4 = getImage("image/ObstacleTall_41.png");
		Obstacle_4 = getImage("image/Ostacl_4 .png");
		Hero4 = getImage("image/Hero4.png");

		
	}
	
}
