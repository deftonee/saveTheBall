package com.mystudio.gamename.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mystudio.gamename.ActorState;
import com.mystudio.gamename.figures.Figure;
import com.mystudio.gamename.figures.RectangleFigure;

/**
 * Created by deftone on 04.02.2018.
 */

public class StaticObstacleBuilder extends ActorBuilder {

    @Override
    Figure getFigure(World world, Vector2 position, float ... params) {
        return new RectangleFigure(world, BodyDef.BodyType.StaticBody,
                position, params[0], params[1]);
    }

    @Override
    ActorState getState() {
        return null;
    }
}
