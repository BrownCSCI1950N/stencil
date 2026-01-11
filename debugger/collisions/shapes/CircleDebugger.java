package debugger.collisions.shapes;

import debugger.support.Vec2dDebugger;
import debugger.support.visual.DebuggerShape;

public abstract class CircleDebugger extends DebuggerShape {
	
	protected Vec2dDebugger center;
	protected float radius;
	
	public CircleDebugger(Vec2dDebugger center, float radius) {
		this.center = center;
		this.radius = radius;
	}
	
	/////
	
	public Vec2dDebugger getCenter() {
		return center;
	}
	
	public float getRadius() {
		return radius;
	}
	
}
