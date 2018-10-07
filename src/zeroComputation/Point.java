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
		//System.out.println("simpleOrtho");
		return new Point(Matrix.prod(O, this));
	}

	public Point OrthographicProjection() {
		//System.out.println("Ortho");
		double r = 1f, l = -1f, t = 1f, b = -1f, n = -1f, f = 1f;

		Matrix H = Matrix.fromArray(new double[][] {
				{ 2 / (r - l), 0, 0, -(r + l) / (r - l) },
				{ 0, 2 / (t - b), 0, -(t + b) / (t - b) },
				{ 0, 0, 2 / (f - n), -(f + n) / (f - n) },
				{ 0, 0, 0, 1 }
		});
		return new Point(Matrix.prod(H, this));
	}

	public Point CabinetProjection(double CabinetAngle) {
		//System.out.println("Cabinet");
		Matrix P = Matrix.fromArray(new double[][] {
				{ 1, 0, 0.5 * Math.cos(CabinetAngle), 0 },
				{ 0, 1, 0.5 * Math.sin(CabinetAngle), 0 },
		});
		return new Point(Matrix.prod(P, this));
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

}
