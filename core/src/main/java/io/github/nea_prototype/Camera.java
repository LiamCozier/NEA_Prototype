package io.github.nea_prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.math.Vector2;

public class Camera {

    private static final int move_speed = 10;
    private Vector2 position;

    public Camera() {
        this.position = Vector2.Zero;
    }

    public Camera(Vector2 position) {
        this.position = position;
    }

    public Vector2 get_position() {
        return position;
    }

    public void set_position(Vector2 position) {
        this.position = position;
    }

    public Vector2 world_to_camera_space(Vector2 world_position) {
        Vector2 screen_centre = new Vector2(
            (float) Gdx.graphics.getWidth()  / 2,
            (float) Gdx.graphics.getHeight() / 2
        );
        // copy world position
        Vector2 result_position = new Vector2(world_position);

        // transform according to camera's position
        result_position.add(world_position);
        result_position.add(screen_centre);
        result_position.sub(this.position);

        return result_position;
    }

    public void take_input() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            this.position.y +=  move_speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            this.position.y += -move_speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            this.position.x +=  move_speed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            this.position.x += -move_speed;
        }
    };

}
