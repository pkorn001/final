package scene;

import java.util.Stack;

import javax.swing.JLabel;

import hero.base.Hero;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class Score {

	public Score(int score) {
		
		StackPane root = new StackPane();
		
		Label sc = new Label("Score : " + score);
		sc.setAlignment(Pos.TOP_LEFT);
		sc.setPadding(new Insets(.10));
		
		root.getChildren().add(sc);
	}
}
