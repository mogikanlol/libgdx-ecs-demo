package com.mogikanlol.application.system;

import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.component.Position;
import com.mogikanlol.application.component.Velocity;

import java.util.Set;

public class VelocitySystem {

    private static final float GRAVITY = 1000;
    private static final float GRAVITY_CAP = 1600;

    public void update(EntityManager em, float dt) {
        Set<Long> entities = em.getEntities();

        for (Long entityId : entities) {
            Position position = em.getComponent(entityId, Position.class);
            Velocity velocity = em.getComponent(entityId, Velocity.class);

            if (position != null && velocity != null) {

                if (velocity.getY() <= GRAVITY_CAP) {
                    velocity.setY(velocity.getY() + (GRAVITY * dt));
                }
                float y = position.getY() - velocity.getY() * dt;
                position.setY(y);
            }
        }
    }

}
