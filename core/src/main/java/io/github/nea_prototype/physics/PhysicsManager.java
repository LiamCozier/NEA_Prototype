package io.github.nea_prototype.physics;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.BoundingBox;
import io.github.nea_prototype.physics.objects.PhysicsObject;

import java.util.WeakHashMap;

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

    public static boolean separating_axis_overlap(PhysicsObject o1, PhysicsObject o2) {
        float[] raw1 = o1.shape().get_polygon();
        float[] raw2 = o2.shape().get_polygon();

        Vector2 shift1 = o1.position();
        Vector2 shift2 = o2.position();

        float[] poly1 = new float[raw1.length];
        float[] poly2 = new float[raw2.length];

        for (int i=0; i<poly1.length; i+=2) {
            poly1[i] = raw1[i] + shift1.x;
            poly1[i+1] = raw1[i+1] + shift1.y;
        }

        for (int i=0; i<poly2.length; i+=2) {
            poly2[i] = raw2[i] + shift2.x;
            poly2[i+1] = raw2[i+1] + shift2.y;
        }

        Line[] normals = new Line[(poly1.length + poly2.length)/2];
        for (int i=0; i<poly1.length; i+=2) {
            Vector2 p1 = new Vector2(poly1[i], poly1[i+1]);
            Vector2 p2 = new Vector2(poly1[(i+2) % poly1.length], poly1[(i+3) % poly1.length]);


            poly1[i+1] = raw1[i+1] + shift1.y;
        }

        for (int i=0; i<poly2.length; i+=2) {
            poly2[i] = raw2[i] + shift2.x;
            poly2[i+1] = raw2[i+1] + shift2.y;
        }

        return false;
    }
}
