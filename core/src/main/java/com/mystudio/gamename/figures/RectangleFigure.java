package com.mystudio.gamename.figures;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Polygon;

/**
 * Created by deftone on 02.02.2018.
 */

public class RectangleFigure extends Figure {

    public RectangleFigure(World world, BodyDef.BodyType type,
                           Vector2 position, float width, float height,
                           float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = type;
        def.position.set(position);
        body = world.createBody(def);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(width / 2, height / 2);
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;
        Fixture f = body.createFixture(fixture);
        shape = new Polygon(getVertices(f, body.getPosition()));
        bodyShape.dispose();
    }

    public RectangleFigure(World world, BodyDef.BodyType type,
                           Vector2 position, float width, float height){
        this(world, type, position, width, height, 0, 1, 1);
    }

    public void actualizePosition(){
        for (Fixture f: body.getFixtureList()) {
            if (f.getBody() == body){
                ((Polygon)shape).setVertices(getVertices(f, body.getPosition()));
                break;
            }
        }
        shape.setRotationAround(body.getPosition().x, body.getPosition().y, body.getAngle() *  MathUtils.radiansToDegrees);

    }

}
