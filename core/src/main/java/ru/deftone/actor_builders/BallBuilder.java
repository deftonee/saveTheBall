package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.states.ActorState;
import ru.deftone.figures.CircleFigure;
import ru.deftone.figures.Figure;
import ru.deftone.states.BallState;

/**
 * Main game character
 * Created by deftone on 04.02.2018.
 */

public class BallBuilder extends ActorBuilder {
    static float defaultFriction = 0;
    static float defaultRestitution = 1;
    static float defaultDensity = 1;


    Figure getFigure(Actor actor, World world, Vector2 position, float ... params) {
        Figure figure = new CircleFigure(
                actor, world,
                position, params[0],
                defaultFriction, defaultRestitution, defaultDensity);
        figure.getBody().setType(BodyDef.BodyType.DynamicBody);
        return figure;
    }

    ActorState getState(Actor actor) {
        return new BallState(actor);
    }


    String getName() {
        return "Ball";
    }
}
