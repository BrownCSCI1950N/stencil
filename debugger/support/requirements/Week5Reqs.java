package debugger.support.requirements;

import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;
import debugger.collisions.shapes.PolygonDebugger;
import debugger.collisions.shapes.RayDebugger;
import debugger.support.Vec2dDebugger;

public abstract class Week5Reqs implements DebuggerCollisionFunctions {

	public abstract Vec2dDebugger collision(AABDebugger s1, AABDebugger s2);
	public abstract Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2);
	public abstract Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2);
	public abstract Vec2dDebugger collision(AABDebugger s1, PolygonDebugger s2);
	
	public abstract Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2);
	public abstract Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2);
	public abstract Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2);
	public abstract Vec2dDebugger collision(CircleDebugger s1, PolygonDebugger s2);
	
	public abstract Vec2dDebugger collision(PolygonDebugger s1, AABDebugger s2);
	public abstract Vec2dDebugger collision(PolygonDebugger s1, CircleDebugger s2);
	public abstract Vec2dDebugger collision(PolygonDebugger s1, Vec2dDebugger s2);
	public abstract Vec2dDebugger collision(PolygonDebugger s1, PolygonDebugger s2);
	
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
