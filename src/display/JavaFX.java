package display;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Class that starts all needed things for JavaFx and Animation
 *              many things are outsourced to other classes
 */
public class JavaFX extends Application {

	final static double W = 500.0, H = 500.0;
	static ObjBuffer2D Buffer2D = null;
	private static AnimationTimer timer;

	public static void init(ObjBuffer2D buffer) {
		JavaFX.Buffer2D = buffer;
	}

	public static void start(String[] args, int width, int height) {
		new ObjBuffer2D(width, height);
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		Group root = new Group(); //layout
		Scene scene = new Scene(root, W, H);
		primaryStage.setScene(scene);
		primaryStage.setTitle("3D");
		//necessary part

		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				Renderer.draw(Buffer2D); //updates the canvas with ctx
			}
		};
		timer.start();

		scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			public void handle(KeyEvent event) {
				Renderer.handleKeyPress(event.getCode());
			}
		});

		root.getChildren().add(Buffer2D.getCanvas()); //adding the canvas, filled with stuff, to the scene
		primaryStage.show(); //show window
	}
}