package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

/**
 * Created by deftone on 04.02.2018.
 */

public class ObstacleBuilder extends ActorBuilder {

    @Override
    Figure getFigure(World world, float x, float y, float ... params) {
        return new RectangleFigure(world, BodyDef.BodyType.StaticBody,
                x, y, params[0], params[1]);
    }

    @Override
    ActorState getState() {
        return null;
    }
}
