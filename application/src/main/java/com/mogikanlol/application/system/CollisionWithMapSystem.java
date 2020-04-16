package com.mogikanlol.application.system;

import com.mogikanlol.application.Constants;
import com.mogikanlol.application.EntityManager;
import com.mogikanlol.application.component.Velocity;
import com.mogikanlol.application.map.Tile;
import com.mogikanlol.application.map.TileMap;
import com.mogikanlol.application.component.Bounds;
import com.mogikanlol.application.component.Position;

import java.util.Set;

public class CollisionWithMapSystem {

    public void update(EntityManager em, TileMap map) {

        Set<Long> entities = em.getEntities();
        for (Long entityId : entities) {

            Position position = em.getComponent(entityId, Position.class);
            Bounds bounds = em.getComponent(entityId, Bounds.class);
            Velocity velocity = em.getComponent(entityId, Velocity.class);

            if (position != null && bounds != null && velocity != null) {
                for (Tile tile : map.getTiles()) {
                    if (isColliding(position, tile)) {

                        Side collisionSide = getCollisionSide(bounds, tile);

                        switch (collisionSide) {
                            case RIGHT: {
                                position.setX(tile.getX() - Constants.TILE_WIDTH);
                                break;
                            }
                            case LEFT: {
                                position.setX(tile.getX() + tile.getWidth());
                                break;
                            }
                            case BOTTOM: {
                                position.setY(tile.getY() + tile.getHeight());
                                velocity.setGrounded(true);
                                velocity.setY(0);
                                break;
                            }
                            case TOP: {
                                position.setY(tile.getY() - Constants.TILE_HEIGHT);
                                velocity.setY(0);
                                break;
                            }
                        }

                    }
                }
            }
        }

    }

    private boolean isColliding(Position position, Tile tile) {
        return position.getX() < tile.getX() + tile.getWidth()
                && position.getX() + Constants.TILE_WIDTH > tile.getX()
                && position.getY() < tile.getY() + tile.getHeight()
                && position.getY() + Constants.TILE_HEIGHT > tile.getY();
    }

    private Side getCollisionSide(Bounds bounds, Tile tile) {
        int amountRight, amountLeft, amountTop, amountBottom;

        amountRight = (int) (bounds.getRight() - tile.getX());
        amountLeft = (int) (tile.getX() + tile.getWidth() - bounds.getLeft());
        amountTop = (int) (tile.getY() - bounds.getTop());
        amountBottom = (int) (bounds.getBottom() - (tile.getY() + tile.getHeight()));

        int[] vals = new int[]{Math.abs(amountBottom), Math.abs(amountTop), Math.abs(amountLeft), Math.abs(amountRight)};

        int lowest = vals[0];

        for (int val : vals) {
            if (val < lowest) {
                lowest = val;
            }
        }

        return lowest == Math.abs(amountRight) ? Side.RIGHT :
                lowest == Math.abs(amountLeft) ? Side.LEFT :
                        lowest == Math.abs(amountTop) ? Side.TOP :
                                lowest == Math.abs(amountBottom) ? Side.BOTTOM :
                                        Side.NONE;
    }

    public enum Side {
        RIGHT, LEFT, BOTTOM, TOP, NONE
    }

}
