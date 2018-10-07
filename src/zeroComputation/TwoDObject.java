package zeroComputation;

import java.util.ArrayList;

public class TwoDObject extends ThreeDObject {

	public TwoDObject(ThreeDObject Dobj) {
		super();
		this.edges = TwoDObject.CabinetProjection(Dobj.edges);
		this.vertices = Dobj.vertices;
		this.faces = Dobj.faces;
	}

	public static ArrayList<Point> simpleOrthographicProjection(ArrayList<Point> e) {
		e.forEach(p -> p.OrthographicProjection());
		return e;
	}

	public static ArrayList<Point> OrthographicProjection(ArrayList<Point> e) { //uses Homogen zeug
		 e.forEach(p -> p.OrthographicProjection());
		 return e;
	}
	public static ArrayList<Point> CabinetProjection(ArrayList<Point> e){
		 e.forEach(p -> p.CabinetProjection(Math.toRadians(63.4f)));
		return e;
	}
}
