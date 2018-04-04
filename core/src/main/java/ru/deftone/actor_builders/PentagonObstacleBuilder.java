package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.figures.Figure;
import ru.deftone.Helpers;
import ru.deftone.figures.PolygonFigure;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class PentagonObstacleBuilder extends DynamicObstacleBuilder {

    Figure getFigure(Actor actor, World world, Vector2 position, float ... params) {
        float radius;
        if (params.length == 1) {
            radius = params[0];
        } else {
            Random r = new Random();
            radius = (r.nextFloat() * (MAX_SIZE - MIN_SIZE) + MIN_SIZE) / 2;
        }
        return new PolygonFigure(actor, world, BodyDef.BodyType.DynamicBody,
                position, Helpers.calcRegularPolygonVertices(radius, 5),
                defaultFriction, defaultRestitution, defaultDensity);
    }

    String getName() {
        return "Pentagon obstacle";
    }

}
