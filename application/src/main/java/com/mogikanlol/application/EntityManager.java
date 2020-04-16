package com.mogikanlol.application;

import com.mogikanlol.application.component.Component;

import java.util.*;

public class EntityManager {

    private Map<Long, Set<Component>> entities;

    public EntityManager() {
        entities = new HashMap<>();
    }

    public Long createEntity() {
        long size = entities.size() + 1;

        entities.put(size, new HashSet<>());

        return size;
    }

    public void addComponentToEntity(Long entityId, Component component) {
        Set<Component> components = entities.get(entityId);
        components.add(component);
    }

    public Set<Long> getEntities() {
        return entities.keySet();
    }

    public <T extends Component> T getComponent(Long entityId, Class<T> clazz) {
        Set<Component> components = entities.get(entityId);
        if (components != null) {
            for (Component component : components) {
                if (clazz.isAssignableFrom(component.getClass())) {
                    return (T) component;
                }
            }
        }

        return null;
    }
}
