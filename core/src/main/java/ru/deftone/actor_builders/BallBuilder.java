package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.ActorState;
import ru.deftone.figures.CircleFigure;
import ru.deftone.figures.Figure;

/**
 * Created by deftone on 04.02.2018.
 */

public class BallBuilder extends ActorBuilder {
    static float defaultFriction = 0;
    static float defaultRestitution = 1;
    static float defaultDensity = 0.1f;


    Figure getFigure(World world, Vector2 position, float ... params) {
        return new CircleFigure(
                world, BodyDef.BodyType.DynamicBody,
                position, params[0], defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }


    String getName() {
        return "Ball";
    }
}
