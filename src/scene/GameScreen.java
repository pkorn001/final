package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class GameScreen extends Canvas {

	private Background topBackground;
	private Background bottomBackground;
	
	public GameScreen(double width, double height){
		super(width, height);
		this.setVisible(true);
		
		Pane root = new Pane();
		VBox topBox = new VBox(width);  //top part, start from hero's line till the max height
		topBox.setBackground(null);
		
		VBox bottomBox = new VBox(width);
		
		HBox score = new HBox();  //score of the game
		score.setAlignment(Pos.TOP_LEFT);
		score.setPadding(new Insets(.5));
		
		HBox logo = new HBox();   //game's design
		logo.setAlignment(Pos.TOP_RIGHT);
		logo.setPadding(new Insets(.5));
		
		topBox.getChildren().addAll(score, logo);
		
		root.getChildren().addAll(topBox, bottomBox);
	}
}
