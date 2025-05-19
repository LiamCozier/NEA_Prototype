package io.github.nea_prototype.physics.objects;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.Hitbox;

public abstract class PhysicsObject {
    protected Vector2 position;
    protected Vector2 velocity;
    protected Hitbox hitbox;

    public PhysicsObject(Hitbox hitbox, Vector2 position, Vector2 velocity) {
        this.hitbox = hitbox;
        this.position = position;
        this.velocity = velocity;
    }

    public Hitbox shape() {
        return hitbox;
    }

    public Vector2 velocity() {
        return velocity;
    }

    public void set_velocity(Vector2 velocity) {
        this.velocity = velocity;
    }

    public Vector2 position() {
        return position;
    }

    public void set_position(Vector2 position) {
        this.position = position;
    }

    // Physics step
    public abstract void step(float deltaT);
}
