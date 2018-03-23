package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import ru.deftone.ActorState;
import ru.deftone.figures.Figure;
import ru.deftone.Helpers;
import ru.deftone.figures.PolygonFigure;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class PentagonObstacleBuilder extends TouchableObstacleBuilder {
    public float defaultFriction = 0;
    public float defaultRestitution = 1;
    public float defaultDensity = 10;

    Figure getFigure(World world, Vector2 position, float ... params) {
        float radius;
        if (params.length == 1) {
            radius = params[0];
        } else {
            Random r = new Random();
            radius = (r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE) / 2;
        }
        return new PolygonFigure(world, BodyDef.BodyType.DynamicBody,
                position, Helpers.calcRegularPolygonVertices(radius, 5),
                defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    String getName() {
        return "Pentagon obstacle";
    }

}