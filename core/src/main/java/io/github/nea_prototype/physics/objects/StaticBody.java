package io.github.nea_prototype.physics.objects;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.Hitbox;

public class StaticBody extends PhysicsObject {

    public StaticBody(Hitbox hitbox, Vector2 position) {
        super(hitbox, position, new Vector2(0, 0));
    }

    @Override
    public void step(float deltaT) {}
}
