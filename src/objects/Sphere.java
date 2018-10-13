package objects;

import zeroComputation.Point;

public class Sphere extends Obj{
	public Sphere() {
		initSpherePoints(20, 100, new Point(0, 0, 0));
		initVertecies(20);
	}

	private Sphere initSpherePoints(double stepsize, double r, Point P) {
		int i = 0;
		for (double phi = 0; phi < 2 * Math.PI; phi += Math.toRadians(stepsize)) {
			for (double alpha = 0; alpha < 2 * Math.PI; alpha += Math.toRadians(stepsize)) {

				edges.add(
						new Point(P.getData(0, 0) + r * Math.cos(phi) * Math.cos(alpha),
								P.getData(1, 0) + r * Math.cos(phi) * Math.sin(alpha),
								P.getData(2, 0) + r * Math.sin(phi),
								1)); 
			}
		}
		return this;
	}
}
