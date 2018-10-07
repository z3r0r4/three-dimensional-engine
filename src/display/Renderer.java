package display;

import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import zeroComputation.Point;
import zeroComputation.ThreeDObject;
import zeroComputation.TwoDObject;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Renders all the Stuff and handles User input
 */
public class Renderer {
	static double k = 0.02;
	static ThreeDObject Cube3 = new ThreeDObject(-50d, -50d, -50d, 100d, 100d, 100d);
	static ThreeDObject Sphere = new ThreeDObject();

	public static void draw(ObjectHolder2D obj2d) {
		
		obj2d.clear();

		Sphere.RotateXYZh(Math.toRadians(1), Math.toRadians(0), Math.toRadians(0));

		TwoDObject Sphere2 = new TwoDObject(Sphere);

		
		Sphere2.getVertices().forEach(v -> drawLine(Sphere2.getEdges().get(v[0]), Sphere2.getEdges().get(v[1]), obj2d));

		//		obj2d.clear();
		//		
//				Cube3.RotateXYZh(Math.toRadians(1),Math.toRadians(2),Math.toRadians(3));
//		
//				TwoDObject Cube2 = new TwoDObject(Cube3);
//		
//				Cube2.getVertices().forEach(v -> drawLine(Cube2.getEdges().get(v[0]), Cube2.getEdges().get(v[1]), obj2d));
//		
//				Cube2.getFaces().forEach(f -> {
//					Point[] faceP = new Point[f.length];
//					for (int i = 0; i < f.length; i++)
//						faceP[i] = Cube2.edges.get(f[i]);
//					drawFace(obj2d, faceP);
//				});
	}

	public static void drawLine(Point A, Point B, ObjectHolder2D obj2d) {
		obj2d.ctx.strokeLine(A.getData(0, 0), A.getData(1, 0), B.getData(0, 0), B.getData(1, 0));
	}

	public static void drawFace(ObjectHolder2D obj2D, Point... points) {
		double[] x = Point.xPoints(points);
		double[] y = Point.yPoints(points);
		obj2D.ctx.setFill(Color.BLACK);
		obj2D.ctx.setFill(Color.web("rgba(255,0,0,0.4)"));
		obj2D.ctx.fillPolygon(x, y, x.length);
	}

	public static void handleKeyPress(KeyCode code) {
		switch (code) {
		case ESCAPE:
			System.out.println("RIP me :(");
			System.exit(0);
			break;
		default:
			break;
		}
	}
}