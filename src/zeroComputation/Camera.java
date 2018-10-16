package zeroComputation;

import java.util.ArrayList;

import display.Renderer;
import objects.Obj;

public class Camera {
	private static Point c = new Point(0, 0, -200, 1);
	private static Point θ = new Point(0, 0, 0);
	public static Point v = new Point(0, 0, 0, 0);
	public static Point vθ = new Point(0, 0, 0);

	//
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

	public static ArrayList<Point> PerspectiveProjection(Obj Obj1) {
		ArrayList<Point> d = new ArrayList<Point>();
		Obj1.getEdges().forEach(p -> d.add(PerspectiveProjection(p)));
		return d;
	}

	//Single Point Projections
	public static Point simpleOrthographicProjection(Point P) {
		//System.out.println("simpleOrtho");
		Matrix O = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, 1, 0 }
		});
		return new Point(Matrix.prod(O, P));
	}

	private static Point OrthographicProjection(Point P) { //doesnt produces true 2d Points
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

	private static Point CabinetProjection(double CabinetAngle, Point P) {
		//System.out.println("Cabinet");
		Matrix O = Matrix.fromArray(new double[][] {
				{ 1, 0, 0.5 * Math.cos(CabinetAngle), 0 },
				{ 0, 1, 0.5 * Math.sin(CabinetAngle), 0 },
		});
		return new Point(Matrix.prod(O, P));
	}

	private static Point PerspectiveProjection(Point a) {

		Point e = new Point(0, 0, 200);

		Matrix O = Matrix.fromArray(new double[][] {
				{ 1, 0, -e.getX() / e.getZ(), 0 },
				{ 0, 1, -e.getY() / e.getZ(), 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, -1 / e.getZ(), 1 }
		});

		Point d = Point.RotateXYZh(new Point(Point.sub(a, c)), θ);
		

		Point f = new Point(Matrix.prod(O, d));

		return new Point(f.getX() / f.getW(), f.getY() / f.getW());
	}

	public static void movement() {
		//		if (v.length() != 0) {
		//			c.add(Point.scalarmult(1, v));
		//			//Point.printM(v);
		//			v.sub(v.signum());
		//		}
		if (v.length() != 0) {
			c.add(Point.scalarmult(0.4, v));
		}
		if (vθ.length() != 0) {
			θ.add(Point.scalarmult(0.001, vθ));
		}
	}

	public static void reset() {
		c = new Point(0, 0, -200, 1);
		θ = new Point(0, 0, 0);

	}

}
