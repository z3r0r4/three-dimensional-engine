package zeroComputation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Super class that holds
 */
public class ThreeDObject {

	public ArrayList<Point> edges = new ArrayList<Point>();
	public ArrayList<int[]> vertices = new ArrayList<int[]>();
	public ArrayList<int[]> faces = new ArrayList<int[]>();

	public ThreeDObject(double x, double y, double z, double w, double h, double d) {
		initCube(x, y, z, w, h, d);
	}

	public ThreeDObject() {
		initSpherePoints(10, 100, new Point(0, 0, 0));
		initVertecies(2);
	}

	private ThreeDObject initCube(double x, double y, double z, double w, double h, double d) {
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

	private ThreeDObject initSpherePoints(double stepsize, double r, Point P) {
		int i = 0;
		for (double phi = 0; phi < 2 * Math.PI; phi += Math.toRadians(stepsize)) {
			for (double alpha = 0; alpha < 2 * Math.PI; alpha += Math.toRadians(stepsize)) {

				edges.add(
						new Point(P.getData(0, 0) + r * Math.cos(phi) * Math.cos(alpha),
								P.getData(1, 0) + r * Math.cos(phi) * Math.sin(alpha),
								P.getData(2, 0) + r * Math.sin(phi),
								1)); //shoukd use differnt angles but dont care
				//				if (i > 0)
				//					vertices.add(new int[] { i, i });
				//				i++;
			}
		}
		return this;
	}

	private void initVertecies(int c) {//number of conncetions
		//System.out.println("lolo");
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
			//System.out.println(i + " " + PointDistance.get(0) + " " + m);

			//System.out.println(Arrays.toString(vertices.toArray()));
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
