package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 03.02.2018.
 */

public class ActorBuilder {

    static Figure getFigure(World world, float ... params){
        return null;
    };

    static ActorState getState(){
        return null;
    };

    static public Actor build(World world, float ... params){
        return new Actor(getFigure(world, params), getState());
    }
}
