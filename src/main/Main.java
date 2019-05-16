package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import render.RenderableHolder;
import scene.GameScreen;
import scene.StartScreen;

public class Main extends Application {
	
	private boolean isFirstFrame = true;
	private long startlong;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		StackPane root2 = new StackPane();
		StartScreen startScreen = new StartScreen(root);
		GameScreen gameScreen = new GameScreen(root2);
		primaryStage.setScene(startScreen);
		primaryStage.setTitle("LITTLE HERO");
		primaryStage.show();
		
		 new AnimationTimer() {
			 @Override
			 public void handle(long now) {
			    // TODO Add another canvas update
				GameLogic.logicUpdate();
				RenderableHolder.getInstance().update();
				if(StartScreen.isStart) {
					primaryStage.setScene(gameScreen);
					gameScreen.paintComponent();
				}else {
					startScreen.paintComponent();
				}
			}
		}.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}