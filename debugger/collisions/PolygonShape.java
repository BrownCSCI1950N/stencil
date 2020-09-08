package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.shapes.Shape;

public abstract class PolygonShape extends Shape {
	
	protected Vec2d[] points;
	
	public PolygonShape(Vec2d ... points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return points.length;
	}
	
	public Vec2d getPoint(int i) {
		return points[i];
	}
	
}
