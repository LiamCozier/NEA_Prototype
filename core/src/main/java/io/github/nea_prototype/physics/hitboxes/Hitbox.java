package io.github.nea_prototype.physics.hitboxes;

import com.badlogic.gdx.math.Vector2;

public abstract class Hitbox {

    public abstract Vector2[] get_polygon();
    public abstract BoundingBox get_bounding_box();

}
