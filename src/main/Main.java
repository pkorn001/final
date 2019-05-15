package main;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import scene.GameScreen;
import scene.StartScreen;

public class Main extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		StackPane root = new StackPane();
		StartScreen startScreen = new StartScreen(root);
		primaryStage.setScene(startScreen);
		primaryStage.setTitle("LITTLE HERO");
		primaryStage.show();
		
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				// TODO Add another canvas update
//				RenderableHolder.getInstance().update();
//				GameLogic.update();
				startScreen.paintComponent();
			}
		}.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
}