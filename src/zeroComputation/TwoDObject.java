package zeroComputation;

import java.util.ArrayList;

public class TwoDObject extends ThreeDObject {

	public TwoDObject(ThreeDObject Dobj) {
		super();
		this.edges = TwoDObject.simpleOrthographicProjection(Dobj.edges);
		this.vertices = Dobj.vertices;
		this.faces = Dobj.faces;
	}

	public static ArrayList<Point> simpleOrthographicProjection(ArrayList<Point> e) {
		e.forEach(p -> p.simpleOrthographicProjection());
		return e;
	}
}
