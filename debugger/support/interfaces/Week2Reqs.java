package debugger.support.interfaces;

import debugger.collisions.AABShape;
import debugger.collisions.CircleShape;
import debugger.collisions.PolygonShape;
import debugger.collisions.Ray;
import debugger.support.Vec2d;

public abstract class Week2Reqs implements CollisionFunctions {
	
	public abstract boolean isColliding(AABShape s1, AABShape s2);
	public abstract boolean isColliding(AABShape s1, CircleShape s2);
	public abstract boolean isColliding(AABShape s1, Vec2d s2);
	
	public abstract boolean isColliding(CircleShape s1, AABShape s2);
	public abstract boolean isColliding(CircleShape s1, CircleShape s2);
	public abstract boolean isColliding(CircleShape s1, Vec2d s2);
	
	public final Vec2d collision(AABShape s1, AABShape s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(AABShape s1, CircleShape s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(AABShape s1, Vec2d s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(AABShape s1, PolygonShape s2) {
		return null;
	}
	
	public final Vec2d collision(CircleShape s1, AABShape s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(CircleShape s1, CircleShape s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(CircleShape s1, Vec2d s2) {
		return isColliding(s1, s2) ? new Vec2d(0, 0) : null;
	}
	public final Vec2d collision(CircleShape s1, PolygonShape s2) {
		return null;
	}
	
	public final Vec2d collision(PolygonShape s1, AABShape s2) {
		return null;
	}
	public final Vec2d collision(PolygonShape s1, CircleShape s2) {
		return null;
	}
	public final Vec2d collision(PolygonShape s1, Vec2d s2) {
		return null;
	}
	public final Vec2d collision(PolygonShape s1, PolygonShape s2) {
		return null;
	}
	
	public final float raycast(AABShape s1, Ray s2) {
		return -1;
	}
	public final float raycast(CircleShape s1, Ray s2) {
		return -1;
	}
	public final float raycast(PolygonShape s1, Ray s2) {
		return -1;
	}

	

}
