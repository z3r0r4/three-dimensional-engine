package objects;

import zeroComputation.Point;

public class Cube extends Obj {

	public Cube(double x, double y, double z, double w, double h, double d) {
		initCube(x, y, z, w, h, d);
	}
	private Cube initCube(double x, double y, double z, double w, double h, double d) {
		edges.add(new Point(x, y, z, 1));
		edges.add(new Point(x + w, y, z, 1));
		edges.add(new Point(x + w, y + h, z, 1));
		edges.add(new Point(x, y + h, z, 1));
		edges.add(new Point(x, y, z + d, 1));
		edges.add(new Point(x + w, y, z + d, 1));
		edges.add(new Point(x + w, y + h, z + d, 1));
		edges.add(new Point(x, y + h, z + d, 1));

		vertices.add(new int[] { 0, 1 });
		vertices.add(new int[] { 1, 2 });
		vertices.add(new int[] { 2, 3 });
		vertices.add(new int[] { 3, 0 });
		vertices.add(new int[] { 4, 5 });
		vertices.add(new int[] { 5, 6 });
		vertices.add(new int[] { 6, 7 });
		vertices.add(new int[] { 7, 4 });
		vertices.add(new int[] { 0, 4 });
		vertices.add(new int[] { 1, 5 });
		vertices.add(new int[] { 2, 6 });
		vertices.add(new int[] { 3, 7 });

		faces.add(new int[] { 0, 1, 2, 3 });
		faces.add(new int[] { 4, 5, 6, 7 });
		faces.add(new int[] { 0, 1, 5, 4 });
		faces.add(new int[] { 1, 2, 6, 5 });
		faces.add(new int[] { 2, 3, 7, 6 });
		faces.add(new int[] { 3, 0, 4, 7 });
		return this;
	}
}
