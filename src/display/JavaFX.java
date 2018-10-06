package display;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class JavaFX extends Application {
	final static double W = 500.0, H = 500.0;
	int i = 0;
	private static ObjectHolder2D Obj2D = null; //Why cant i intialize it like this?

	private static AnimationTimer timer;

	public static void initialize(ObjectHolder2D ObjectH2D) {
		JavaFX.Obj2D = ObjectH2D;
	}

	public static void start(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		if (i < 1) {
			i++;
			Obj2D = new ObjectHolder2D(500, 500);
		} //this is garbage

		//necessary part
		Group root = new Group(); //layout
		Scene scene = new Scene(root, W, H);
		primaryStage.setScene(scene);
		primaryStage.setTitle("LOL");
		//necessary part

		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				Renderer.drawLine(Obj2D);		//updates the canvas with ctx
			}
		};
		timer.start();

//		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
//			public void handle(KeyEvent event) {
//				Renderer.handleKeyPress(event.getCode());
//			}
//		});
		

		root.getChildren().add(Obj2D.getCanvas()); //adding the canvas, filled with stuff, to the scene

		primaryStage.show(); //show window
	}
}
