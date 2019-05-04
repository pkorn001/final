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
	public static Image Stage0,Ground0,ObstacleTall_01,ObstacleTall_02,ObstacleTall_03
				,Obstacle_01,Obstacle_02,Obstacle_03,Hero0;
	
	// stage 1 red
	public static Image Stage1,Ground1,ObstacleTall_11,ObstacleTall_12,ObstacleTall_13
				,Obstacle_11,Obstacle_12,Obstacle_13,Hero1;
	
	// stage 2 green
	public static Image Stage2,Ground2,ObstacleTall_21,ObstacleTall_22,ObstacleTall_23
				,Obstacle_21,Obstacle_22,Obstacle_23,Hero2;
	
	// stage 3 black
	public static Image Stage3,Ground3,ObstacleTall_31,ObstacleTall_32,ObstacleTall_33
				,Obstacle_31,Obstacle_32,Obstacle_33,Hero3;
	
	// stage 4 purple
	public static Image Stage4,Ground4,ObstacleTall_41,ObstacleTall_42,ObstacleTall_43
				,Obstacle_41,Obstacle_42,Obstacle_43,Hero4;
	
	//monster
	public static Image Dead,Monster1,Monster2,Monster3,Monster4,Monster5,Monster6,Monster6_Jump2,Monster6_Jump1,Boss,HardBoss;
	
	//coin
	public static Image Coin1,Coin2,Coin3,Coin4;
	
	//HeroAttack
	public static Image FireBall;
	
	//BossAttack
	public static Image BossAttack,ParriedBall1,ParriedBall2;
	
	static {
		
		//HeroAttack
		FireBall = getImage("image/FireBall.png");
		
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
		ObstacleTall_01 = getImage("image/ObstacleTall_01.png");
		ObstacleTall_02 = getImage("image/ObstacleTall_02.png");
		ObstacleTall_03 = getImage("image/ObstacleTall_03.png");
		Obstacle_01 = getImage("image/Ostacl_01 .png");
		Obstacle_02 = getImage("image/Obstacl_02.png");
		Obstacle_03 = getImage("image/Obstacl_03.png");
		Hero0 = getImage("image/Hero0.png");
		
		//stage1
		Stage1 = getImage("image/Stage1.png");
		Ground1 = getImage("image/Ground1.png");
		ObstacleTall_11 = getImage("image/ObstacleTall_11.png");
		ObstacleTall_12 = getImage("image/ObstacleTall_12.png");
		ObstacleTall_13 = getImage("image/ObstacleTall_13.png");
		Obstacle_11 = getImage("image/Ostacl_11 .png");
		Obstacle_12 = getImage("image/Obstacl_12.png");
		Obstacle_13 = getImage("image/Obstacl_13.png");
		Hero1 = getImage("image/Hero1.png");

		
		//stage2
		Stage2 = getImage("image/Stage2.png");
		Ground2 = getImage("image/Ground0.png");  //use the same as start
		ObstacleTall_21 = getImage("image/ObstacleTall_21.png");
		ObstacleTall_22 = getImage("image/ObstacleTall_22.png");
		ObstacleTall_23 = getImage("image/ObstacleTall_23.png");
		Obstacle_21 = getImage("image/Ostacl_21 .png");
		Obstacle_22 = getImage("image/Obstacl_22.png");
		Obstacle_23 = getImage("image/Obstacl_23.png");
		Hero2 = getImage("image/Hero2.png");
		
		
		//stage3
		Stage3 = getImage("image/Stage3.png");
		Ground3 = getImage("image/Ground3.png");
		ObstacleTall_31 = getImage("image/ObstacleTall_31.png");
		ObstacleTall_32 = getImage("image/ObstacleTall_32.png");
		ObstacleTall_33 = getImage("image/ObstacleTall_33.png");
		Obstacle_31 = getImage("image/Ostacl_31 .png");
		Obstacle_32 = getImage("image/Obstacl_32.png");
		Obstacle_33 = getImage("image/Obstacl_33.png");
		Hero3 = getImage("image/Hero3.png");

		
		//stage4
		Stage4 = getImage("image/Stage4.png");
		Ground4 = getImage("image/Ground4.png");
		ObstacleTall_41 = getImage("image/ObstacleTall_41.png");
		ObstacleTall_42 = getImage("image/ObstacleTall_42.png");
		ObstacleTall_43 = getImage("image/ObstacleTall_43.png");
		Obstacle_41 = getImage("image/Ostacl_41 .png");
		Obstacle_42 = getImage("image/Obstacl_42.png");
		Obstacle_43 = getImage("image/Obstacl_43.png");
		Hero4 = getImage("image/Hero4.png");

		
	}
	
}
