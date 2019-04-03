/*
 * 1st excersise from nature of the code book to be build upon
 */
package application;
	
import java.util.Random;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Point2D;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;


public class Main extends Application {
	Unit object = new Unit(200, 200);
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
			BorderPane root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			// canvas + basic setup up
			Canvas canvas = new Canvas(400, 400);
			GraphicsContext gc = canvas.getGraphicsContext2D();
			gc.setFill(Color.BLACK);
			gc.fillRect(0, 0, 400, 400);
			root.getChildren().add(canvas);
			
			// animation that call to create content method
			AnimationTimer timer = new AnimationTimer() {
				@Override
				public void handle(long now) {
					createContent(gc);
				}
			};
			timer.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	//creating content and logic for moving
	public void createContent(GraphicsContext gc) {
		gc.setFill(Color.AQUA);
		gc.fillRect(object.getxPos(), object.getyPos(), 3, 3);
		if(Math.random() < 0.2 ) {
			object.setxPos(object.getxPos());
			object.setyPos(object.getyPos()+1);
		} else if (Math.random() < 0.3) {
			object.setxPos(object.getxPos());
			object.setyPos(object.getyPos()-1);
		} else if (Math.random() < 0.5) {
			object.setxPos(object.getxPos()+1);
			object.setyPos(object.getyPos());
		} else if (Math.random() < 0.7) {
			object.setxPos(object.getxPos()-1);
			object.setyPos(object.getyPos());
		}
	}
}
