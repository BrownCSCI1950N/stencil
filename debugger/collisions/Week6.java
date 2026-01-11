package debugger.collisions;

import debugger.support.Vec2dDebugger;
import debugger.support.requirements.Week6Reqs;
import debugger.collisions.shapes.AABDebugger;
import debugger.collisions.shapes.CircleDebugger;
import debugger.collisions.shapes.RayDebugger;
import debugger.collisions.shapes.PolygonDebugger;

/**
 * Fill this class in during Project 6 (NIN 2). Make sure to also change the week variable in Main.java.
 */
public final class Week6 extends Week6Reqs {

    // TODO RAYCASTING

    @Override
    public float raycast(AABDebugger s1, RayDebugger s2) {
        return -1;
    }

    @Override
    public float raycast(CircleDebugger s1, RayDebugger s2) {
        return -1;
    }

    @Override
    public float raycast(PolygonDebugger s1, RayDebugger s2) {
        return -1;
    }

    /* =================================================================================================================
     * Reuse Week5 for other collisions
     */
    private final Week5 week5 = new Week5();
    // Disabled Point (mouse) collisions to allow for raycasting inside shapes
    @Override
    public Vec2dDebugger collision(AABDebugger s1, Vec2dDebugger s2) {
        return null;
    }

    @Override
    public Vec2dDebugger collision(CircleDebugger s1, Vec2dDebugger s2) {
        return null;
    }

    @Override
    public Vec2dDebugger collision(PolygonDebugger s1, Vec2dDebugger s2) {
        return null;
    }



    // AXIS-ALIGNED BOXES
	
	@Override
	public Vec2dDebugger collision(AABDebugger s1, AABDebugger s2) {
		return week5.collision(s1, s2);
	}

	@Override
	public Vec2dDebugger collision(AABDebugger s1, CircleDebugger s2) {
		return week5.collision(s1, s2);
	}


	@Override
	public Vec2dDebugger collision(AABDebugger s1, PolygonDebugger s2) {
		return week5.collision(s1, s2);
	}

	// CIRCLES
	
	@Override
	public Vec2dDebugger collision(CircleDebugger s1, AABDebugger s2) {
		Vec2dDebugger f = collision(s2, s1);
		return f == null ? null : f.reflect();
	}

	@Override
	public Vec2dDebugger collision(CircleDebugger s1, CircleDebugger s2) {
		return week5.collision(s1, s2);
	}


	@Override
	public Vec2dDebugger collision(CircleDebugger s1, PolygonDebugger s2) {
		return week5.collision(s1, s2);
	}
	
	// POLYGONS

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, AABDebugger s2) {
		Vec2dDebugger f = collision(s2, s1);
		return f == null ? null : f.reflect();
	}

	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, CircleDebugger s2) {
		Vec2dDebugger f = collision(s2, s1);
		return f == null ? null : f.reflect();
	}


	@Override
	public Vec2dDebugger collision(PolygonDebugger s1, PolygonDebugger s2) {
		return week5.collision(s1, s2);
	}
	


}
