package com.mogikanlol.application.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.mogikanlol.application.editor.Block;
import com.mogikanlol.application.editor.Camera;
import com.mogikanlol.application.editor.CameraController;
import com.mogikanlol.application.editor.Grid;

public class LevelEditorState extends GameState {

    private ShapeRenderer shapeRenderer;
    private Camera camera;
    private Grid grid;
    private CameraController cameraController;
    private Block block;

    public LevelEditorState() {
        shapeRenderer = new ShapeRenderer();
        camera = new Camera();
        grid = new Grid(camera);
        cameraController = new CameraController(camera);
        block = new Block();

        Gdx.input.setInputProcessor(cameraController);
    }

    public void update(float dt) {
        camera.update();
    }

    public void draw() {
        Gdx.gl.glClearColor(2, 2, 2, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        grid.draw(shapeRenderer);
        drawBlockRelativeToCamera();
    }

    private void drawBlockRelativeToCamera() {
        int oldBlockX = block.getX();
        int oldBlockY = block.getY();

        block.setX(oldBlockX - camera.getX());
        block.setY(oldBlockY - camera.getY());

        block.draw(shapeRenderer);

        block.setX(oldBlockX);
        block.setY(oldBlockY);
    }
}
