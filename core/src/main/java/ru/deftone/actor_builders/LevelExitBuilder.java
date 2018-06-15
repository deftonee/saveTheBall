package ru.deftone.actor_builders;

import java.util.Random;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.figures.CircleFigure;
import ru.deftone.figures.Figure;
import ru.deftone.states.ActorState;
import ru.deftone.states.InactiveLevelExitState;

/**
 * Created by deftone on 04.02.2018.
 */

public class LevelExitBuilder extends ActorBuilder {

    public float defaultFriction = 1;
    public float defaultRestitution = 1;
    public float defaultDensity = 1;

    Figure getFigure(Actor actor, World world, Vector2 position, float ... params) {
        float radius;
        if (params.length == 1) {
            radius = params[0];
        } else {
            Random r = new Random();
            radius = (r.nextFloat() * (MAX_SIZE - MIN_SIZE) + MIN_SIZE) / 2;
        }
        Figure figure = new CircleFigure(
                actor, world,
                position, radius,
                defaultFriction, defaultRestitution, defaultDensity);
        figure.getBody().setActive(false);
        return figure;
    }

    ActorState getState(Actor actor) {
        return new InactiveLevelExitState(actor);
    }

    String getName() {
        return "Level exit";
    }
}
