package com.mystudio.gamename;

import com.badlogic.gdx.math.Vector2;
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
        Figure f = getFigure(world, x, y, params);
        ActorState as = getState();
        Actor result = new Actor(f, as);
        result.setPosition(x, y);
        result.setOrigin(f.getWidth() / 2, f.getHeight() / 2);
        return result;
    }

}
