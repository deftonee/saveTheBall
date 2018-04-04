package ru.deftone.figures;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.physics.box2d.World;

import ru.deftone.Actor;

/**
 * Created by deftone on 02.02.2018.
 */

public class CircleFigure extends Figure {

    public CircleFigure(Actor actor, World world, BodyDef.BodyType type,
                        Vector2 position, float radius,
                        float friction, float restitution, float density){
        super(actor);
        BodyDef def = new BodyDef();
        def.type = type;
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

    private float getRadius() {
        Shape shape = getShape();
        if (shape == null) {
            return 0;
        } else {
            return getShape().getRadius();

        }
    }

    public void draw(Batch batch, float parentAlpha) {

    }

    public float getWidth(){
        return getRadius();
    }

    public float getHeight(){
        return getRadius();
    }

    @Override
    public boolean contains(float x, float y) {
        Vector2 distance = new Vector2();
        distance.sub(x, y);
        return distance.len() <= getRadius();
    }

    @Override
    public void drawDebug(ShapeRenderer shapes) {
        Vector2 bodyPosition = body.getPosition();

        shapes.setColor(actor.getColor());
        shapes.circle(bodyPosition.x, bodyPosition.y, getRadius());

    }

}
