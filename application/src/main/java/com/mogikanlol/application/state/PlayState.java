package com.mogikanlol.application.state;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.map.TileMap;
import com.mogikanlol.application.component.*;
import com.mogikanlol.application.system.*;

public class PlayState extends GameState {

    private EntityManager entityManager;
    private DrawableSystem drawableSystem;
    private KeyBoardInputSystem keyBoardInputSystem;
    private VelocitySystem velocitySystem;
    private CollisionWithMapSystem collisionWithMapSystem;
    private BoundsSystem boundsSystem;

    private TileMap map;

    public PlayState() {
        SpriteBatch spriteBatch = new SpriteBatch();

        entityManager = new EntityManager();
        drawableSystem = new DrawableSystem(spriteBatch);
        keyBoardInputSystem = new KeyBoardInputSystem();
        velocitySystem = new VelocitySystem();
        collisionWithMapSystem = new CollisionWithMapSystem();
        boundsSystem = new BoundsSystem();

        Long entity = entityManager.createEntity();
        entityManager.addComponentToEntity(entity, new Position(100, 100));
        Texture texture = new Texture(Gdx.files.internal("test.jpg"));
        Drawable drawable = new Drawable(
                texture,
                32,
                32);
        entityManager.addComponentToEntity(entity, drawable);
        entityManager.addComponentToEntity(entity, new KeyBoardInput());
        entityManager.addComponentToEntity(entity, new Bounds());
        entityManager.addComponentToEntity(entity, new Velocity(200f, 0));

        map = new TileMap(spriteBatch);
    }

    public void update(float dt) {
        boundsSystem.update(entityManager);
        collisionWithMapSystem.update(entityManager, map);
        keyBoardInputSystem.update(entityManager, dt);
        velocitySystem.update(entityManager, dt);
        drawableSystem.update(entityManager);
        map.draw();
    }

}
