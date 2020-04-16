package com.mogikanlol.application;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.mogikanlol.application.state.GameState;
import com.mogikanlol.application.state.LevelEditorState;
import com.mogikanlol.application.state.PlayState;

public class Application extends ApplicationAdapter {

    private GameState currentState;

    @Override
    public void create() {
//        currentState = new LevelEditorState();
        currentState = new PlayState();
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        currentState.update(Gdx.graphics.getDeltaTime());
    }

}
