package debugger.collisions.shapes;

import debugger.support.Vec2dDebugger;

public final class RayDebugger {
	
	public final Vec2dDebugger src;
	public final Vec2dDebugger dir;
	
	public RayDebugger(Vec2dDebugger src, Vec2dDebugger dir) {
		this.src = src;
		this.dir = dir;
	}

}
