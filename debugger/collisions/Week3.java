package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.interfaces.Week3Reqs;

/**
 * Fill this class in during Week 3. Make sure to also change the week variable in Display.java.
 */
public final class Week3 extends Week3Reqs {

	// AXIS-ALIGNED BOXES
	
	@Override
	public Vec2d collision(AABShape s1, AABShape s2) {
		return null;
	}

	@Override
	public Vec2d collision(AABShape s1, CircleShape s2) {
		return null;
	}

	@Override
	public Vec2d collision(AABShape s1, Vec2d s2) {
		return null;
	}
	
	// CIRCLES

	@Override
	public Vec2d collision(CircleShape s1, AABShape s2) {
		Vec2d f = collision(s2, s1);
		return f == null ? null : f.reflect();
	}

	@Override
	public Vec2d collision(CircleShape s1, CircleShape s2) {
		return null;
	}

	@Override
	public Vec2d collision(CircleShape s1, Vec2d s2) {
		return null;
	}

}
