package debugger.collisions;

import debugger.support.Vec2d;
import debugger.support.shapes.AABShapeDefine;
import debugger.support.shapes.CircleShapeDefine;
import debugger.support.shapes.PolygonShapeDefine;

public class ShapeBuilder {

	public static AABShapeDefine[] getBoxes() {
		return new AABShapeDefine[] {
				new AABShapeDefine(new Vec2d(100, 120), new Vec2d(60, 35)),
				new AABShapeDefine(new Vec2d(400,  10), new Vec2d(35,  60)),
				new AABShapeDefine(new Vec2d(330, 410), new Vec2d(45, 45))
			};
	}
	
	public static CircleShapeDefine[] getCircles() {
		return new CircleShapeDefine[] {
				new CircleShapeDefine(new Vec2d(150, 200), 10),
				new CircleShapeDefine(new Vec2d(500, 380), 30),
				new CircleShapeDefine(new Vec2d(300, 220), 20)
			};
	}
	
	public static PolygonShapeDefine[] getPolygons() {
		return new PolygonShapeDefine[] {
			new PolygonShapeDefine(new Vec2d(210, 195), new Vec2d(230, 195), new Vec2d(240, 170),
					new Vec2d(220, 160), new Vec2d(200, 170))	
		};
	}
	
}
