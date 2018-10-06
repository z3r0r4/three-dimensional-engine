package zeroComputation;

import java.util.ArrayList;

public class ThreeDObject {

	ArrayList<Point> edges = new ArrayList<Point>();
	ArrayList<int[]> vertices = new ArrayList<int[]>();
	ArrayList<int[]> faces = new ArrayList<int[]>();

	public ThreeDObject() {
		// TODO Auto-generated constructor stub
	}

	public ThreeDObject(double x, double y, double z, double w, double h, double d) {
		initCube(x, y, z, w, h, d);
	}

	private ThreeDObject initCube(double x, double y, double z, double w, double h, double d) {
		edges.add(new Point(x, y, z));
		edges.add(new Point(x + w, y, z));
		edges.add(new Point(x + w, y + h, z));
		edges.add(new Point(x, y + h, z));
		edges.add(new Point(x, y, z + d));
		edges.add(new Point(x + w, y, z + d));
		edges.add(new Point(x + w, y + h, z + d));
		edges.add(new Point(x, y + h, z + d));

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
		faces.add(new int[] { 0, 1, 4, 5 });
		faces.add(new int[] { 1, 2, 5, 6 });
		faces.add(new int[] { 2, 3, 6, 7 });
		faces.add(new int[] { 3, 0, 7, 4 });
		return this;
	}

	public ArrayList<Point> getEdges() {
		return edges;
	}

	public void setEdges(ArrayList<Point> edges) {
		this.edges = edges;
	}

	public ArrayList<int[]> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<int[]> vertices) {
		this.vertices = vertices;
	}

	public ArrayList<int[]> getFaces() {
		return faces;
	}

	public void setFaces(ArrayList<int[]> faces) {
		this.faces = faces;
	}

}
