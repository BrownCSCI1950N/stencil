package debugger.support.shapes;

import debugger.collisions.CircleShape;
import debugger.support.Display;
import debugger.support.Vec2d;

public class CircleShapeDefine extends CircleShape {
	
	public CircleShapeDefine(Vec2d center, float radius) {
		super(center, radius);
	}

	@Override
	public void move(Vec2d distance) {
		center = center.plus(distance);
		bindToCanvas();
	}
	
	@Override
	public void bindToCanvas() {
		Vec2d distance = new Vec2d(0);
		if(center.x - radius < 0) {
			distance = distance.plus(new Vec2d(radius - center.x, 0));
		} else if(center.x + radius >= Display.getStageWidth()) {
			distance = distance.plus(new Vec2d(Display.getStageWidth() - center.x - radius, 0));
		}
		
		if(center.y - radius < 0) {
			distance = distance.plus(new Vec2d(0, radius - center.y));
		} else if(center.y + radius >= Display.getStageHeight()) {
			distance = distance.plus(new Vec2d(0, Display.getStageHeight() - center.y - radius));
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
