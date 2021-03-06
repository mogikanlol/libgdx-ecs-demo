package com.mogikanlol.application.map;

import com.mogikanlol.application.Constants;

public class Tile {

    private int x;
    private int y;
    private int width;
    private int height;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = Constants.TILE_WIDTH;
        this.height = Constants.TILE_HEIGHT;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
