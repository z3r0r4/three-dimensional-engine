package zeroComputation;

import java.util.ArrayList;
import objects.Obj;

public class Projection {
	public static ArrayList<Point> simpleOrthographicProjection(Obj Obj1) {
		ArrayList<Point> d = new ArrayList<Point>();
		Obj1.getEdges().forEach(p -> d.add(simpleOrthographicProjection(p)));
		return d;
	}

	public static ArrayList<Point> OrthographicProjection(Obj Obj1) {
		ArrayList<Point> d = new ArrayList<Point>();
		Obj1.getEdges().forEach(p -> d.add(OrthographicProjection(p)));
		return d;
	}

	public static ArrayList<Point> CabinetProjection(Obj Obj1) {
		ArrayList<Point> d = new ArrayList<Point>();
		Obj1.getEdges().forEach(p -> d.add(CabinetProjection(Math.toRadians(63.4f), p)));
		return d;
	}

	public static Point simpleOrthographicProjection(Point P) {
		//System.out.println("simpleOrtho");
		Matrix O = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, 1, 0 }
		});
		return new Point(Matrix.prod(O, P));
	}

	public static Point OrthographicProjection(Point P) {
		//System.out.println("Ortho");
		double r = 1f, l = -1f, t = 1f, b = -1f, n = -1f, f = 1f;

		Matrix O = Matrix.fromArray(new double[][] {
				{ 2 / (r - l), 0, 0, -(r + l) / (r - l) },
				{ 0, 2 / (t - b), 0, -(t + b) / (t - b) },
				{ 0, 0, 2 / (f - n), -(f + n) / (f - n) },
				{ 0, 0, 0, 1 }
		});
		return new Point(Matrix.prod(O, P));
	}

	public static Point CabinetProjection(double CabinetAngle, Point P2) {
		//System.out.println("Cabinet");
		Matrix P = Matrix.fromArray(new double[][] {
				{ 1, 0, 0.5 * Math.cos(CabinetAngle), 0 },
				{ 0, 1, 0.5 * Math.sin(CabinetAngle), 0 },
		});
		return new Point(Matrix.prod(P, P2));
	}
}
