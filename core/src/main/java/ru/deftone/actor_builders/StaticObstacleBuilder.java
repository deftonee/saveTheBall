package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import ru.deftone.ActorState;
import ru.deftone.figures.Figure;
import ru.deftone.figures.PolygonFigure;


/**
 * Created by deftone on 04.02.2018.
 */

public class StaticObstacleBuilder extends ActorBuilder {

    static float defaultFriction = 0;
    static float defaultRestitution = 1;
    static float defaultDensity = 0;

    Figure getFigure(World world, Vector2 position, float ... params) {
        Vector2 size = new Vector2(params[0], params[1]);
        size.scl(0.5f);
        Vector2 [] vertices = {
                new Vector2(-size.x, -size.y),
                new Vector2(size.x, -size.y),
                new Vector2(size.x, size.y),
                new Vector2(-size.x, size.y)
        };
        return new PolygonFigure(world, BodyDef.BodyType.StaticBody,
                position, vertices,
                defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    String getName() {
        return "Static obstacle";
    }
}
