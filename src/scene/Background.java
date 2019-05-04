package scene;

import java.util.Arrays;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import render.Resource;

public class Background {
	// TOP
	public static List<Image> stages1;
	public static List<Image> stages3;
	public static List<Image> stages4;

	static {
		loadResource();
	}

	public static void loadResource() {
		stages1.addAll(Arrays.asList(new Image[] {Resource.Stage10,Resource.Stage11,Resource.Stage12,Resource.Stage13,Resource.Stage14,Resource.Stage15,Resource.Stage16,Resource.Stage17,Resource.Stage1_lava1,Resource.Stage1_lava2} ));
		stages3.addAll(Arrays.asList(new Image[] {Resource.Stage30,Resource.Stage31,Resource.Stage32,Resource.Stage33,Resource.Stage34} ));
		stages4.addAll(Arrays.asList(new Image[] {Resource.Stage40,Resource.Stage41,Resource.Stage42,Resource.Stage43,Resource.Stage44,Resource.Stage4_prisoner1,Resource.Stage4_prisoner2}));
	}
}
