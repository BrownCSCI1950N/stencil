package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.interfaces.Week2Reqs;

/**
 * Fill this class in during Week 2.
 */
public final class Week2 extends Week2Reqs {

	// AXIS-ALIGNED BOXES
	
	@Override
	public boolean isColliding(AABShape s1, AABShape s2) {
		return false;
	}

	@Override
	public boolean isColliding(AABShape s1, CircleShape s2) {
		return false;
	}

	@Override
	public boolean isColliding(AABShape s1, Vec2d s2) {
		return false;
	}

	// CIRCLES
	
	@Override
	public boolean isColliding(CircleShape s1, AABShape s2) {
		return isColliding(s2, s1);
	}

	@Override
	public boolean isColliding(CircleShape s1, CircleShape s2) {
		return false;
	}

	@Override
	public boolean isColliding(CircleShape s1, Vec2d s2) {
		return false;
	}

	
}
