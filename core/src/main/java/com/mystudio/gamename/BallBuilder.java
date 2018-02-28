package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 04.02.2018.
 */

public class BallBuilder extends ActorBuilder {

    @Override
    Figure getFigure(World world, float x, float y, float ... params) {
        return new CircleFigure(world, x, y, params[0]);
    }

    @Override
    ActorState getState() {
        return null;
    }
}
