package debugger.support.shapes;

import debugger.collisions.PolygonShape;
import debugger.support.Display;
import debugger.support.Vec2d;

public class PolygonShapeDefine extends PolygonShape {
	
	Vec2d min;
	Vec2d max;

	public PolygonShapeDefine(Vec2d ... points) {
		super(points);
		double minX = Double.MAX_VALUE, minY = Double.MAX_VALUE, maxX = 0, maxY = 0;
		for(Vec2d v : points) {
			minX = Double.min(minX, v.x);
			minY = Double.min(minY, v.y);
			maxX = Double.max(maxX, v.x);
			maxY = Double.max(maxY, v.y);
		}
		min = new Vec2d(minX, minY);
		max = new Vec2d(maxX, maxY);
	}
	
	@Override
	public void move(Vec2d distance) {
		for(int i = 0; i < points.length; i++) {
			points[i] = points[i].plus(distance);
		}
		min = min.plus(distance);
		max = max.plus(distance);
		bindToCanvas();
	}
	
	@Override
	public void bindToCanvas() {
		Vec2d distance = new Vec2d(0);
		if(min.x < 0) {
			distance = distance.plus(new Vec2d(-min.x, 0));
		} else if(max.x >= Display.getStageWidth()) {
			distance = distance.plus(new Vec2d(Display.getStageWidth() - max.x, 0));
		}
		
		if(min.y < 0) {
			distance = distance.plus(new Vec2d(0, -min.y));
		} else if(max.y >= Display.getStageHeight()) {
			distance = distance.plus(new Vec2d(0, Display.getStageHeight() - max.y));
		}
		
		for(int i = 0; i < points.length; i++) {
			points[i] = points[i].plus(distance);
		}
		min = min.plus(distance);
		max = max.plus(distance);
	}

	@Override
	public Vec2d getCenter() {
		return min.plus(max).sdiv(2);
	}

	@Override
	public boolean atLeftEdge() {
		return min.x <= 0;
	}

	@Override
	public boolean atTopEdge() {
		return min.y <= 0;
	}

	@Override
	public boolean atRightEdge() {
		return max.x >= Display.getStageWidth();
	}

	@Override
	public boolean atBottomEdge() {
		return max.y >= Display.getStageHeight();
	}

}
