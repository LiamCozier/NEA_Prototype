package io.github.nea_prototype.physics.objects;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.Hitbox;

public class RigidBody extends PhysicsObject {


    public RigidBody(Hitbox hitbox, Vector2 position, Vector2 velocity) {
        super(hitbox, position, velocity);
    }

    @Override
    public void step(float deltaT) {

        velocity.mulAdd(new Vector2(0, -9.81f), deltaT);
        position.mulAdd(velocity, deltaT);
    }
}
