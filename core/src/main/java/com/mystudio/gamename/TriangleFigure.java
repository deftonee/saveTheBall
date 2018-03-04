package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Parallelogram;
import org.mini2Dx.core.geom.Rectangle;
import org.mini2Dx.core.geom.Triangle;

import java.util.ArrayList;

/**
 * Created by deftone on 02.02.2018.
 */

public class TriangleFigure extends Figure {

    public TriangleFigure(World world, BodyDef.BodyType type,
                          float x1, float y1, float x2, float y2, float x3, float y3,
                          float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = type;
        def.position.set(x1, y1);  // calculate this
        body = world.createBody(def);

        shape = new Triangle(x1, y1, x2, y2, x3, y3);

        PolygonShape bodyShape = new PolygonShape();
        float[] coords = {x1, y1, x2, y2, x3, y3};
        bodyShape.set(coords);
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;

        body.createFixture(fixture);
        bodyShape.dispose();

    }

    public TriangleFigure(World world, BodyDef.BodyType type,
                          float x, float y, float x1, float y1, float x2, float y2, float x3, float y3){
        this(world, type, x1, y1, x2, y2, x3, y3, 0.2f, 0, 0);
    }


    public float getWidth(){
        return ((Rectangle) shape).getWidth();
    }

    public float getHeight(){
        return ((Rectangle) shape).getHeight();
    }

}
