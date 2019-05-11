package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import render.RenderableHolder;
import scene.GameScreen;
import scene.StartScreen;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		StartScreen start = new StartScreen();
		StackPane root = new StackPane();
		 Scene scene = new Scene(root);
		 primaryStage.setScene(scene);
		 primaryStage.setTitle("LITTLE HERO");
		 GameScreen gameScreen = new GameScreen();
		 root.getChildren().add(gameScreen);
		 primaryStage.show();
		 
		 
		 new AnimationTimer() {
			 @Override
			 public void handle(long now) {
			    // TODO Add another canvas update
				 long time = (now - System.nanoTime())/1000000000;
				RenderableHolder.getInstance().update();
				GameLogic.logicUpdate(time);
				gameScreen.paintComponent();
			}
		}.start();
	}

	public static void main(String[] args) {
		launch(args);
	}

}