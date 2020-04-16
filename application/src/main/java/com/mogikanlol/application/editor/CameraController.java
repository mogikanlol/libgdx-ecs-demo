package com.mogikanlol.application.editor;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;

public class CameraController extends InputAdapter {

    private final Camera camera;

    private int currentX;
    private int currentY;

    private int previousX = 0;
    private int previousY = 0;

    public CameraController(Camera camera) {
        this.camera = camera;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        currentX = screenX;
        currentY = Gdx.graphics.getHeight() - screenY - 1;

        // should be initializing before dragging
        previousX = currentX;
        previousY = currentY;
        return true;
    }

    @Override
    public boolean touchDragged(int draggedX, int graggedY, int pointer) {
        graggedY = Gdx.graphics.getHeight() - graggedY - 1;

        int dx = draggedX - previousX;
        int dy = graggedY - previousY;

        camera.setX(camera.getX() - dx);
        camera.setY(camera.getY() - dy);

        previousX = draggedX;
        previousY = graggedY;
        return true;
    }
}
