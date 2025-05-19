package io.github.nea_prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.nea_prototype.physics.PhysicsManager;
import io.github.nea_prototype.physics.hitboxes.RectHitbox;
import io.github.nea_prototype.physics.objects.PhysicsObject;
import io.github.nea_prototype.physics.objects.RigidBody;
import io.github.nea_prototype.physics.objects.StaticBody;
import io.github.nea_prototype.tileset.*;


public class Game {

    OrthographicCamera camera;
    SpriteBatch batch;
    TileSet tile_set;

    RigidBody box = new RigidBody(new RectHitbox(1, 1), new Vector2(0, 0), new Vector2(1, 10));
    StaticBody platform = new StaticBody(new RectHitbox(5, 1), new Vector2(2, 0));

    public Game() {

        // init camera
        float height = 10;
        float ppu = Gdx.graphics.getHeight() / height;
        float width = Gdx.graphics.getWidth() / ppu;
        camera = new OrthographicCamera(width, height);

        // init sprite batch
        batch = new SpriteBatch();

        // init tileset
        tile_set = new TileSet(new Vector2(0, 0), new WoodsTileMap());
        tile_set.import_tile_chunk("TileSets/something.csv");
    }

    public void take_input() {camera_input();}

    public void render(float deltaT) {
        ScreenUtils.clear(Color.BLACK);

        batch.setProjectionMatrix(camera.combined);
        batch.begin();
        tile_set.render(batch);
        batch.end();

        ShapeRenderer sr = new ShapeRenderer();
        sr.setColor(Color.WHITE);
        sr.setProjectionMatrix(camera.combined);
        sr.begin(ShapeRenderer.ShapeType.Line);
        if (PhysicsManager.separating_axis_overlap(box, platform)) {
            sr.setColor(Color.LIME);
        }
        render_poly(box, sr);
        render_poly(platform, sr);
        sr.end();

    }

    public void render_poly(PhysicsObject o, ShapeRenderer sr) {
        Vector2[] vec_poly = o.shape().get_polygon();
        float[] poly = new float[vec_poly.length * 2];
        for (int i = 0; i < vec_poly.length; i++) {
            poly[2 * i] = vec_poly[i].x + o.position().x;
            poly[2 * i + 1] = vec_poly[i].y + o.position().y;
        }
        sr.polygon(poly);
    }

    public void physics_process(float deltaT) {
        box.step(deltaT);
    }

    //temp
    public void camera_input() {
        if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
            camera.translate(0, 0.25f);
            camera.update();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
            camera.translate(0, -0.25f);
            camera.update();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
            camera.translate(-0.25f, 0);
            camera.update();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
            camera.translate(0.25f, 0);
            camera.update();
        }
    }
}
