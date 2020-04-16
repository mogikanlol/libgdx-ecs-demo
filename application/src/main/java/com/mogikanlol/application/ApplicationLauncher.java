package com.mogikanlol.application;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

public class ApplicationLauncher {

    public static void main(String[] args) {
        LwjglApplicationConfiguration configuration = new LwjglApplicationConfiguration();

        configuration.width = Constants.WINDOW_WIDTH;
        configuration.height = Constants.WINDOW_HEIGHT;

        LwjglApplication lwjglApplication = new LwjglApplication(new Application(), configuration);
    }
}
