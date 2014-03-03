package com.wow.battlebirds.engine.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ChrisH on 02/03/14.
 *
 * Container class for Entity objects.
 */
public class EntityManager
{
    private static List<Entity> Entities = new ArrayList<Entity>();

    public EntityManager()
    {

    }

    public static void addEntity(Entity entity)
    {
        Entities.add(entity);
    }

    public static void deleteEntities()
    {
        Entities.clear();
    }

    public static List<Entity> retrieveEntities()
    {
        return Entities;
    }
}
