package zeroComputation;

public class Point extends Matrix {
	//Math.toRadians(degree);

	Matrix O = Matrix.fromArray(new double[][] {
			{ 1, 0, 0 },
			{ 0, 1, 0 }
	});

	public Point(double... koefficent) {
		super(koefficent.length, 1);
		
		for (int i = 0; i < koefficent.length; i++) {
			this.setData(koefficent[i], i, 0);
		}
	}

	public Point(Matrix A) {
		super(A.getRows(), A.getColumns());

		if (A.getColumns() != 1)
			throw new IllegalArgumentException("Can't be a Point");

		for (int i = 0; i < A.getRows(); i++) {
			this.setData(A.getData(i, 0), i, 0);
		}
	}

	public Point simpleOrthographicProjection() {
		return new Point(Matrix.prod(O, this));
	}

	public Point OrthographicProjection() {
		double r = 10f;
		double l = 3;
		double t = 1f;
		double b = -1f;
		double n = -1f;
		double f = 1f;
		
		Matrix H = Matrix.fromArray(new double[][] {
				{ 2 / (r - l), 0, 0, -(r + l) / (r - l) },
				{ 0, 2 / (t - b), 0, -(t + b) / (t - b) },
				{ 0, 0, 2 / (f - n), -(f + n) / (f - n) },
				{ 0, 0, 0, 1 }
		});
		return new Point(Matrix.prod(H, this));
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

	public static Point RotateX(Point P, double angle) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, Math.cos(angle), -Math.sin(angle) },
				{ 0, Math.sin(angle), Math.cos(angle) } });

		return new Point(Matrix.prod(R_x, P));
	}

	public void RotateX(double angle) {
		Matrix R_x = Matrix.fromArray(new double[][] {
				{ 1, 0, 0 },
				{ 0, Math.cos(angle), -Math.sin(angle) },
				{ 0, Math.sin(angle), Math.cos(angle) } });

		this.setData((new Point(
				Matrix.prod(R_x, this)))
						.getData());
	}

	public static Point RotateY(Point P, double angle) {
		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(angle), 0, Math.sin(angle) },
				{ 0, 1, 0 },
				{ -Math.sin(angle), 0, Math.cos(angle) } });

		return new Point(Matrix.prod(R_y, P));
	}

	public void RotateY(double angle) {
		Matrix R_y = Matrix.fromArray(new double[][] {
				{ Math.cos(angle), 0, Math.sin(angle) },
				{ 0, 1, 0 },
				{ -Math.sin(angle), 0, Math.cos(angle) } });

		this.setData((new Point(
				Matrix.prod(R_y, this)))
						.getData());
	}

	public static Point RotateZ(Point P, double angle) {
		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(angle), Math.sin(angle), 0 },
				{ -Math.sin(angle), Math.cos(angle), 0 },
				{ 0, 0, 1 } });
		return new Point(Matrix.prod(R_z, P));
	}

	public void RotateZ(double angle) {
		Matrix R_z = Matrix.fromArray(new double[][] {
				{ Math.cos(angle), Math.sin(angle), 0 },
				{ -Math.sin(angle), Math.cos(angle), 0 },
				{ 0, 0, 1 } });

		this.setData((new Point(
				Matrix.prod(R_z, this)))
						.getData());
	}

	public double[] xPoints(Point... points) {
		double[] x = new double[points.length];

		for (int i = 0; i < points.length; i++)
			x[i] = points[i].getData(0, 0);

		return x;
	}

	public double[] yPoints(Point... points) {
		double[] y = new double[points.length];

		for (int i = 0; i < points.length; i++)
			y[i] = points[i].getData(1, 0);

		return y;
	}

}
