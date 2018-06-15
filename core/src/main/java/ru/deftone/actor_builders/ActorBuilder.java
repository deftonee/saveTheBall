package ru.deftone.actor_builders;

import java.util.Random;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.states.ActorState;
import ru.deftone.Resources;
import ru.deftone.figures.Figure;

/**
 * Builder of {@link Actor}.
 * Everything is doing by {@link ActorBuilder#build} method that takes
 * instance of {@link ActorState}, instance of {@link Figure}, name and
 * creates new {@link Actor}.
 * It is a template method so you can do additional job in {@link ActorBuilder#postBuild}
 * Created by deftone on 03.02.2018.
 */

public abstract class ActorBuilder {

    public float MIN_SIZE = 100;
    public float MAX_SIZE = 250;

    private float screenWidth = Gdx.graphics.getWidth();
    private float screenHeight = Gdx.graphics.getHeight();

    abstract Figure getFigure(Actor actor, World world, Vector2 position, float ... params);

    abstract ActorState getState(Actor actor);

    abstract String getName();

    public Actor build(Vector2 position, float ... params) {
        Resources res = Resources.getInstance();
        Actor actor = new Actor();
        actor.setFigure(getFigure(actor, res.getWorld(), position, params));
        actor.setState(getState(actor));
        actor.setName(getName());
        postBuild(actor);
        return actor;
    }

    public Actor build(float ... params) {
        return build(randomPosition(), params);
    }

    void postBuild(Actor a) {}

    private Vector2 randomPosition() {
        Random random = new Random();

        return new Vector2(
                random.nextFloat() * (screenWidth - 2 * MAX_SIZE) + MAX_SIZE,
                random.nextFloat() * (screenHeight - 2 * MAX_SIZE) + MAX_SIZE
        );
    }
}
