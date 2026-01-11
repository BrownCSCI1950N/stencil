package debugger.support.requirements;

import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;
import debugger.collisions.shapes.PolygonDebugger;
import debugger.collisions.shapes.RayDebugger;
import debugger.support.Vec2dDebugger;

public interface DebuggerCollisionFunctions {

	public Vec2dDebugger collision(AABDebugger s1, AABDebugger s2);
	public Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2);
	public Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2);
	public Vec2dDebugger collision(AABDebugger s1, PolygonDebugger s2);
	
	public Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2);
	public Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2);
	public Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2);
	public Vec2dDebugger collision(CircleDebugger s1, PolygonDebugger s2);
	
	
	public Vec2dDebugger collision(PolygonDebugger s1, AABDebugger s2);
	public Vec2dDebugger collision(PolygonDebugger s1, CircleDebugger s2);
	public Vec2dDebugger collision(PolygonDebugger s1, Vec2dDebugger s2);
	public Vec2dDebugger collision(PolygonDebugger s1, PolygonDebugger s2);
	
	public float raycast(AABDebugger s1, RayDebugger s2);
	public float raycast(CircleDebugger s1, RayDebugger s2);
	public float raycast(PolygonDebugger s1, RayDebugger s2);
	
}
