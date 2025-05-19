package io.github.nea_prototype.tileset;

import com.badlogic.gdx.graphics.Texture;

public class WoodsTileMap extends TileMap {

    public WoodsTileMap() {
        super(
            new Texture("woods_tileset_atlas.png"),
            24, 24
        );
    }

}
