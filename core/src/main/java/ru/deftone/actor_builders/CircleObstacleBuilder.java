package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import ru.deftone.ActorState;
import ru.deftone.figures.CircleFigure;
import ru.deftone.figures.Figure;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class CircleObstacleBuilder extends TouchableObstacleBuilder {

    Figure getFigure(World world, Vector2 position, float ... params) {
        float radius;
        if (params.length == 1) {
            radius = params[0];
        } else {
            Random r = new Random();
            radius = (r.nextFloat() * (MAX_SIZE - MIN_SIZE) + MIN_SIZE) / 2;
        }
        return new CircleFigure(world, BodyDef.BodyType.DynamicBody,
                position, radius, defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    String getName() {
        return "Circle obstacle";
    }
}
