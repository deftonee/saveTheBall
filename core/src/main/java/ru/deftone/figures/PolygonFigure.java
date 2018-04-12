package ru.deftone.figures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;
import ru.deftone.Helpers;

/**
 * Created by deftone on 02.02.2018.
 */

public class PolygonFigure extends Polygon implements Figure {

    private Body body;
    private Actor actor;

    public PolygonFigure(Actor actor, World world,
                         Vector2 position, Vector2 [] vertices,
                         float friction, float restitution, float density){
        super();
        position = Helpers.toBox2d(position);
        vertices = Helpers.toBox2d(vertices);
        setPosition(0, 0);
        setVertices(Helpers.changeVerticesRepresentation(vertices));
        this.actor = actor;
        BodyDef def = new BodyDef();
        def.position.set(position);
        body = world.createBody(def);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.set(vertices);
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;

        body.createFixture(fixture);
        body.setUserData(actor);
        bodyShape.dispose();

    }

    public void draw(Batch batch, float parentAlpha) {}

    public Vector2 getPosition() {
        return body.getPosition();
    }

    private static float [] getPolygonVerticesFromShape(Shape shape, Vector2 origin,
                                                        float radAngle, boolean oneAfterAnother){
        int number = ((PolygonShape) shape).getVertexCount();
        Vector2 buffer = new Vector2();
        float [] vertices = new float [((PolygonShape) shape).getVertexCount() * 2];
        for (int i = 0; i < number; i++) {
            ((PolygonShape) shape).getVertex(i, buffer);
            buffer.rotateRad(radAngle).add(origin);
            if (oneAfterAnother){
                vertices[i] = buffer.x;
                vertices[i + number] = buffer.y;
            } else {
                vertices[i * 2] = buffer.x;
                vertices[i * 2 + 1] = buffer.y;
            }
        }
        return vertices;
    }

    public float getWidth() {
        Shape shape = Helpers.getShapeFromBody(body);
        if (shape == null)
            return 0;

        float [] vertices = getPolygonVerticesFromShape(shape, new Vector2(0, 0),
                                                        body.getAngle(), false);
        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;
        for (int i = 0; i < vertices.length; i += 2){
            if (vertices[i] > max)
                max = vertices[i];
            if (vertices[i] < min)
                min = vertices[i];
        }
        return max - min;
    }

    public float getHeight() {
        Shape shape = Helpers.getShapeFromBody(body);
        if (shape == null)
            return 0;

        float [] vertices = getPolygonVerticesFromShape(shape, new Vector2(0, 0),
                                                        body.getAngle(), false);
        float min = Float.MAX_VALUE;
        float max = -Float.MAX_VALUE;
        for (int i = 1; i < vertices.length; i += 2){
            // TODO do it like i saw in the algorithms book
            if (vertices[i] > max)
                max = vertices[i];
            if (vertices[i] < min)
                min = vertices[i];
        }
        return max - min;
    }

    public void drawDebug(ShapeRenderer shapes) {
        Shape shape = Helpers.getShapeFromBody(body);
        if (shapes == null)
            return;
        Vector2 bodyPosition = body.getPosition();

        shapes.setColor(actor.getColor());
        shapes.polygon(getPolygonVerticesFromShape(shape, bodyPosition, body.getAngle(), false));
    }

    public Body getBody() {
        return body;
    }

    public void moveToPosition(float x, float y) {
        body.setTransform(x, y, body.getAngle());
    }

    public void dispose() {
        body.getWorld().destroyBody(body);
    }
}
