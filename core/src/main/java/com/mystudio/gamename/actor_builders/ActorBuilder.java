package com.mystudio.gamename.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.ActorState;
import com.mystudio.gamename.Resources;
import com.mystudio.gamename.figures.Figure;

/**
 * Created by deftone on 03.02.2018.
 */

public abstract class ActorBuilder {

    public int MIN_SIZE = 50;
    public int MAX_SIZE = 200;

    abstract Figure getFigure(World world, Vector2 position, float ... params);

    abstract ActorState getState();

    abstract String getName();

    public Actor build(Vector2 position, float ... params){
        Resources res = Resources.getInstance();
        Figure figure = getFigure(res.world, position, params);
        ActorState state = getState();
        String name = getName();
        Actor actor = new Actor(figure, state, name);
        post_build(actor);
        return actor;

    }

    void post_build(Actor a){
    };
}
