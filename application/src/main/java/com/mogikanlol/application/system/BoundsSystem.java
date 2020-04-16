package com.mogikanlol.application.system;

import com.mogikanlol.application.Constants;
import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.component.Bounds;
import com.mogikanlol.application.component.Position;

import java.util.Set;

public class BoundsSystem {

    public void update(EntityManager em) {
        Set<Long> entities = em.getEntities();

        for (Long entityId : entities) {

            Position position = em.getComponent(entityId, Position.class);
            Bounds bounds = em.getComponent(entityId, Bounds.class);

            if (bounds != null && position != null) {

                bounds.setBottom(position.getY());
                bounds.setTop(position.getY() + Constants.TILE_HEIGHT);
                bounds.setLeft(position.getX());
                bounds.setRight(position.getX() + Constants.TILE_WIDTH);
            }
        }
    }

}
