package debugger.support;

import java.util.ArrayList;
import java.util.Iterator;

import debugger.collisions.AABShape;
import debugger.collisions.CircleShape;
import debugger.collisions.PolygonShape;
import debugger.collisions.Ray;
import debugger.collisions.ShapeBuilder;
import debugger.collisions.Week2;
import debugger.collisions.Week3;
import debugger.collisions.Week5;
import debugger.collisions.Week6;
import debugger.support.interfaces.CollisionFunctions;
import debugger.support.shapes.AABShapeDefine;
import debugger.support.shapes.CircleShapeDefine;
import debugger.support.shapes.PolygonShapeDefine;
import debugger.support.shapes.Shape;
import javafx.application.Platform;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.ClosePath;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;

public class CollisionCanvas {
	
	private Pane _root;
	
	private AABShapeDefine[] _boxes;
	private Rectangle[] _boxesG;
	private CircleShapeDefine[] _circles;
	private Ellipse[] _circlesG;
	private PolygonShapeDefine[] _polygons;
	private Path[] _polygonsG;
	
	private boolean _leftMouseDown = false;
	private Vec2d _mousePos = new Vec2d(0, 0);
	private Shape _selected = null;
	private Shape _hovered = null;
	private Ray _ray = null;
	private Line _rayG;

	
	private CollisionFunctions _collisions;	
	private int _week;
	private ArrayList<Line> _mtvPool = new ArrayList<Line>();
	
	public CollisionCanvas() {
		_root = new Pane();
		
		_root.setOnMousePressed(e -> {
			mousePress(e.isPrimaryButtonDown());
		});
		_root.setOnMouseReleased(e -> {
			mousePress(e.isPrimaryButtonDown());
		});
		_root.setOnMouseMoved(e -> {
			mouseMoved(new Vec2d(e.getX(), e.getY()));
		});
		_root.setOnMouseDragged(e -> {
			mouseMoved(new Vec2d(e.getX(), e.getY()));
		});
		
		_boxes = ShapeBuilder.getBoxes();
		_boxesG = new Rectangle[_boxes.length];
		for(int i = 0; i < _boxes.length; i++) {
			_boxesG[i] = new Rectangle();
			_root.getChildren().add(_boxesG[i]);
		}
				
		_circles = ShapeBuilder.getCircles();
		_circlesG = new Ellipse[_circles.length];
		for(int i = 0; i < _circles.length; i++) {
			_circlesG[i] = new Ellipse();
			_root.getChildren().add(_circlesG[i]);
		}
		
		_polygons = ShapeBuilder.getPolygons();
		_polygonsG = new Path[_polygons.length];
		for(int i = 0; i < _polygons.length; i++) {
			_polygonsG[i] = new Path();
			_polygonsG[i].setFill(UIConstants.BLACK);
			_root.getChildren().add(_polygonsG[i]);
		}
		
		_rayG = new Line();
		_rayG.setVisible(false);
		_rayG.setStroke(UIConstants.MTV);
		_rayG.setStrokeWidth(2);
		_root.getChildren().add(_rayG);
		
		
		_week = Display.getDefaultWeek();
		switch(_week) {
		case(6):
			_collisions = new Week6();
			break;
		case(5):
			_collisions = new Week5();
			break;
		case(3):
			_collisions = new Week3();
			break;
		case(2):
		default:
			_collisions = new Week2();
			break;
		}
		
		reload();
		
	}
	
	public void mousePress(boolean b) {
		// left mouse released
		if(_leftMouseDown && !b) {
			// if there a ray, destroy it
			if(_ray != null) {
				_ray = null;
				_rayG.setVisible(false);
			
			// otherwise set the currently selected thing to be hovered
			} else {
				_hovered = _selected;
				_selected = null;
			}

			Display.setResizable(true);
		}
		
		// left mouse pressed
		if(!_leftMouseDown && b) {
			// if a ray is available (nothing is hovered and it's week6+),
			// draw the ray
			if(_hovered == null && _week >= 6) {
				_ray = new Ray(_mousePos, Vec2d.ORIGIN);
				
			// otherwise, select whatever's beneath the mouse
			} else {
				_selected = _hovered;
				_hovered = null;
			}

			Display.setResizable(false);
		}
		
		_leftMouseDown = b;
		reload();
	}
	
	public void mouseMoved(Vec2d p) {
		Vec2d src = _mousePos;
		Vec2d distance = p.minus(src);
		
		// if something is selected, move it
		if(_leftMouseDown && _selected != null) {
			if((p.x < 0 && _selected.atLeftEdge()) || (p.x > Display.getStageWidth() && _selected.atRightEdge()))
				distance = new Vec2d(0, distance.y);
			if((p.y < 0 && _selected.atTopEdge()) || (p.y > Display.getStageHeight() && _selected.atBottomEdge()))
				distance = new Vec2d(distance.x, 0);
			_selected.move(distance);
		
		// if there is a ray, update its direction
		} else if(_leftMouseDown && _ray != null) {
			_ray = new Ray(_ray.src, p.minus(_ray.src).normalize());	
			
		// otherwise, just check to see if we should be hovering anything
		} else if(!_leftMouseDown) {
			Vec2d mtv;
			_hovered = null;
			for(int i = 0; i < _boxes.length; i++) {
				mtv = _collisions.collision(_boxes[i], _mousePos);
				if(mtv != null) _hovered = _boxes[i];
			}
			for(int i = 0; i < _circles.length; i++) {
				mtv = _collisions.collision(_circles[i], _mousePos);
				if(mtv != null) _hovered = _circles[i];
			}
			for(int i = 0; i < _polygons.length; i++) {
				mtv = _collisions.collision(_polygons[i], _mousePos);
				if(mtv != null) _hovered = _polygons[i];
			}
		}
		_mousePos = p;
		reload();

	}
	
	public void onKeyPressed(KeyEvent e) {
		switch(e.getCode()) {
		case DIGIT2:
		case NUMPAD2:
			_week = 2;
			break;
		case DIGIT3:
		case NUMPAD3:
			_week = 3;
		case DIGIT5:
		case NUMPAD5:
			_week = 5;
			break;
		case DIGIT6:
		case NUMPAD6:
			_week = 6;
			break;
		case LEFT:
			if(_week == 6) {
				_week = 5;
			} else if(_week == 5) {
				_week = 3;
			} else {
				_week = 2;
			}
			break;
		case RIGHT:
			if(_week == 2) {
				_week = 3;
			} else if(_week == 3) {
				_week = 5;
			} else {
				_week = 6;
			}
			break;
		case SPACE:
			_week = Display.getDefaultWeek();
			break;
		default:
			break;
		}
		switch(_week) {
		case(6):
			_collisions = new Week6();
			break;
		case(5):
			_collisions = new Week5();
			break;
		case(3):
			_collisions = new Week3();
			break;
		case(2):
		default:
			_collisions = new Week2();
			break;
		}
		Display.setTitle("Week " + Integer.toString(_week));
		reload();
	}
	
	public Pane getRoot() {
		return _root;
	}
	
	public void rebind() {
		for(int i = 0; i < _boxes.length; i++) {
			_boxes[i].bindToCanvas();
		}
		
		for(int i = 0; i < _circles.length; i++) {
			_circles[i].bindToCanvas();
		}
		
		for(int i = 0; i < _polygons.length; i++) {
			_polygons[i].bindToCanvas();
		}
		
		reload();
	}
	
	public void reload() {
		loadRectangles();
		loadCircles();
		loadPolygons();
		raycast();
	}
	
	public void loadRectangles() {
		Rectangle r; AABShape a;
		for(int i = 0; i < _boxes.length; i++) {
			r = _boxesG[i];
			a = _boxes[i];
			r.setX(a.getTopLeft().x);
			r.setY(a.getTopLeft().y);
			r.setWidth(a.getSize().x);
			r.setHeight(a.getSize().y);
			r.setStroke(UIConstants.BLACK);
			r.setStrokeWidth(2);
			runRectangleCollisions(i);
		}
	}
	
	// sets the color of the given rectangle and draws its MTV
	public void runRectangleCollisions(int i) {
		boolean mouse = _leftMouseDown ? (_boxes[i] == _selected) : (_boxes[i] == _hovered);
		
		Vec2d mtv;
		resetMTVs(_boxes[i]);

		boolean collision = false;
		for(int r = 0; r < _boxes.length; r++) {
			if(r != i) {
				mtv = _collisions.collision(_boxes[i], _boxes[r]);
				if(mtv != null) {
					collision = true;
					_boxes[i].addMTV(getLine(), mtv);
				}
			}
		}	
		for(int e = 0; e < _circles.length; e++) {
			mtv = _collisions.collision(_boxes[i], _circles[e]);
			if(mtv != null) {
				collision = true;
				_boxes[i].addMTV(getLine(), mtv);
			}
		}
		for(int p = 0; p < _polygons.length; p++) {
			mtv = _collisions.collision(_boxes[i], _polygons[p]);
			if(mtv != null) {
				collision = true;
				_boxes[i].addMTV(getLine(), mtv);
			}
		}
		
		Color c = UIConstants.BLACK;
		if(collision) {
			c = UIConstants.COLLIDING;
		} else if(mouse) {
			c = _leftMouseDown ? UIConstants.SELECTED : UIConstants.HOVERED;
		}
		
		_boxesG[i].setFill(c);
		
	}
	
	public void loadCircles() {
		Ellipse e; CircleShape c;
		for(int i = 0; i < _circles.length; i++) {
			e = _circlesG[i];
			c = _circles[i];
			e.setCenterX(c.getCenter().x);
			e.setCenterY(c.getCenter().y);
			e.setRadiusX(c.getRadius());
			e.setRadiusY(c.getRadius());
			e.setStroke(UIConstants.BLACK);
			e.setStrokeWidth(2);
			runCircleCollisions(i);

		}
	}
	
	// sets the color of the given circle and draws its MTV
	public void runCircleCollisions(int i) {
		boolean mouse = _leftMouseDown ? (_circles[i] == _selected) : (_circles[i] == _hovered);
		
		Vec2d mtv;
		resetMTVs(_circles[i]);
		
		boolean collision = false;
		for(int r = 0; r < _boxes.length; r++) {
			mtv = _collisions.collision(_circles[i], _boxes[r]);
			if(mtv != null) {
				collision = true;
				_circles[i].addMTV(getLine(), mtv);
			}
		}
		for(int e = 0; e < _circles.length; e++) {	
			if(e != i) {
				mtv = _collisions.collision(_circles[i], _circles[e]);
				if(mtv != null) {
					collision = true;
					_circles[i].addMTV(getLine(), mtv);
				}
			}
		}
		for(int p = 0; p < _polygons.length; p++) {
			mtv = _collisions.collision(_circles[i], _polygons[p]);
			if(mtv != null) {
				collision = true;
				_circles[i].addMTV(getLine(), mtv);
			}
		}
		
		Color c = UIConstants.BLACK;
		if(collision) {
			c = UIConstants.COLLIDING;
		} else if(mouse) {
			c = _leftMouseDown ? UIConstants.SELECTED : UIConstants.HOVERED;
		}
		
		_circlesG[i].setFill(c);
		
	}
	
	public void loadPolygons() {
		Path p; PolygonShape s;
		for(int i = 0; i < _polygons.length; i++) {
			p = _polygonsG[i];
			s = _polygons[i];
			
			p.getElements().clear();
			int numPoints = s.getNumPoints();
			if(numPoints >= 1) {
				p.getElements().add(new MoveTo(s.getPoint(0).x, s.getPoint(0).y));
			}
			for(int j = 1; j < numPoints; j++) {
				p.getElements().add(new LineTo(s.getPoint(j).x, s.getPoint(j).y));
			}
			p.getElements().add(new ClosePath());
			
			
			p.setStroke(UIConstants.BLACK);
			p.setStrokeWidth(2);
			runPolygonCollisions(i);

		}
	}
	
	// sets the color of the given circle and draws its MTV
	public void runPolygonCollisions(int i) {
		boolean mouse = _leftMouseDown ? (_polygons[i] == _selected) : (_polygons[i] == _hovered);
		
		Vec2d mtv;
		resetMTVs(_polygons[i]);
		
		boolean collision = false;
		for(int r = 0; r < _boxes.length; r++) {
			mtv = _collisions.collision(_polygons[i], _boxes[r]);
			if(mtv != null) {
				collision = true;
				_polygons[i].addMTV(getLine(), mtv);
			}
		}
		for(int e = 0; e < _circles.length; e++) {	
			mtv = _collisions.collision(_polygons[i], _circles[e]);
			if(mtv != null) {
				collision = true;
				_polygons[i].addMTV(getLine(), mtv);
			}
		}
		for(int p = 0; p < _polygons.length; p++) {
			if(p != i) {
				mtv = _collisions.collision(_polygons[i], _polygons[p]);
				if(mtv != null) {
					collision = true;
					_polygons[i].addMTV(getLine(), mtv);
				}
			}
		}
		
		Color c = UIConstants.BLACK;
		if(collision) {
			c = UIConstants.COLLIDING;
		} else if(mouse) {
			c = _leftMouseDown ? UIConstants.SELECTED : UIConstants.HOVERED;
		}
		
		_polygonsG[i].setFill(c);
		
	}
	
	public void raycast() {
		if(_ray != null) {
			if(_ray.dir.isZero()) {
				_rayG.setVisible(false);
				return;
			}
			
			_rayG.setVisible(true);
			_rayG.setStartX(_ray.src.x);
			_rayG.setStartY(_ray.src.y);
			double xLo = raycastEdge(_ray, true, true);
			double xHi = raycastEdge(_ray, true, false);
			double yLo = raycastEdge(_ray, false, true);
			double yHi = raycastEdge(_ray, false, false);
			// max is intentional- for edge testing, we don't care if we go past the edge, min only matters
			// for shape testing
			double minT = Double.max(Double.max(xLo, xHi), Double.max(yLo, yHi)) + 1;
			double t;
			
			for(int i = 0; i < _boxes.length; i++) {
				t = _collisions.raycast(_boxes[i], _ray);
				if(t > 0 && t < minT) minT = t;
			}
			for(int i = 0; i < _circles.length; i++) {
				t = _collisions.raycast(_circles[i], _ray);
				if(t > 0 && t < minT) minT = t;
			}
			for(int i = 0; i < _polygons.length; i++) {
				t = _collisions.raycast(_polygons[i], _ray);
				if(t > 0 && t < minT) minT = t;
			}
			
			Vec2d end = _ray.src.plus(_ray.dir.smult(minT));
			_rayG.setEndX(end.x);
			_rayG.setEndY(end.y);
			
		}
	}
	
	private double raycastEdge(Ray r, boolean x, boolean lo) {
		double a = x ? r.dir.x : r.dir.y;
		double b;
		if(x) {
			b = lo ? -r.src.x : Display.getStageWidth() - r.src.x;
		} else {
			b = lo ? -r.src.y : Display.getStageHeight() - r.src.y;
		}
		
		return a == 0 ? -1 : b / a;
	}
	
	
	
	// returns all stored lines to the line pool
	public void resetMTVs(Shape s) {
		Iterator<Line> iter = s.getMTVs();
		Line line;
		while(iter.hasNext()) {
			line = iter.next();
			if(!_mtvPool.contains(line)) {
				line.setVisible(false);
				_mtvPool.add(line);
			}
		}
		s.clearMTVs();
	}
	
	public Line getLine() {
		Line output;
		
		if(_mtvPool.size() > 0) {
			output = _mtvPool.get(_mtvPool.size() - 1);
			_mtvPool.remove(_mtvPool.size() - 1);
			output.setVisible(true);
			
		} else {
			output = new Line();
			output.setStroke(UIConstants.MTV);
			output.setStrokeWidth(3);
			Platform.runLater(() -> {
				_root.getChildren().add(output);
			});			
		}
		
		return output;

	}
	
	

}
