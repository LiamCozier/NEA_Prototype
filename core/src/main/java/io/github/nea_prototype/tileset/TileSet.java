package io.github.nea_prototype.tileset;


import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;

public class TileSet {

    Vector2 position;
    TileMap map;
    List<TileData> tile_list;

    public TileSet(Vector2 position, TileMap map) {
        this.position = position;
        this.map = map;
        this.tile_list = new ArrayList<TileData>(0);
    }

    public void add_tile(Vector2 position, int id) {
        this.tile_list.add(new TileData(position, id));
    }

    public void add_tile(TileData data) {
        this.tile_list.add(data);
    }

    private Vector2 get_world_position(TileData data) {
        Vector2 tile_position = new Vector2(data.position());
        tile_position.add(this.position);
        return tile_position;
    }

    public void render(SpriteBatch batch) {
        for (TileData data: tile_list) {

            Vector2 world_position = get_world_position(data);
            Vector2 atlas_position = map.get_tile_atlas_position(data.id());
            int width = map.tile_width, height = map.tile_height;

            batch.draw(
                map.texture_atlas,
                world_position.x, world_position.y, // World space position
                1, 1, // Game distance units
                (int) atlas_position.x * width, (int) atlas_position.y * height, // Source position (px)
                width, height, // Source dimensions
                false, false // Flip x, y
            );
        }
    }


}
