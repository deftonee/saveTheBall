package com.mystudio.gamename.figures;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Polygon;
import org.mini2Dx.core.geom.Rectangle;

/**
 * Created by deftone on 02.02.2018.
 */

public class PolygonFigure extends Figure {

    public PolygonFigure(World world, BodyDef.BodyType type,
                         Vector2 position, Vector2 [] vertices,
                         float friction, float restitution, float density){
        BodyDef def = new BodyDef();
        def.type = type;
        def.position.set(position);
        body = world.createBody(def);

        shape = new Polygon(vertices);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.set(vertices);
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;

        body.createFixture(fixture);
        bodyShape.dispose();

    }

    public float getWidth(){
        return ((Rectangle) shape).getWidth();
    }

    public float getHeight(){
        return ((Rectangle) shape).getHeight();
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
