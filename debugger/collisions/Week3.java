package debugger.collisions;

import debugger.support.Vec2dDebugger;
import debugger.support.requirements.Week3Reqs;
import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;

/**
 * Fill this class in during Project 3 (Wiz 1). Make sure to also change the week variable in Main.java.
 */
public final class Week3 extends Week3Reqs {

	// TODO AXIS-ALIGNED BOXES mtvs
	
	@Override
	public Vec2dDebugger collision(AABDebugger s1, AABDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2) {
		return null;
	}
	
	// TODO CIRCLES mtvs


	@Override
	public Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2) {
		return null;
	}

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2) {
        Vec2dDebugger f = collision(s2, s1);
        return f == null ? null : f.reflect();
    }

}
