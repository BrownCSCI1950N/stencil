package debugger.support.visual;

import java.util.ArrayList;
import java.util.Iterator;

import javafx.scene.shape.Line;
import debugger.support.Vec2dDebugger;

public abstract class DebuggerShape {

	private ArrayList<Line> _mtvs = new ArrayList<Line>();
	
	public abstract void move(Vec2dDebugger distance);
	public abstract Vec2dDebugger getCenter();
	
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
	
	public void addMTV(Line line, Vec2dDebugger mtv) {
		Vec2dDebugger start = getCenter();
		line.setStartX(start.x);
		line.setStartY(start.y);
		
		Vec2dDebugger end = start.plus(mtv);
		line.setEndX(end.x);
		line.setEndY(end.y);
		
		_mtvs.add(line);
	}
	
}
