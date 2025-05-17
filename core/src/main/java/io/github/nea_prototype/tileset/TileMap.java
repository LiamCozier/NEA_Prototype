package io.github.nea_prototype.tileset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class TileMap {
    protected Texture texture_atlas;
    protected int tile_width;
    protected int tile_height;
    protected Vector2[] tile_atlas_positions;

    public TileMap(Texture texture_atlas, int tile_width, int tile_height) {
        this.texture_atlas = texture_atlas;
        this.tile_width = tile_width;
        this.tile_height = tile_height;
        this.tile_atlas_positions = init_tile_atlas_positions();
    }

    public int tile_width() {
        return tile_width;
    }

    public void set_tile_width(int tile_width) {
        this.tile_width = tile_width;
    }

    public int tile_height() {
        return tile_height;
    }

    public void set_tile_height(int tile_height) {
        this.tile_height = tile_height;
    }

    protected abstract Vector2[] init_tile_atlas_positions();

    public Vector2 get_tile_atlas_position(int tile_id) {
        return tile_atlas_positions[tile_id];
    }

}
