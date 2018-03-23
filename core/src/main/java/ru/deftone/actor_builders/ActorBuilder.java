package ru.deftone.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.ActorState;
import ru.deftone.Resources;
import ru.deftone.figures.Figure;

/**
 * Created by deftone on 03.02.2018.
 */

public abstract class ActorBuilder {

    public int MIN_SIZE = 100;
    public int MAX_SIZE = 250;

    abstract Figure getFigure(World world, Vector2 position, float ... params);

    abstract ActorState getState();

    abstract String getName();

    public Actor build(Vector2 position, float ... params) {
        Resources res = Resources.getInstance();
        Actor actor = new Actor();
        actor.setFigure(getFigure(res.world, position, params));
        actor.setState(getState());
        actor.setName(getName());
        postBuild(actor);
        return actor;
    }

    void postBuild(Actor a) {}
}
