package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import render.RenderableHolder;
import scene.GameScreen;

public class Main extends Application {
	
	private boolean isFirstFrame = true;
	private long startlong;

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
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
				GameLogic.logicUpdate();
				RenderableHolder.getInstance().update();
				gameScreen.paintComponent();
			}
		}.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}