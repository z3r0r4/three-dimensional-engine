package display;

import java.util.ArrayList;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import objects.*;
import zeroComputation.Point;
import zeroComputation.Projection;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Renders all the Stuff and handles User input
 */
public class Renderer {
	private static GraphicsContext ctx;
	private static Cube Cube = new Cube(-50d, -50d, -50d, 100d, 100d, 100d);
	private static Sphere Sphere = new Sphere();

	public Renderer(ObjBuffer2D Obj1) {
		ctx = Obj1.ctx;
	}

	public static void draw(ObjBuffer2D obj2d) {
	 ctx = JavaFX.Buffer2D.ctx;
		obj2d.clear();
		Sphere.RotateXYZh(Math.toRadians(0.5), Math.toRadians(0.5), Math.toRadians(0));
		drawObj(Sphere);
	}

	public static void drawObj(Obj Obj1) {
		ArrayList<Point> twoDEdges = Projection.OrthographicProjection(Obj1);
		drawVertices(Obj1, twoDEdges);
		drawFaces(Obj1, twoDEdges);
	}

	public static void drawVertices(Obj Obj1, ArrayList<Point> TwoDe) {
		Obj1.getVertices().forEach(v -> drawLine(TwoDe.get(v[0]), TwoDe.get(v[1])));
	}

	public static void drawLine(Point A, Point B) {
		ctx.strokeLine(A.getData(0, 0), A.getData(1, 0), B.getData(0, 0), B.getData(1, 0));
	}

	public static void drawFaces(Obj Obj1, ArrayList<Point> TwoDe) {
		Obj1.getFaces().forEach(f -> {
			Point[] faceP = new Point[f.length];
			for (int i = 0; i < f.length; i++)
				faceP[i] = Obj1.edges.get(f[i]);
			drawFace(faceP);
		});
	}

	public static void drawFace(Point... points) {
		double[] x = Point.xPoints(points);
		double[] y = Point.yPoints(points);

		ctx.setFill(Color.BLACK);
		ctx.setFill(Color.web("rgba(255,0,0,0.4)"));
		ctx.fillPolygon(x, y, x.length);
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