package com.mogikanlol.application.editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mogikanlol.application.Constants;

public class Grid {

    private final Camera camera;

    public Grid(Camera camera) {
        this.camera = camera;
    }

    public void draw(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Line);
        sr.setColor(Color.BLACK);

        // draw vertical lines
        int startX = (camera.getX() / Constants.TILE_WIDTH) * Constants.TILE_WIDTH - camera.getX();
        for (int x = startX; x < Constants.WINDOW_WIDTH; x += Constants.TILE_WIDTH) {
            sr.line(x, 0, x, Constants.WINDOW_HEIGHT);
        }

        // draw horizontal lines
        int startY = (camera.getY() / Constants.TILE_HEIGHT) * Constants.TILE_HEIGHT - camera.getY();
        for (int y = startY; y < Constants.WINDOW_HEIGHT; y += Constants.TILE_HEIGHT) {
            sr.line(0, y, Constants.WINDOW_WIDTH, y);
        }

        sr.end();
    }
}
