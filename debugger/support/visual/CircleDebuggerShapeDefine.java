package debugger.support.visual;

import debugger.collisions.shapes.CircleDebugger;
import debugger.support.Display;
import debugger.support.Vec2dDebugger;

public class CircleDebuggerShapeDefine extends CircleDebugger {
	
	public CircleDebuggerShapeDefine(Vec2dDebugger center, float radius) {
		super(center, radius);
	}

	@Override
	public void move(Vec2dDebugger distance) {
		center = center.plus(distance);
		bindToCanvas();
	}
	
	@Override
	public void bindToCanvas() {
		Vec2dDebugger distance = new Vec2dDebugger(0);
		if(center.x - radius < 0) {
			distance = distance.plus(new Vec2dDebugger(radius - center.x, 0));
		} else if(center.x + radius >= Display.getStageWidth()) {
			distance = distance.plus(new Vec2dDebugger(Display.getStageWidth() - center.x - radius, 0));
		}
		
		if(center.y - radius < 0) {
			distance = distance.plus(new Vec2dDebugger(0, radius - center.y));
		} else if(center.y + radius >= Display.getStageHeight()) {
			distance = distance.plus(new Vec2dDebugger(0, Display.getStageHeight() - center.y - radius));
		}
		
		center = center.plus(distance);
	}
	
	@Override
	public boolean atLeftEdge() {
		return center.x - radius <= 0;
	}

	@Override
	public boolean atTopEdge() {
		return center.y - radius <= 0;
	}
	
	@Override
	public boolean atRightEdge() {
		return center.x + radius >= Display.getStageWidth();
	}
	
	@Override
	public boolean atBottomEdge() {
		return center.y + radius >= Display.getStageHeight();
	}
	
}
