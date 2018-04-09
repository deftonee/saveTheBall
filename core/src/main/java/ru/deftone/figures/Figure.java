package ru.deftone.figures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Shape;
import com.badlogic.gdx.utils.Disposable;

import ru.deftone.Actor;

/**
 * Created by deftone on 02.02.2018.
 */



public abstract class Figure implements Disposable {

    Body body;
    Actor actor;

    public Figure(Actor actor) {
        this.actor = actor;
    }

    public Body getBody() {
        return body;
    }

    Shape getShape() {
        for (Fixture f: body.getFixtureList()) {
            if (f.getBody() == body) {
                return f.getShape();
            }
        }
        return null;
    }

    public abstract void draw(Batch batch, float parentAlpha);

    public float getWidth() {
        return 0f;
    }

    public float getHeight() {
        return 0f;
    }

    public Vector2 getPosition() {
        return body.getPosition();
    }

    public void setPosition(float x, float y) {
        body.setTransform(x, y, body.getAngle());
    }

    public abstract boolean contains(float x, float y);

    public abstract void drawDebug(ShapeRenderer shapes);

    public void dispose() {
        body.getWorld().destroyBody(body);
    }
}
