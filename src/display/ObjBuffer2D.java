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

	public ObjBuffer2D(double w, double h) {
		this.w = w;
		this.h = h;
		c = new Canvas(w, h);
		ctx = c.getGraphicsContext2D();
		ctx.translate(w / 2, h / 2);
		JavaFX.init(this);
	}

	public Canvas getCanvas() {
		return c;
	}

	public void clear() {
		ctx.clearRect(-w / 2, -h / 2, w, h);
	}
}
