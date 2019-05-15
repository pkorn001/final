package scene;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Score extends VBox{

	public Score(int score) { //get input from Hero.getScore()
		
		Label sc = new Label("Score : " + score);
		sc.setAlignment(Pos.TOP_LEFT);
		sc.setPadding(new Insets(.10));
		
		getChildren().add(sc);
	}
}
