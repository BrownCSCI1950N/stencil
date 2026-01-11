package debugger.collisions.shapes;

import debugger.support.Vec2dDebugger;
import debugger.support.visual.DebuggerShape;

public abstract class PolygonDebugger extends DebuggerShape {
	
	protected Vec2dDebugger[] points;
	
	public PolygonDebugger(Vec2dDebugger... points) {
		this.points = points;
	}
	
	public int getNumPoints() {
		return points.length;
	}
	
	public Vec2dDebugger getPoint(int i) {
		return points[i];
	}
	
}
