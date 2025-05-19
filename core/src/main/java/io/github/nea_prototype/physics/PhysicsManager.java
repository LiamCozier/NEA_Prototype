package io.github.nea_prototype.physics;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.BoundingBox;
import io.github.nea_prototype.physics.objects.PhysicsObject;

public class PhysicsManager {

    public static boolean AABB_overlap(PhysicsObject o1, PhysicsObject o2) {
        BoundingBox raw1 = o1.shape().get_bounding_box();
        BoundingBox raw2 = o2.shape().get_bounding_box();

        Vector2 shift1 = o1.position();
        Vector2 shift2 = o2.position();

        BoundingBox bb1 = new BoundingBox(
            raw1.corner1().add(shift1),
            raw1.corner2().add(shift1)
        );

        BoundingBox bb2 = new BoundingBox(
            raw2.corner1().add(shift2),
            raw2.corner2().add(shift2)
        );

        return (bb1.corner1().x <= bb2.corner2().x && bb1.corner2().x >= bb2.corner1().x &&
            bb1.corner1().y <= bb2.corner2().y && bb1.corner2().y >= bb2.corner1().y);
    }


}
