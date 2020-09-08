package debugger.support.shapes;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.shape.Line;
import debugger.support.Vec2d;

public abstract class Shape {

	private ArrayList<Line> _mtvs = new ArrayList<Line>();
	
	public abstract void move(Vec2d distance);
	public abstract Vec2d getCenter();
	
	public abstract boolean atLeftEdge();
	public abstract boolean atTopEdge();
	public abstract boolean atRightEdge();
	public abstract boolean atBottomEdge();
	public abstract void bindToCanvas();
	
	public Iterator<Line> getMTVs() {
		return _mtvs.iterator();
	}
	
	public void clearMTVs() {
		_mtvs.clear();
	}
	
	public void addMTV(Line line, Vec2d mtv) {
		Vec2d start = getCenter();
		line.setStartX(start.x);
		line.setStartY(start.y);
		
		Vec2d end = start.plus(mtv);
		line.setEndX(end.x);
		line.setEndY(end.y);
		
		_mtvs.add(line);
	}
	
}
