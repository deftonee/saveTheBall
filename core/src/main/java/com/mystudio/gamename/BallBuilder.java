package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 04.02.2018.
 */

public class BallBuilder extends ActorBuilder {

    @Override
    Figure getFigure(World world, float ... params) {
        return new CircleFigure(world, params[0], params[1], params[2]);
    }

    @Override
    ActorState getState() {
        return null;
    }
}
