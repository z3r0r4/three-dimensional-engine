package display;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class ObjectHolder2D { //Bulds the canvas and stuff

	private Canvas c = null;
	public GraphicsContext ctx = null;
	private double w, h;
	private double x_, y_;

	public ObjectHolder2D(double w, double h) {
		this.w = w;
		this.h = h;
		c = new Canvas(w, h);
		ctx = c.getGraphicsContext2D();
		ctx.translate(w / 2, h / 2);
	}

	public Canvas getCanvas() {
		return c;
	}

	public void clear() {
		ctx.clearRect(-w / 2, -h / 2, w, h);
	}
}
