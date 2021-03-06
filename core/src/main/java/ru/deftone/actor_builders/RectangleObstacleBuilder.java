package ru.deftone.actor_builders;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.figures.Figure;
import ru.deftone.figures.PolygonFigure;


/**
 * Created by deftone on 04.02.2018.
 */

public class RectangleObstacleBuilder extends DynamicObstacleBuilder {

    Figure getFigure(Actor actor, World world, Vector2 position, float ... params) {
        Vector2 size;
        if (params.length == 2) {
            size = new Vector2(params[0], params[1]);
        } else {
            Random r = new Random();
            size = new Vector2(
                    r.nextFloat() * (MAX_SIZE - MIN_SIZE) + MIN_SIZE,
                    r.nextFloat() * (MAX_SIZE - MIN_SIZE) + MIN_SIZE);
        }
        size.scl(0.5f);
        Vector2 [] vertices = {
                new Vector2(-size.x, -size.y),
                new Vector2(size.x, -size.y),
                new Vector2(size.x, size.y),
                new Vector2(-size.x, size.y)
        };
        Figure figure = new PolygonFigure(
                actor, world,
                position, vertices,
                defaultFriction, defaultRestitution, defaultDensity);
        figure.getBody().setType(BodyDef.BodyType.DynamicBody);
        return figure;
    }

    String getName() {
        return "Rectangle obstacle";
    }

}
