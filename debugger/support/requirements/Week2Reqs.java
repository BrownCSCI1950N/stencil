package debugger.support.requirements;

import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;
import debugger.collisions.shapes.PolygonDebugger;
import debugger.collisions.shapes.RayDebugger;
import debugger.support.Vec2dDebugger;

public abstract class Week2Reqs implements DebuggerCollisionFunctions {
	
	public abstract boolean isColliding(AABDebugger s1, AABDebugger s2);
	public abstract boolean isColliding(AABDebugger s1, CircleDebugger s2);
	public abstract boolean isColliding(AABDebugger s1, Vec2dDebugger s2);
	
	public abstract boolean isColliding(CircleDebugger s1, AABDebugger s2);
	public abstract boolean isColliding(CircleDebugger s1, CircleDebugger s2);
	public abstract boolean isColliding(CircleDebugger s1, Vec2dDebugger s2);
	
	public final Vec2dDebugger collision(AABDebugger s1, AABDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(AABDebugger s1, PolygonDebugger s2) {
		return null;
	}
	
	public final Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2) {
		return isColliding(s1, s2) ? new Vec2dDebugger(0, 0) : null;
	}
	public final Vec2dDebugger collision(CircleDebugger s1, PolygonDebugger s2) {
		return null;
	}
	
	public final Vec2dDebugger collision(PolygonDebugger s1, AABDebugger s2) {
		return null;
	}
	public final Vec2dDebugger collision(PolygonDebugger s1, CircleDebugger s2) {
		return null;
	}
	public final Vec2dDebugger collision(PolygonDebugger s1, Vec2dDebugger s2) {
		return null;
	}
	public final Vec2dDebugger collision(PolygonDebugger s1, PolygonDebugger s2) {
		return null;
	}
	
	public final float raycast(AABDebugger s1, RayDebugger s2) {
		return -1;
	}
	public final float raycast(CircleDebugger s1, RayDebugger s2) {
		return -1;
	}
	public final float raycast(PolygonDebugger s1, RayDebugger s2) {
		return -1;
	}

	

}
