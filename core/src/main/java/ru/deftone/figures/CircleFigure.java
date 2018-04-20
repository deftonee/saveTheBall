package ru.deftone.figures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;
import ru.deftone.Actor;
import ru.deftone.Helpers;

/**
 * Created by deftone on 02.02.2018.
 */

public class CircleFigure extends Circle implements Figure {

    private Body body;
    private Actor actor;

    public CircleFigure(Actor actor, World world,
                        Vector2 position, float radius,
                        float friction, float restitution, float density){
        super();

        // convert values
        position = Helpers.toBox2d(position);
        radius = Helpers.toBox2d(radius);

        // circle settings
        set(0, 0, radius);

        this.actor = actor;

        // creating body
        BodyDef def = new BodyDef();
        def.position.set(position);
        body = world.createBody(def);
        Shape bodyShape = new CircleShape();
        bodyShape.setRadius(radius);
        FixtureDef fixture = new FixtureDef();
        fixture.shape = bodyShape;
        fixture.friction = friction;
        fixture.restitution = restitution;
        fixture.density = density;
        body.createFixture(fixture);
        body.setUserData(actor);
        bodyShape.dispose();
    }

    public float getRadius() {
        Shape shape = Helpers.getShapeFromBody(body);
        if (shape == null) {
            return 0;
        } else {
            return shape.getRadius();
        }
    }

    public Body getBody() {
        return body;
    }

    public Vector2 getPosition() {
        return body.getPosition();
    }

    public void draw(Batch batch, float parentAlpha) {

    }

    public float getWidth(){
        return getRadius() * 2;
    }

    public float getHeight(){
        return getRadius() * 2;
    }

    public void drawDebug(ShapeRenderer shapes) {
        Vector2 bodyPosition = body.getPosition();

        shapes.setColor(actor.getColor());
        shapes.circle(bodyPosition.x, bodyPosition.y, getRadius());
    }

    public void moveToPosition(float x, float y) {
        body.setTransform(x, y, body.getAngle());
    }

    public void dispose() {
        body.getWorld().destroyBody(body);
    }

}
