package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import ru.deftone.ActorState;
import ru.deftone.figures.Figure;
import ru.deftone.figures.PolygonFigure;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class RectangleObstacleBuilder extends TouchableObstacleBuilder {
    public float defaultFriction = 0;
    public float defaultRestitution = 1;
    public float defaultDensity = 10;

    Figure getFigure(World world, Vector2 position, float ... params) {
        Vector2 size;
        if (params.length == 2) {
            size = new Vector2(params[0], params[1]);
        } else {
            Random r = new Random();
            size = new Vector2(
                    r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE,
                    r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE);
        }
        size.scl(0.5f);
        Vector2 [] vertices = {
                new Vector2(-size.x, -size.y),
                new Vector2(size.x, -size.y),
                new Vector2(size.x, size.y),
                new Vector2(-size.x, size.y)
        };
        return new PolygonFigure(
                world, BodyDef.BodyType.DynamicBody,
                position, vertices,
                defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    String getName() {
        return "Rectangle obstacle";
    }

}
