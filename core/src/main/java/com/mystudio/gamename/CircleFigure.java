package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Circle;

/**
 * Created by deftone on 02.02.2018.
 */

public class CircleFigure extends Figure {

    public CircleFigure(World world, float x, float y, float radius,
                        float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x + radius / 2, y + radius / 2);
        body = world.createBody(def);

        shape = new Circle(x + radius / 2, y + radius / 2, radius);

        Shape bodyShape = new CircleShape();
        bodyShape.setRadius(radius);

        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;

        body.createFixture(fixture);
        bodyShape.dispose();
    }

    public CircleFigure(World world, float x, float y, float radius){
        this(world, x, y, radius, 0.2f, 0, 0);
    }

    public float getWidth(){
        return ((Circle) shape).getRadius();
    }

    public float getHeight(){
        return ((Circle) shape).getRadius();
    }

}
