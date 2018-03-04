package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import org.mini2Dx.core.geom.Parallelogram;
import org.mini2Dx.core.geom.Rectangle;

/**
 * Created by deftone on 02.02.2018.
 */

public class RectangleFigure extends Figure {

    public RectangleFigure(World world, BodyDef.BodyType type,
                           float x, float y, float width, float height,
                           float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = type;
        def.position.set(x, y);
        body = world.createBody(def);

        shape = new Rectangle(x, y, width, height);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(((Parallelogram)shape).getWidth(), ((Parallelogram) shape).getHeight());
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;

        body.createFixture(fixture);
        bodyShape.dispose();

    }

    public RectangleFigure(World world, BodyDef.BodyType type,
                           float x, float y, float width, float height){
        this(world, type, x, y, width, height, 0.2f, 0, 0);
    }


    public float getWidth(){
        return ((Rectangle) shape).getWidth();
    }

    public float getHeight(){
        return ((Rectangle) shape).getHeight();
    }

}
