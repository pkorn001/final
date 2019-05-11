package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Score {

	public Score(int score) { //get input from Hero.getScore()
		
		StackPane root = new StackPane();
		
		Label sc = new Label("Score : " + score);
		sc.setAlignment(Pos.TOP_LEFT);
		sc.setPadding(new Insets(.10));
		
		root.getChildren().add(sc);
	}
}
