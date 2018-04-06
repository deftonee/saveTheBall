package ru.deftone;

import com.badlogic.gdx.math.Vector2;

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

    public static boolean insidePolygon(float[] xArray, float[] yArray, float x, float y) {
        int n = xArray.length;
        int i, j;
        boolean result = false;
        for (i = 0, j = n - 1; i < n; j = i++) {
            if (((yArray[i] > y) != (yArray[j] > y)) &&
                    (x < (xArray[j] - xArray[i]) * (y - yArray[i]) / (yArray[j] - yArray[i]) + xArray[i]))
                result = !result;
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


}
