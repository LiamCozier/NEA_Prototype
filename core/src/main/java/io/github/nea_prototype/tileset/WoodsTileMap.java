package io.github.nea_prototype.tileset;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;

public class WoodsTileMap extends TileMap {

    public WoodsTileMap() {
        super(
            new Texture("woods_tileset_atlas.png"),
            24, 24
        );
    }

    @Override
    protected Vector2[] init_tile_atlas_positions() {
        return new Vector2[] {
            new Vector2(3, 3),
            new Vector2(0, 3),
            new Vector2(1, 3),
            new Vector2(2, 3)
        };
    }
}
