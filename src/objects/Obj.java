package objects;

import java.util.ArrayList;
import java.util.Collections;

import zeroComputation.Point;

public class Obj {
	public ArrayList<Point> edges = new ArrayList<Point>();
	public ArrayList<int[]> vertices = new ArrayList<int[]>();
	public ArrayList<int[]> faces = new ArrayList<int[]>();

	protected void initVertecies(int c) {//number of conncetions per edge
		for (int i = 0; i < edges.size(); i++) {
			ArrayList<Double> PointDistance = new ArrayList<Double>();
			ArrayList<Double> PointDistanceC = new ArrayList<Double>();
			for (int j = 0; j < edges.size(); j++)
				if (i != j)
					PointDistance.add(Point.distance(edges.get(i), edges.get(j)));
				else
					PointDistance.add(100000d);

			for (Double d : PointDistance) { //clone
				PointDistanceC.add(d);
			}
			double m = Collections.min(PointDistance);
			PointDistance.sort((Double z1, Double z2) -> {
				if (z1 > z2)
					return 1;
				if (z1 < z2)
					return -1;
				return 0;
			});
			for (int j = 0; j < c; j++)
				vertices.add(new int[] { i, PointDistanceC.indexOf(PointDistance.get(j)) });
		}
	}

	public void RotateXYZ(double angleX, double angleY, double angleZ) {
		edges.forEach(e -> e.RotateXYZ(angleX, angleY, angleZ));
	}

	public void RotateXYZh(double angleX, double angleY, double angleZ) {
		edges.forEach(e -> e.RotateXYZh(angleX, angleY, angleZ));
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
