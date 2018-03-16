package com.mystudio.gamename.actor_builders;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.ActorState;
import com.mystudio.gamename.figures.Figure;
import com.mystudio.gamename.figures.RectangleFigure;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class RectangleObstacleBuilder extends ActorBuilder {
    public float defaultFriction = 0;
    public float defaultRestitution = 1;
    public float defaultDensity = 10;

    Figure getFigure(World world, Vector2 position, float ... params) {
        float width, height;
        if (params.length == 2) {
            width = params[0];
            height = params[1];
        } else {
            Random r = new Random();
            width = r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
            height = r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE;
        }
        return new RectangleFigure(world, BodyDef.BodyType.DynamicBody,
                position, width, height, defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    String getName() {
        return "Rectangle obstacle";
    }

    void post_build(Actor actor){

    }
}
