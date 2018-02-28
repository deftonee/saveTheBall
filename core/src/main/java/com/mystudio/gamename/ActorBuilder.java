package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 03.02.2018.
 */

public class ActorBuilder {

    Figure getFigure(World world, float x, float y, float ... params){
        return null;
    }

    ActorState getState(){
        return null;
    }

    public Actor build(World world, float x, float y, float ... params){
        Actor result = new Actor(getFigure(world, x, y, params), getState());
        result.setPosition(x, y);
        return result;
    }
}
