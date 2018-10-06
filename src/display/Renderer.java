package display;

import zeroComputation.Point;

public class Renderer {
	static double k = 0;

	public static void draw(ObjectHolder2D obj2d) {
		k++;
		obj2d.clear();
		obj2d.ctx.strokeRect(k, 10, 10, 10);
	}

	public static void drawLine(ObjectHolder2D obj2d) {
		k += 0.1;
		//obj2d.clear();
		
		Point A = new Point(0, 0, 0);
		Point B = new Point(125, 125, 250);
		B = Point.RotateXYZ(B, k, k, k);
		
		Point A2 = A.simpleOrthographicProjection();
		Point B2 = B.simpleOrthographicProjection();
		
		obj2d.ctx.strokeLine(A2.getData(0, 0), A2.getData(1, 0), B2.getData(0, 0), B2.getData(1, 0));
	}
}