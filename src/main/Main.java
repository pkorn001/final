package main;

import javax.print.attribute.SetOfIntegerSyntax;

import hero.base.Hero;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.GameLogic;
import render.RenderableHolder;
import scene.GameScreen;
import scene.StartScreen;

public class Main extends Application {

	private StartScreen startScreen;
	private GameScreen gameScreen;
	private StackPane root;
	public static StackPane ui = StartScreen.createUI();
	private Canvas canvas = StartScreen.createCanvas();
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		root = new StackPane();
		gameScreen = new GameScreen(root);
		root.getChildren().addAll(canvas, ui);
		primaryStage.setScene(gameScreen);
		primaryStage.setTitle("LITTLE HERO");
		primaryStage.show();
		new AnimationTimer() {
			@Override
			public void handle(long now) {
				// TODO Add another canvas update
				gameLoop(primaryStage);
			}
		}.start();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	public void gameLoop(Stage primaryStage) {
		if(!GameLogic.isGameOver()) {
			gameScreen.paintComponent();
			GameLogic.logicUpdate();
			RenderableHolder.getInstance().update();
		}else {
			GameLogic.End();
		}
		
	}
}