package io.github.nea_prototype.physics.hitboxes;

import com.badlogic.gdx.math.Vector2;

public class BoundingBox {
    Vector2 corner1, corner2;

    public BoundingBox(float x1, float y1, float x2, float y2) {
         corner1 = new Vector2(
             Math.min(x1, x2),
             Math.min(y1, y2)
         );
         corner2 = new Vector2(
             Math.max(x1, x2),
             Math.max(y1, y2)
         );
    }

    public BoundingBox(Vector2 v1, Vector2 v2) {
        corner1 = new Vector2(
            Math.min(v1.x, v2.x),
            Math.min(v1.y, v2.y)
        );
        corner2 = new Vector2(
            Math.max(v1.x, v2.x),
            Math.max(v1.y, v2.y)
        );
    }

    public Vector2 corner1() {
        return corner1;
    }

    public void set_corner1(Vector2 corner1) {
        this.corner1 = corner1;
    }

    public Vector2 corner2() {
        return corner2;
    }

    public void set_corner2(Vector2 corner2) {
        this.corner2 = corner2;
    }
}
