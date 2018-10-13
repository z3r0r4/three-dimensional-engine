package display;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

/**
 * @author Z3R0R4
 * @version 0.1
 * @description Builds and manages the Canvas
 */

public class ObjBuffer2D { //Bulds the canvas and stuff

	private Canvas c = null;
	public GraphicsContext ctx;
	private double w, h;
	//private double x_, y_;
	//	public ObjBuffer2D(double w, double h) {
	//		JavaFX.intit(this);
	//		this.w = w;
	//		this.h = h;
	//		c = new Canvas(w, h);
	//		System.out.println("dfgdf");
	//		ctx = c.getGraphicsContext2D();
	//		System.out.println("ydfg");
	//		ctx.translate(w / 2, h / 2);
	//	}
//	public ObjBuffer2D(int width, int height) {
//		initDim(width, height);
//		initGraphics();
//	}

	public ObjBuffer2D(double w, double h) {
		this.w = w;
		this.h = h;
		c = new Canvas(w, h);
		ctx = c.getGraphicsContext2D();
		ctx.translate(w / 2, h / 2);
		JavaFX.intit(this);
}
	private final void initDim(int w, int h) {
		this.w = w;
		this.h = h;
	}

	private final void initGraphics() {
		c = new Canvas(w, h);
		ctx = c.getGraphicsContext2D();
		System.out.println("passed");
	}

	public Canvas getCanvas() {
		return c;
	}

	public void clear() {
		ctx.clearRect(-w / 2, -h / 2, w, h);
	}
}
