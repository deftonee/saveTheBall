package com.mystudio.gamename.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.ActorState;
import com.mystudio.gamename.figures.Figure;

/**
 * Created by deftone on 03.02.2018.
 */

public abstract class ActorBuilder {

    public int MIN_SIZE = 50;
    public int MAX_SIZE = 200;

    abstract Figure getFigure(World world, Vector2 position, float ... params);

    abstract ActorState getState();

    public Actor build(World world, Vector2 position, float ... params){
        Figure f = getFigure(world, position, params);
        ActorState as = getState();
        return new Actor(f, as);
    }
}
