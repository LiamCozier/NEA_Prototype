package io.github.nea_prototype;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.ScreenUtils;

import io.github.nea_prototype.physics.RigidBody;
import io.github.nea_prototype.tileset.*;

public class Game {

    OrthographicCamera camera;
    SpriteBatch batch;
    TileSet tile_set;


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
    }

    public void physics_process(float deltaT) {

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
