package io.github.nea_prototype.physics.hitboxes;

import com.badlogic.gdx.math.Vector2;

public class RectHitbox extends Hitbox {
    private float width;
    private float height;


    public RectHitbox(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public float width() {
        return width;
    }

    public void set_width(float width) {
        this.width = width;
    }

    public float height() {
        return height;
    }

    public void set_height(float height) {
        this.height = height;
    }

    @Override
    public Vector2[] get_polygon() {
        return new Vector2[] {
            new Vector2(0, 0),
            new Vector2(0, height),
            new Vector2(width, height),
            new Vector2(width, 0)
        };
    }

    @Override
    public BoundingBox get_bounding_box() {
        return new BoundingBox(0, 0, width, height);
    }
}
