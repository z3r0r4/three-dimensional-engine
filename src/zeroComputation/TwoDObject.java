package zeroComputation;

import java.util.ArrayList;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Class that Starts all needed things for JavaFx and Animation
 *              many things are outsourced to other classes
 */
public class TwoDObject extends ThreeDObject {

	public TwoDObject(ThreeDObject Dobj) {
		super();
		this.edges = TwoDObject.OrthographicProjection(Dobj.edges);
		//		System.out.println(Dobj.edges.equals(this.edges)); //shallow copy safe guard
		this.vertices = Dobj.vertices;
		this.faces = Dobj.faces;
	}

	public static ArrayList<Point> simpleOrthographicProjection(ArrayList<Point> e) {
		ArrayList<Point> d = new ArrayList<Point>();
		e.forEach(p -> d.add(p.simpleOrthographicProjection()));
		return d;
	}

	public static ArrayList<Point> OrthographicProjection(ArrayList<Point> e) { //uses Homogen zeug
		ArrayList<Point> d = new ArrayList<Point>();
		e.forEach(p -> d.add(p.OrthographicProjection()));
		return d;
	}

	public static ArrayList<Point> CabinetProjection(ArrayList<Point> e) {
		ArrayList<Point> d = new ArrayList<Point>();
		e.forEach(p -> d.add(p.CabinetProjection(Math.toRadians(63.4f))));
		return d;
	}
}
