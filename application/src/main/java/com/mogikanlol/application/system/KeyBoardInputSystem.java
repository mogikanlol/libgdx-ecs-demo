package com.mogikanlol.application.system;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.component.KeyBoardInput;
import com.mogikanlol.application.component.Position;
import com.mogikanlol.application.component.Velocity;

import java.util.Set;

public class KeyBoardInputSystem {

    public static final float JUMP_VELOCITY = -450;

    public void update(EntityManager em, float dt) {

        Set<Long> entities = em.getEntities();
        for (Long entity : entities) {

            KeyBoardInput keyBoardInput = em.getComponent(entity, KeyBoardInput.class);
            Position position = em.getComponent(entity, Position.class);
            Velocity velocity = em.getComponent(entity, Velocity.class);

            if (keyBoardInput != null && position != null && velocity != null) {
                if (Gdx.input.isKeyPressed(Input.Keys.D)) {
                    float x = position.getX() + velocity.getX() * dt;
                    position.setX(x);
                } else if (Gdx.input.isKeyPressed(Input.Keys.A)) {
                    float x = position.getX() - velocity.getX() * dt;
                    position.setX(x);
                }
                if (Gdx.input.isKeyJustPressed(Input.Keys.SPACE)) {
                    if (velocity.isGrounded()) {
                        velocity.setY(JUMP_VELOCITY);
                        velocity.setGrounded(false);
                    }
                }
            }
        }
    }

}
