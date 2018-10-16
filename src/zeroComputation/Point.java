package zeroComputation;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Class which holds the Points and does the Projection and all
 *              other operations
 */
public class Point extends Matrix {

	Matrix O = Matrix.fromArray(new double[][] {
			{ 1, 0, 0 },
			{ 0, 1, 0 }
	});

	public Point(double... koefficent) {
		super(koefficent.length, 1);

		for (int i = 0; i < koefficent.length; i++)
			this.setData(koefficent[i], i, 0);
	}

	public Point(Point P, double... koefficent) {
		super(P.getColumns() + koefficent.length, 1);
		System.out.println(P.getColumns());
		System.out.println(koefficent.length);
		System.out.println(P.getColumns() + koefficent.length);
		for (int i = P.getColumns() - 1; i < P.getColumns() + koefficent.length - 1; i++) {
			System.out.println(i);
			this.setData(koefficent[i], i, 0);
		}
	}

	public Point(Matrix A) {
		super(A.getRows(), A.getColumns());

		if (A.getColumns() != 1)
			throw new IllegalArgumentException("Can't be a Point");

		for (int i = 0; i < A.getRows(); i++)
			this.setData(A.getData(i, 0), i, 0);

	}

	//USING POINTS AS MAKESHIFT VECTORS
	public static double distance(Point A, Point B) {
		if (A.getRows() != B.getRows())
			throw new IllegalArgumentException("Dimensions not equal");
		double d = 0;
		for (int i = 0; i < A.getRows(); i++)
			d += Math.pow(B.getData(i, 0) - A.getData(i, 0), 2);

		return Math.sqrt(d);
	}

	public static double length(Point A) {
		double d = 0;
		for (int i = 0; i < A.getRows(); i++)
			d += Math.pow(A.getData(i, 0), 2);

		return Math.sqrt(d);
	}

	public double length() {
		double d = 0;
		for (int i = 0; i < this.getRows(); i++)
			d += Math.pow(this.getData(i, 0), 2);

		return Math.sqrt(d);
	}

	public static double dotP(Point A, Point B) {
		if (A.getRows() != B.getRows())
			throw new IllegalArgumentException("Dimensions not equal");
		return Matrix.prod(A, Matrix.T(B)).getData(0, 0);
	}

	public static double angle(Point A, Point B, Point C) {
		Point AB = new Point(Matrix.add(A, Matrix.negate(B)));
		Point AC = new Point(Matrix.add(A, Matrix.negate(C)));
		return Math.acos(dotP(AB, AC) / (length(AB) * length(AC)));
	}

	public static Point RotateXYZ(Point P, double angleX, double angleY, double angleZ) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, Math.cos(angleX), -Math.sin(angleX) },
				{ 0, Math.sin(angleX), Math.cos(angleX) } });

		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(angleY), 0, Math.sin(angleY) },
				{ 0, 1, 0 },
				{ -Math.sin(angleY), 0, Math.cos(angleY) } });

		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(angleZ), -Math.sin(angleZ), 0 },
				{ Math.sin(angleZ), Math.cos(angleZ), 0 },
				{ 0, 0, 1 } });

		return new Point(Matrix.prod(Matrix.prod(Matrix.prod(R_x, R_y), R_z), P));
	}

	public void RotateXYZ(double angleX, double angleY, double angleZ) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, Math.cos(angleX), -Math.sin(angleX) },
				{ 0, Math.sin(angleX), Math.cos(angleX) } });

		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(angleY), 0, Math.sin(angleY) },
				{ 0, 1, 0 },
				{ -Math.sin(angleY), 0, Math.cos(angleY) } });

		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(angleZ), -Math.sin(angleZ), 0 },
				{ Math.sin(angleZ), Math.cos(angleZ), 0 },
				{ 0, 0, 1 } });

		this.setData((new Point(
				Matrix.prod(Matrix.prod(Matrix.prod(R_x, R_y), R_z), this)))
						.getData());
	}

	public void RotateXYZh(double angleX, double angleY, double angleZ) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0, 0 },
				{ 0, Math.cos(angleX), -Math.sin(angleX), 0 },
				{ 0, Math.sin(angleX), Math.cos(angleX), 0 },
				{ 0, 0, 0, 1 } });

		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(angleY), 0, Math.sin(angleY), 0 },
				{ 0, 1, 0, 0 },
				{ -Math.sin(angleY), 0, Math.cos(angleY), 0 },
				{ 0, 0, 0, 1 } });

		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(angleZ), -Math.sin(angleZ), 0, 0 },
				{ Math.sin(angleZ), Math.cos(angleZ), 0, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 1 } });

		this.setData((new Point(
				Matrix.prod(Matrix.prod(Matrix.prod(R_x, R_y), R_z), this)))
						.getData());
	}

	public static Point RotateXYZh(Point P, Point θ) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0, 0 },
				{ 0, Math.cos(θ.getX()), -Math.sin(θ.getX()), 0 },
				{ 0, Math.sin(θ.getX()), Math.cos(θ.getX()), 0 },
				{ 0, 0, 0, 1 } });

		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(θ.getY()), 0, Math.sin(θ.getY()), 0 },
				{ 0, 1, 0, 0 },
				{ -Math.sin(θ.getY()), 0, Math.cos(θ.getY()), 0 },
				{ 0, 0, 0, 1 } });

		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(θ.getZ()), -Math.sin(θ.getZ()), 0, 0 },
				{ Math.sin(θ.getZ()), Math.cos(θ.getZ()), 0, 0 },
				{ 0, 0, 1, 0 },
				{ 0, 0, 0, 1 } });

		P.setData((new Point(
				Matrix.prod(Matrix.prod(Matrix.prod(R_x, R_y), R_z), P)))
						.getData());
		return P;
	}

	public static double[] xPoints(Point... points) {
		double[] x = new double[points.length];

		for (int i = 0; i < points.length; i++)
			x[i] = points[i].getData(0, 0);

		return x;
	}

	public static double[] yPoints(Point... points) {
		double[] y = new double[points.length];

		for (int i = 0; i < points.length; i++)
			y[i] = points[i].getData(1, 0);

		return y;
	}

	public Matrix getMatrix() {
		return new Matrix(this);
	}

	public double getX() {
		return this.getData(0, 0);
	}

	public double getY() {
		return this.getData(1, 0);
	}

	public double getZ() {
		return this.getData(2, 0);
	}

	public double getW() {
		return this.getData(3, 0);
	}

	public void setX(double x) {
		this.setData(x, 0, 0);
	}

	public void setY(double y) {
		this.setData(y, 1, 0);
	}

	public void setZ(double z) {
		this.setData(z, 2, 0);
	}

	public Matrix signum() {
		Point P = new Point(this);
		for (int i = 0; i < this.getRows(); i++)
			for (int j = 0; j < this.getColumns(); j++)
				P.setData(Math.signum(this.getData(i, j)), i, j);
		return P;
	}

}
