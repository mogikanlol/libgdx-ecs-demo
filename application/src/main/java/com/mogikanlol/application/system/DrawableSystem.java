package com.mogikanlol.application.system;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.component.Drawable;
import com.mogikanlol.application.component.Position;

import java.util.Set;

public class DrawableSystem {

    private final SpriteBatch spriteBatch;

    public DrawableSystem(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
    }

    public void update(EntityManager em) {
        spriteBatch.begin();

        Set <Long> entities = em.getEntities();

        for (Long entityId : entities) {

            Drawable dc = em.getComponent(entityId, Drawable.class);
            Position pc = em.getComponent(entityId, Position.class);

            if (dc != null && pc != null) {
                spriteBatch.draw(
                        dc.getTexture(),
                        pc.getX(), pc.getY(),
                        dc.getWidth(),
                        dc.getHeight()
                );
            }

        }

        spriteBatch.end();
    }

}
