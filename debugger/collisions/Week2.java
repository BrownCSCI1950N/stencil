package debugger.collisions;

import debugger.support.Vec2dDebugger;
import debugger.support.requirements.Week2Reqs;
import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;


/**
 * Fill this class in during Project 2 (Alc 2).
 */
public final class Week2 extends Week2Reqs {

	// TODO AXIS-ALIGNED BOXES
	
	@Override
	public boolean isColliding(AABDebugger s1, AABDebugger s2) {
		return false;
	}

	@Override
	public boolean isColliding(AABDebugger s1, CircleDebugger s2) {
		return false;
	}

	@Override
	public boolean isColliding(AABDebugger s1, Vec2dDebugger s2) {
		return false;
	}

	// TODO CIRCLES
	
	@Override
	public boolean isColliding(CircleDebugger s1, AABDebugger s2) {
		return isColliding(s2, s1);
	}

	@Override
	public boolean isColliding(CircleDebugger s1, CircleDebugger s2) {
		return false;
	}

	@Override
	public boolean isColliding(CircleDebugger s1, Vec2dDebugger s2) {
		return false;
	}

	
}
