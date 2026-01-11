package debugger.support.visual;

import debugger.collisions.shapes.AABDebugger;
import debugger.support.Display;
import debugger.support.Vec2dDebugger;

public class AABDebuggerShapeDefine extends AABDebugger {
	
	public AABDebuggerShapeDefine(Vec2dDebugger topLeft, Vec2dDebugger bottomRight) {
		super(topLeft, bottomRight);
	}

	@Override
	public final void move(Vec2dDebugger distance) {
		topLeft = topLeft.plus(distance);
		bindToCanvas();
	}
	
	@Override
	public final Vec2dDebugger getCenter() {
		return getTopLeft().plus(size.sdiv(2));
	}
	
	@Override
	public void bindToCanvas() {
		Vec2dDebugger distance = new Vec2dDebugger(0);
		if(topLeft.x < 0) {
			distance = distance.plus(new Vec2dDebugger(-topLeft.x, 0));
		} else if(topLeft.x + size.x >= Display.getStageWidth()) {
			distance = distance.plus(new Vec2dDebugger(Display.getStageWidth() - topLeft.x - size.x, 0));
		}
		
		if(topLeft.y < 0) {
			distance = distance.plus(new Vec2dDebugger(0, -topLeft.y));
		} else if(topLeft.y + size.y >= Display.getStageHeight()) {
			distance = distance.plus(new Vec2dDebugger(0, Display.getStageHeight() - topLeft.y - size.y));
		}
		
		topLeft = topLeft.plus(distance);
	} 
	
	
	@Override
	public boolean atLeftEdge() {
		return topLeft.x <= 0;
	}

	@Override
	public boolean atTopEdge() {
		return topLeft.y <= 0;
	}
	
	@Override
	public boolean atRightEdge() {
		return topLeft.x + size.x >= Display.getStageWidth();
	}
	
	@Override
	public boolean atBottomEdge() {
		return topLeft.y + size.y >= Display.getStageHeight();
	}
	
}
