package com.mystudio.gamename;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
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

    public CircleFigure(World world, BodyDef.BodyType type, Vector2 position, float radius,
                        float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = type;
        def.position.set(position);
        body = world.createBody(def);

        shape = new Circle(position.x - radius / 2, position.y - radius / 2, radius);

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

    public CircleFigure(World world, BodyDef.BodyType type, Vector2 position, float radius){
        this(world, type, position, radius, 0.2f, 0, 1);
    }

    public float getWidth(){
        return ((Circle) shape).getRadius();
    }

    public float getHeight(){
        return ((Circle) shape).getRadius();
    }

    public void actualizePosition(){
        shape.set(body.getPosition().x, body.getPosition().y);
        shape.setRotation(body.getAngle() *  MathUtils.radiansToDegrees);
    }

}
