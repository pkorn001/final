package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import scene.GameScreen;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		Scene scene = new Scene(root, 1600, 900);
		GameScreen screen = new GameScreen();
		new AnimationTimer() {
			
			@Override
			public void handle(long now) {
				// TODO Auto-generated method stub
				long time = now - System.nanoTime();
				screen.update(time);
			}
		}.start();
		root.getChildren().add(screen);
		primaryStage.setScene(scene);
		primaryStage.setTitle("The adventure of a little hero"); 
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
