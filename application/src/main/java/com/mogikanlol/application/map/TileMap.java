package com.mogikanlol.application.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mogikanlol.application.Constants;

import java.util.ArrayList;
import java.util.List;

public class TileMap {

    private final Texture texture;
    private final SpriteBatch spriteBatch;

    private List<Tile> tiles;

    public TileMap(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        this.texture = new Texture(Gdx.files.internal("ayaya.jpg"));
        tiles = new ArrayList<>();

        for (int i = 0; i < Constants.WINDOW_WIDTH; i+= Constants.TILE_WIDTH) {
            tiles.add(new Tile(i, 0));
        }
        for (int i = 0; i < 4; i++) {
            tiles.add(new Tile((i * Constants.TILE_WIDTH), 3 * Constants.TILE_HEIGHT));
        }

        for (int i = 0; i < 4; i++) {
            tiles.add(new Tile(11 * Constants.TILE_WIDTH + (i * Constants.TILE_WIDTH), 8 * Constants.TILE_HEIGHT));
        }
        tiles.add(new Tile(6 * Constants.TILE_WIDTH, 6 * Constants.TILE_HEIGHT));
    }

    public void draw() {
        spriteBatch.begin();

        for (Tile tile : tiles) {
            spriteBatch.draw(texture, tile.getX(), tile.getY(), tile.getWidth(), tile.getHeight());
        }

        spriteBatch.end();
    }

    public List<Tile> getTiles() {
        return tiles;
    }
}
