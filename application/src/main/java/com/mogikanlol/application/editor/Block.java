package com.mogikanlol.application.editor;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mogikanlol.application.Constants;

public class Block {

    private int x;
    private int y;

    private int width;
    private int height;

    public Block() {
        width = Constants.TILE_WIDTH;
        height = Constants.TILE_HEIGHT;
        x = width * 8;
        y = height * 8;
    }

    public void draw(ShapeRenderer sr) {
        sr.begin(ShapeRenderer.ShapeType.Filled);
        sr.setColor(Color.RED);

        sr.rect(x,
                y,
                width,
                height);

        sr.end();
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
