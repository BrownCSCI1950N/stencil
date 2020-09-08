package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.shapes.Shape;

public abstract class CircleShape extends Shape {
	
	protected Vec2d center;
	protected float radius;
	
	public CircleShape(Vec2d center, float radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/////
	
	public Vec2d getCenter() {
		return center;
	}
	
	public float getRadius() {
		return radius;
	}
	
}
