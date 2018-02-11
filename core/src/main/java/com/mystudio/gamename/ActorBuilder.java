package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 03.02.2018.
 */

public class ActorBuilder {

    Figure getFigure(World world, float ... params){
        return null;
    }

    ActorState getState(){
        return null;
    }

    public Actor build(World world, float ... params){
        return new Actor(getFigure(world, params), getState());
    }
}
