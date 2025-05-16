package io.github.nea_prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;
import org.w3c.dom.css.RGBColor;

public class Game {

    Camera c;
    ShapeRenderer sr;

    public Game() {
        c = new Camera(new Vector2(0, 10));
        sr = new ShapeRenderer();
    }

    public void take_input() {
        c.take_input();
    }

    public void render(float deltaT) {
        ScreenUtils.clear(Color.BLACK);
        Vector2 pos = c.world_to_camera_space(Vector2.Zero);

        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.circle(pos.x, pos.y, 5);
        sr.end();

    }

}
