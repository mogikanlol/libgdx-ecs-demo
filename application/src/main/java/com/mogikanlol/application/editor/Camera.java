package com.mogikanlol.application.editor;

public class Camera {

    private int x;
    private int y;

    public Camera() {
        x = 0;
        y = 0;
    }

    public void update() {
//        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//            System.out.println(Gdx.input.getX());
//            this.x = Gdx.input.getX();
//        }
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
