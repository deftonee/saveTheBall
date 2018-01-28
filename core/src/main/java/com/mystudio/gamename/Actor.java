package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Shape;

/**
 * Created by deftone on 28.01.2018.
 */

public class Actor {
    Shape shape;
    Body body;

    Actor(World world){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(def);

        PolygonShape poly = new PolygonShape();
        poly.setAsBox(shape.width, shape.height);
        body.createFixture(poly, 1);
        poly.dispose();
    }
}
