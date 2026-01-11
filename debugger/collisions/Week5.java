package debugger.collisions;

import debugger.support.Vec2dDebugger;
import debugger.support.requirements.Week5Reqs;
import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;
import debugger.collisions.shapes.PolygonDebugger;

/**
 * Fill this class in during Project 5 (NIN 1). Make sure to also change the week variable in Main.java.
 */
public final class Week5 extends Week5Reqs {

	// TODO POLYGONS

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, AABDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, CircleDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, Vec2dDebugger s2) {
		return null;
	}

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, PolygonDebugger s2) {
		return null;
	}

    /* =================================================================================================================
     * Reuse Week3 collision detection methods
     */
    private final Week3 week3 = new Week3();
    // AXIS-ALIGNED BOXES

    @Override
    public Vec2dDebugger collision(AABDebugger s1, AABDebugger s2) {
        return week3.collision(s1, s2);
    }

    @Override
    public Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2) {
        return week3.collision(s1, s2);
    }

    @Override
    public Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2) {
        return week3.collision(s1, s2);
    }

    @Override
    public Vec2dDebugger collision(AABDebugger s1, PolygonDebugger s2) {
        Vec2dDebugger f = collision(s2, s1);
        return f == null ? null : f.reflect();
    }

    // CIRCLES

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2) {
        Vec2dDebugger f = collision(s2, s1);
        return f == null ? null : f.reflect();
    }

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2) {
        return week3.collision(s1, s2);
    }

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2) {
        return week3.collision(s1, s2);
    }

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, PolygonDebugger s2) {
        Vec2dDebugger f = collision(s2, s1);
        return f == null ? null : f.reflect();
    }
	
}
