package render;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.media.AudioClip;

public class Resource {
	
	private static AudioClip getAudio(String directory) {
		AudioClip au;
		try {
			String audio_path = ClassLoader.getSystemResource(directory).toString();
			au = new AudioClip(audio_path);
		} catch (Exception e) {
			au = null;
		}
		return au;
	}

	private static Image getImage(String directory) {
		Image im;
		String error = directory;
		try {
			String image_path = ClassLoader.getSystemResource(directory).toString();
			im = new Image(image_path);
		} catch (Exception e) {
			im = null;
			System.out.println(error);
		}
		return im;
	}

	// stage 0 normal
	public static Image Stage0, ObstacleTall_0, Obstacle_0, Hero0, Ground0;

	// stage 1 red
	public static Image Stage10, Stage11, Stage12, Stage13, Stage14, Stage15, Stage16, Stage17, Stage1_lava1,
			Stage1_lava2, ObstacleTall_1, Obstacle_1, Hero1, Hero1_Attack, Ground1;

	// stage 2 green
	public static Image Stage21, ObstacleTall_2, Obstacle_2, Hero2, Hero2_Attack, Ground2;

	// stage 3 black
	public static Image Stage30, Stage31, Stage32, Stage33, Stage34, ObstacleTall_3, Obstacle_3, Hero3, Hero3_Attack,
			Ground3;

	// stage 4 purple
	public static Image Stage40, Stage41, Stage42, Stage43, Stage44, Stage4_prisoner1, Stage4_prisoner2, ObstacleTall_4,
			Obstacle_4, Hero4, Hero4_Attack1, Hero4_Attack2, Ground4;

	// monster
	public static Image Dead, Monster1, Monster2, Monster3, Monster4, Monster5, Monster6, Monster6_Jump1, Boss,
			HardBoss;

	// coin
	public static Image Coin1, Coin2, Coin3, Coin4;

	// HeroAttack
	public static Image FireBall, Boomerang, Scythe;

	// BossAttack
	public static Image BossAttack, ParriedBall1, ParriedBall2;
	
	//GameLogo
	public static Image Logo;

	// Sound
	public static AudioClip DeadSound, Hero1_Attack_Sound, Hero2_Attack_Sound, Hero3_Attack_Sound, Hero4_Attack1_Sound,
			Hero4_Attack2_Sound, Jump_Sound, Stage0_Music, Stage1_Music, Stage2_Music, Stage3_Music, Stage4_Music;

	static {
		//Sound
		DeadSound = getAudio("sound/Dead.wav");
		
		Hero1_Attack_Sound = getAudio("sound/Hero1_Attack.wav");
		Hero2_Attack_Sound = getAudio("sound/Hero2_Attack.wav");
		Hero3_Attack_Sound = getAudio("sound/Hero3_Attack.wav");
		Hero4_Attack1_Sound = getAudio("sound/Hero4_Attack1.wav");
		Hero4_Attack2_Sound = getAudio("sound/Hero4_Attack2.wav");
		
		Jump_Sound = getAudio("sound/Jump.wav");
		
		Stage0_Music = getAudio("sound/Stage0.mp3");
		Stage1_Music = getAudio("sound/Volcano.mp3");
		Stage2_Music = getAudio("sound/Stage2.wav");
		Stage3_Music = getAudio("sound/Stage3.wav");
		Stage4_Music = getAudio("sound/Stage4.wav");
		
		//Logo
		Logo = getImage("image/Logo.png");

		// HeroAttack
		FireBall = getImage("image/FireBall.gif");
		Boomerang = getImage("image/Boomerang.gif");
		Scythe = getImage("image/Scythe.gif");
		Hero1_Attack = getImage("image/Hero1_Attack.png");
		Hero2_Attack = getImage("image/Hero2_Attack.gif");
		Hero3_Attack = getImage("image/Hero3_Attack.gif");
		Hero4_Attack1 = getImage("image/Hero4_Attack1.gif");
		Hero4_Attack2 = getImage("image/Hero4_Attack2.gif");

		// BossAttack
		BossAttack = getImage("image/BossAttack.png");
		ParriedBall1 = getImage("image/ParriedBall1.png");
		ParriedBall2 = getImage("image/ParriedBall2.png");

		// Monster Dead for dead object
		Dead = getImage("image/Dead.gif");
		Monster1 = getImage("image/Monster1.gif");
		Monster2 = getImage("image/Monster2.gif");
		Monster3 = getImage("image/Monster3.gif");
		Monster4 = getImage("image/Monster4.gif");
		Monster5 = getImage("image/Monster5.gif");
		Monster6 = getImage("image/Monster6.gif");
		Boss = getImage("image/Boss.gif");
		HardBoss = getImage("image/HardBoss.gif");

		// coin
		Coin1 = getImage("image/Coin1.gif");
		Coin2 = getImage("image/Coin2.gif");
		Coin3 = getImage("image/Coin3.gif");
		Coin4 = getImage("image/Coin4.gif");

		// stage0
		Stage0 = getImage("image/Stage0.png");
		Ground0 = getImage("image/Ground0.png");
		Hero0 = getImage("image/Hero0.gif");
		ObstacleTall_0 = getImage("image/ObstacleTall_0.png");
		Obstacle_0 = getImage("image/Ostacl_0.png");
		Hero0 = getImage("image/Hero0.gif");

		// stage1
		Stage10 = getImage("image/Stage10.png");
		Stage11 = getImage("image/Stage11.png");
		Stage12 = getImage("image/Stage12.png");
		Stage13 = getImage("image/Stage13.png");
		Stage14 = getImage("image/Stage14.png");
		Stage15 = getImage("image/Stage15.png");
		Stage16 = getImage("image/Stage16.png");
		Stage17 = getImage("image/Stage17.png");
		Stage1_lava1 = getImage("image/Stage1_lava1.gif");
		Stage1_lava2 = getImage("image/Stage1_lava2.gif");
		Ground1 = getImage("image/Ground1.gif");
		ObstacleTall_1 = getImage("image/ObstacleTall_1.png");
		Obstacle_1 = getImage("image/Ostacl_1.png");
		Hero1 = getImage("image/Hero1.gif");

		//stage2
		Stage21 = getImage("image/Stage2.png");
		Ground2 = getImage("image/Ground0.png");  //use the same as start
		ObstacleTall_2 = getImage("image/ObstacleTall_0.png");
		Obstacle_2 = getImage("image/Ostacl_0.png");
		Hero2 = getImage("image/Hero2.gif");

		// stage3
		Stage30 = getImage("image/Stage30.png");
		Stage31 = getImage("image/Stage31.png");
		Stage32 = getImage("image/Stage32.png");
		Stage33 = getImage("image/Stage33.png");
		Stage34 = getImage("image/Stage34.png");
		Ground3 = getImage("image/Ground3.png");
		ObstacleTall_3 = getImage("image/ObstacleTall_3.gif");
		Obstacle_3 = getImage("image/Ostacl_3.png");
		Hero3 = getImage("image/Hero3.gif");

		// stage4
		Stage40 = getImage("image/Stage40.png");
		Stage41 = getImage("image/Stage41.png");
		Stage43 = getImage("image/Stage43.png");
		Stage44 = getImage("image/Stage44.png");
		Stage4_prisoner1 = getImage("image/Stage4_prisoner1.gif");
		Stage4_prisoner2 = getImage("image/Stage4_prisoner2.gif");
		Ground4 = getImage("image/Ground4.png");
		ObstacleTall_4 = getImage("image/ObstacleTall_4.png");
		Obstacle_4 = getImage("image/Ostacl_4.png");
		Hero4 = getImage("image/Hero4.gif");

	}
}
