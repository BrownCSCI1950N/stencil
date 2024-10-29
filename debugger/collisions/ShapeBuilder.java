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
				new AABShapeDefine(new Vec2d(330, 410), new Vec2d(45, 45)),
				new AABShapeDefine(new Vec2d(530, 510), new Vec2d(100, 100))
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
					new Vec2d(220, 160), new Vec2d(200, 170)),
			new PolygonShapeDefine(new Vec2d(220, 195), new Vec2d(250, 195), new Vec2d(280, 170),
					new Vec2d(230, 160), new Vec2d(210, 170)),
			new PolygonShapeDefine( new Vec2d(.5 * 100,1 * 100), new Vec2d(8 * 100,1 * 100),
				new Vec2d(8 * 100,.7 * 100), new Vec2d(6 * 100,0 * 100), new Vec2d(.5 * 100,.7 * 100))
		};
	}
}
