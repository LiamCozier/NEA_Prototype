package io.github.nea_prototype.tileset;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public void import_tile_chunk(String file_name) {

        // Read file
        List<String[]> tile_chunk_list = new ArrayList<>(0);
        try {
            FileHandle tile_file = Gdx.files.internal(file_name);
            Scanner scan = new Scanner(tile_file.read());
            while (scan.hasNextLine()) {
                String data = scan.nextLine();
                // List of arrays of strings
                tile_chunk_list.add(data.split(","));
            }
            scan.close();
        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        String[][] tile_chunk = new String[tile_chunk_list.size()][];
        for (int i=0; i<tile_chunk_list.size(); i++) {
            tile_chunk[i] = tile_chunk_list.get(i);
        }

        for (int i=0; i<tile_chunk.length; i++) {
            for (int j=0; j<tile_chunk[0].length; j++) {
                int id = Integer.parseInt(tile_chunk[i][j]);

                // empty tile
                if (id == -1) {
                    continue;
                }

                this.add_tile(
                    new Vector2(j, tile_chunk.length-i), id);
            }
        }

    }
}
