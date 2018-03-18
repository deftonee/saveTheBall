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

    public void actualizePosition(){
        Vector2 bodyPosition = body.getPosition();
        for (Fixture f: body.getFixtureList()) {
            if (f.getBody() == body){
                ((Polygon)shape).setVertices(getPolygonVerticesFromFixture(f, bodyPosition));
                break;
            }
        }

        shape.setRotationAround(
                bodyPosition.x, bodyPosition.y,
                body.getAngle() *  MathUtils.radiansToDegrees
        );

    }

    public static Vector2 [] getPolygonVerticesFromFixture(Fixture f, Vector2 origin){
        PolygonShape pShape = (PolygonShape)f.getShape();
        Vector2 [] vertices = new Vector2 [pShape.getVertexCount()];
        for (int i = 0; i < pShape.getVertexCount(); i++) {
            vertices[i] = new Vector2();
            pShape.getVertex(i, vertices[i]);
            vertices[i].add(origin);
        }
        return vertices;
    }

}
