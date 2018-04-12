package ru.deftone;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.Shape;

/**
 * Created by deftone on 12.03.2018.
 */

public class Helpers {

    final static float PPM = 10;

    public static Vector2[] calcRegularPolygonVertices(float r, int n) {
        Vector2 buffer = new Vector2(0, r);
        Vector2 [] result = new Vector2[n];
        for(int i = 0; i < n; i++) {
            buffer.rotate(360 / n);
            result[i] = new Vector2(buffer);
        }
        return result;
    }

    public static void moveActorToTarget(Actor actor, float targetX, float targetY) {
        Vector2 toTarget = new Vector2(targetX, targetY).sub(actor.getBody().getWorldCenter());
        toTarget.scl(4);
        actor.getBody().setLinearVelocity(toTarget);
    }

    public static float toBox2d(float x) {
        return x / PPM;
    }

    public static Vector2 toBox2d(Vector2 x) {
        return x.scl(1 / PPM);
    }

    public static Vector2[] toBox2d(Vector2[] x) {
        for (Vector2 v : x)
            v.scl(1 / PPM);
        return x;
    }

    public static Texture generateColoredTexture(Color color) {
        Pixmap pixmap = new Pixmap(1, 1, Pixmap.Format.RGB888);
        pixmap.setColor(color);
        pixmap.fill();
        Texture result = new Texture(pixmap);
        pixmap.dispose();
        return result;
    }

    public static Shape getShapeFromBody(Body body) {
        for (Fixture f: body.getFixtureList()) {
            if (f.getBody() == body) {
                return f.getShape();
            }
        }
        return null;
    }

    public static float[] changeVerticesRepresentation(Vector2[] vertices) {
        float[] result = new float[vertices.length * 2];
        for (int i = 0; i < vertices.length; i++) {
            result[2 * i] = vertices[i].x;
            result[2 * i + 1] = vertices[i].y;
        }
        return result;
    }

}
