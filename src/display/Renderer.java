package display;

import javafx.scene.input.KeyCode;
import zeroComputation.Point;
import zeroComputation.ThreeDObject;
import zeroComputation.TwoDObject;

public class Renderer {
	static double k = 0;

	public static void draw(ObjectHolder2D obj2d) {

		obj2d.clear();
		ThreeDObject Cube = new ThreeDObject(-50d, -50d, -50d, 100d, 100d, 100d);
		TwoDObject Cube2 = new TwoDObject(Cube);
		Cube2.getVertices().forEach(v -> drawLine(Cube2.getEdges().get(v[0]), Cube2.getEdges().get(v[1]), obj2d));
	}

//	public static void drawLine(ObjectHolder2D obj2d) {
//		k += 0.1;
//		//obj2d.clear();
//
//		Point A = new Point(0, 0, 0, 1);
//		Point B = new Point(125, 125, 250, 1);
//		//B = Point.RotateXYZ(B, k, k, k);
//
//		Point A2 = A.OrthographicProjection();
//		Point B2 = B.OrthographicProjection();
//
//		obj2d.ctx.strokeLine(A2.getData(0, 0), A2.getData(1, 0), B2.getData(0, 0), B2.getData(1, 0));
//	}

	public static void drawLine(Point A, Point B, ObjectHolder2D obj2d) {
		//k += 0.002;
		//obj2d.clear();
		A.RotateXYZ(k,k,k);
		B.RotateXYZ(k,k,k);
		obj2d.ctx.strokeLine(A.getData(0, 0), A.getData(1, 0), B.getData(0, 0), B.getData(1, 0));
	}

	public static void handleKeyPress(KeyCode code) {
		switch (code) {
		case ESCAPE:
			System.exit(0);
			break;
		default:
			break;
		}

	}
}