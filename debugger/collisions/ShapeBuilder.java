package debugger.collisions;

import debugger.support.Vec2dDebugger;
import debugger.support.visual.AABDebuggerShapeDefine;
import debugger.support.visual.CircleDebuggerShapeDefine;
import debugger.support.visual.PolygonDebuggerShapeDefine;

public class ShapeBuilder {

	public static AABDebuggerShapeDefine[] getBoxes() {
		return new AABDebuggerShapeDefine[] {
				new AABDebuggerShapeDefine(new Vec2dDebugger(100, 120), new Vec2dDebugger(60, 35)),
				new AABDebuggerShapeDefine(new Vec2dDebugger(400,  10), new Vec2dDebugger(35,  60)),
				new AABDebuggerShapeDefine(new Vec2dDebugger(330, 410), new Vec2dDebugger(45, 45)),
				new AABDebuggerShapeDefine(new Vec2dDebugger(530, 510), new Vec2dDebugger(100, 100))
			};
	}
	
	public static CircleDebuggerShapeDefine[] getCircles() {
		return new CircleDebuggerShapeDefine[] {
				new CircleDebuggerShapeDefine(new Vec2dDebugger(150, 200), 10),
				new CircleDebuggerShapeDefine(new Vec2dDebugger(500, 380), 30),
				new CircleDebuggerShapeDefine(new Vec2dDebugger(300, 220), 20)
			};
	}
	
	public static PolygonDebuggerShapeDefine[] getPolygons() {
		return new PolygonDebuggerShapeDefine[] {
			new PolygonDebuggerShapeDefine(new Vec2dDebugger(210, 195), new Vec2dDebugger(230, 195), new Vec2dDebugger(240, 170),
					new Vec2dDebugger(220, 160), new Vec2dDebugger(200, 170)),

			new PolygonDebuggerShapeDefine(new Vec2dDebugger(220, 195), new Vec2dDebugger(250, 195), new Vec2dDebugger(280, 170),
					new Vec2dDebugger(230, 160), new Vec2dDebugger(210, 170)),

			new PolygonDebuggerShapeDefine(new Vec2dDebugger(50,100), new Vec2dDebugger(800,100),
				new Vec2dDebugger(800,70), new Vec2dDebugger(600,0), new Vec2dDebugger(50,70))
		};
	}
}
