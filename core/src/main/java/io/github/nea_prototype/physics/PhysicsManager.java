package io.github.nea_prototype.physics;

import com.badlogic.gdx.math.Vector2;
import io.github.nea_prototype.physics.hitboxes.BoundingBox;
import io.github.nea_prototype.physics.objects.PhysicsObject;

import java.util.ArrayList;
import java.util.List;
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
        Vector2[] poly1 = extract_translated_polygon(o1.shape().get_polygon(), o1.position());
        Vector2[] poly2 = extract_translated_polygon(o2.shape().get_polygon(), o2.position());

        List<Vector2> axes = new ArrayList<>();
        axes.addAll(get_normals(poly1));
        axes.addAll(get_normals(poly2));

        for (Vector2 axis : axes) {
            float[] proj1 = project(poly1, axis);
            float[] proj2 = project(poly2, axis);

            if (proj1[1] < proj2[0] || proj2[1] < proj1[0]) {
                return false; // Found a separating axis
            }
        }

        return true;
    }

    private static Vector2[] extract_translated_polygon(Vector2[] polygon, Vector2 position) {
        Vector2[] translated_polygon = new Vector2[polygon.length];
        for (int i = 0; i<polygon.length; i++) {
            translated_polygon[i] = new Vector2(polygon[i]);
            translated_polygon[i].add(position);
        }
        return translated_polygon;
    }

    private static List<Vector2> get_normals(Vector2[] polygon) {
        List<Vector2> axes = new ArrayList<>();
        for (int i = 0; i < polygon.length; i++) {
            Vector2 p1 = polygon[i];
            Vector2 p2 = polygon[(i + 1) % polygon.length];

            Vector2 edge = new Vector2(p2).sub(p1);
            Vector2 normal = new Vector2(-edge.y, edge.x).nor(); // Perpendicular
            axes.add(normal);
        }
        return axes;
    }

    private static float[] project(Vector2[] poly, Vector2 axis) {
        float min = axis.dot(poly[0]);
        float max = min;
        for (int i = 1; i < poly.length; i++) {
            float proj = axis.dot(poly[i]);
            if (proj < min) min = proj;
            if (proj > max) max = proj;
        }
        return new float[]{min, max};
    }



}
