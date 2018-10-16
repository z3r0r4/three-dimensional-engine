package userHandler;

import javafx.scene.input.KeyCode;
import zeroComputation.Camera;

public class Controller {
	static int i = 0;

	public static void handleKeyPress(KeyCode code) {
		switch (code) {
		case ESCAPE:
			System.out.println("RIP me :(");
			System.exit(0);
			break;
		case W:
			Camera.v.setZ(50);
			break;
		case S:
			Camera.v.setZ(-50);
			break;
		case A:
			Camera.v.setX(50);
			break;
		case D:
			Camera.v.setX(-50);
			break;
		case SPACE:
			Camera.v.setY(50);
			break;
		case SHIFT:
			Camera.v.setY(-50);
			break;
		case UP:
			Camera.vθ.setX(50);
			break;
		case DOWN:
			Camera.vθ.setX(-50);
			break;
		case RIGHT:
			Camera.vθ.setY(50);
			break;
		case LEFT:
			Camera.vθ.setY(-50);
			break;
		case Q:
			Camera.vθ.setZ(50);
			break;
		case E:
			Camera.vθ.setZ(-50);
			break;
		}
	}

	public static void handleKeyRelease(KeyCode code) {
		switch (code) {
		case ENTER:
			Camera.reset();
			break;
		case ESCAPE:
			System.out.println("RIP me :(");
			System.exit(0);
			break;
		case W:
			Camera.v.setZ(0);
			break;
		case S:
			Camera.v.setZ(0);
			break;
		case A:
			Camera.v.setX(0);
			break;
		case D:
			Camera.v.setX(0);
			break;
		case SPACE:
			Camera.v.setY(0);
			break;
		case SHIFT:
			Camera.v.setY(0);
			break;
		case UP:
			Camera.vθ.setX(0);
			break;
		case DOWN:
			Camera.vθ.setX(0);
			break;
		case LEFT:
			Camera.vθ.setY(0);
			break;
		case RIGHT:
			Camera.vθ.setY(0);
			break;
		case Q:
			Camera.vθ.setZ(0);
			break;
		case E:
			Camera.vθ.setZ(0);
			break;
		}

	}
}
