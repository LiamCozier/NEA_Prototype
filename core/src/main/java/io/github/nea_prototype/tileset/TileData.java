package io.github.nea_prototype.tileset;

import com.badlogic.gdx.math.Vector2;

public class TileData {
    private Vector2 position;
    private int id;


    public TileData(Vector2 position, int id) {
        this.position = position;
        this.id = id;
    }

    public int id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public Vector2 position() {
        return position;
    }

    public void set_position(Vector2 position) {
        this.position = position;
    }
}
