package io.github.nea_prototype.physics.hitboxes;

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
    public float[] get_polygon() {
        return new float[] {
            0, 0,
            0, height,
            width, height,
            width, 0
        };
    }

    @Override
    public BoundingBox get_bounding_box() {
        return new BoundingBox(0, 0, width, height);
    }
}
