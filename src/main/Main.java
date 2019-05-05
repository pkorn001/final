package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application{

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		Button btn = new Button("Hello world");
		StackPane root = new StackPane(); root.getChildren().add(btn);
		Scene scene = new Scene(root, 300, 250);
		primaryStage.setScene(scene);
		primaryStage.setTitle("MyJavaFX"); // Set the stage title primaryStage.setScene(scene); // Place the scene primaryStage.show();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
