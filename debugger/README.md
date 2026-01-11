# Collision Debugger

Use this visual debugging tool for testing and verifying collision detection implementations before implementing into your engine. 
Filling out the debugger is required as part of your projects.

## Getting Started

### Running the Debugger

1. Open `debugger/Main.java`
2. Set the week number, e.g ```Display.setWeek(2);```
3. Run `Main.java`

**Tip:** You can also use the **left/right arrow keys** while running to cycle between weeks.

---

## Debugger assignments

Projects which implement collisions each have a corresponding week in the debugger to complete. Each week builds upon the previous week's work.

### Week 2 (ALC 2) - Collision Detection (Boolean)

Implement `isColliding()` methods that return `true` if two shapes are colliding, `false` otherwise.

### Week 3 (WIZ 1) - Collision MTVs

Implement `collision()` methods that return the **Minimum Translation Vector (MTV)** (or `null` if not colliding).

### Week 5 (NIN 1) - Polygon Collisions

Implement **Polygon** `collision()` methods that return the MTV (or `null` if not colliding)

### Week 6 (NIN 2) - Raycasting

Implement `raycast()` methods that return the distance (float) along the ray where it first intersects a shape, or `-1` if no intersection:

## Visual Feedback

The debugger displays:
- **Black shapes** - Default shape state (no collision)
- **Red shapes** - Collision detected
- **Orange arrows** - MTV or collision vectors (Weeks 3+)
- **Ray visualization** - Ray direction and hit points (Week 6). Click and drag anywhere to create a ray.

Drag shapes around to test different collision scenarios. You must first implement the corresponding `collision(Shape, Vec2dDebugger)` method(s) to allow for mouse interaction with the shapes

---

## Notes

- Make sure MTV points outward from the shapes. If the shape were translated by the MTV, it should be no longer colliding
- Some symmetric methods (e.g., `collision(CircleDebugger, AABDebugger)`) are already implemented using reflection
