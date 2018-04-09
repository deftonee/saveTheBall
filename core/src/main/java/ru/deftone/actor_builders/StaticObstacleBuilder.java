package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.states.ActorState;
import ru.deftone.figures.Figure;
import ru.deftone.figures.PolygonFigure;
import ru.deftone.states.StaticActorState;


/**
 * Created by deftone on 04.02.2018.
 */

public class StaticObstacleBuilder extends ActorBuilder {

    static float defaultFriction = 0;
    static float defaultRestitution = 1;
    static float defaultDensity = 0;

    Figure getFigure(Actor actor, World world, Vector2 position, float ... params) {
        Vector2 size = new Vector2(params[0], params[1]);
        size.scl(0.5f);
        Vector2 [] vertices = {
                new Vector2(-size.x, -size.y),
                new Vector2(size.x, -size.y),
                new Vector2(size.x, size.y),
                new Vector2(-size.x, size.y)
        };
        return new PolygonFigure(
                actor, world,
                position, vertices,
                defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState(Actor actor) {
        return new StaticActorState(actor);
    }

    String getName() {
        return "Static obstacle";
    }
}
