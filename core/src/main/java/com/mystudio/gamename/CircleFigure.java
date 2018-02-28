package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Circle;

/**
 * Created by deftone on 02.02.2018.
 */

public class CircleFigure extends Figure {

    public CircleFigure(World world, float x, float y, float radius){
        BodyDef def = new BodyDef();
        def.type = BodyDef.BodyType.DynamicBody;
        def.position.set(x, y);
        body = world.createBody(def);

        shape = new Circle(x, y, radius);

        Shape bodyShape = new CircleShape();
        bodyShape.setRadius(radius);
        body.createFixture(bodyShape, 1);
        bodyShape.dispose();

    }

    public float getWidth(){
        return ((Circle) shape).getRadius();
    }

    public float getHeight(){
        return ((Circle) shape).getRadius();
    }

}
