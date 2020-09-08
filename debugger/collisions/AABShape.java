package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.shapes.Shape;

public abstract class AABShape extends Shape {
	
	protected Vec2d topLeft;
	protected Vec2d size;

	public AABShape(Vec2d topLeft, Vec2d size) {
		this.topLeft = topLeft;
		this.size = size;
	}
	
	/////
	
	public Vec2d getTopLeft() {
		return topLeft;
	}
	
	public Vec2d getSize() {
		return size;
	}

}
