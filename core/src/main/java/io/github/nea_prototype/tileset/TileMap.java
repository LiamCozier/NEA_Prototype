package io.github.nea_prototype.tileset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public abstract class TileMap {
    protected Texture texture_atlas;
    protected int atlas_width = 11, atlas_height = 5;
    protected int tile_width;
    protected int tile_height;

    public TileMap(Texture texture_atlas, int tile_width, int tile_height) {
        this.texture_atlas = texture_atlas;
        this.tile_width = tile_width;
        this.tile_height = tile_height;;
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


    public Vector2 get_tile_atlas_position(int tile_id) {
        return new Vector2(tile_id % atlas_width, tile_id / atlas_width);
    }

}
