package debugger.collisions.shapes;

import debugger.support.Vec2dDebugger;
import debugger.support.visual.DebuggerShape;

public abstract class AABDebugger extends DebuggerShape {
	
	protected Vec2dDebugger topLeft;
	protected Vec2dDebugger size;

	public AABDebugger(Vec2dDebugger topLeft, Vec2dDebugger size) {
		this.topLeft = topLeft;
		this.size = size;
	}
	
	/////
	
	public Vec2dDebugger getTopLeft() {
		return topLeft;
	}
	
	public Vec2dDebugger getSize() {
		return size;
	}

}
