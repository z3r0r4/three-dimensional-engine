package zeroComputation;

import java.util.ArrayList;
import objects.Obj;

public class Camera {
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
		Point c = new Point(0, 0, -200, 1);
		Point θ = new Point(0, 0, 0);
		Point e = new Point(0, 0, 200);
		Point b = new Point(0, 0);

		Matrix O = Matrix.fromArray(new double[][] {
				{ 1, 0, -e.getX() / e.getZ(), 0 },
				{ 0, 1, -e.getY() / e.getZ(), 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, -1 / e.getZ(), 1 }
		});

//		System.out.println("Cacmwe");
//		Point.printM(a);
//		Point.printM(c);

		Point d = new Point(Matrix.add(a, c.negate()));

//		System.out.println("equals");
//		Point.printM(d);
//		Point.printM(O);

		Point f = new Point(Matrix.prod(O, d));

//		System.out.println("equalsFINN");
//		Point.printM(f);
//
//		System.out.println("FIasdANLLsdfasdY");
//
//		Point.printM(b);
		return new Point(f.getX() / f.getW(), f.getY() / f.getW());
	}

}
