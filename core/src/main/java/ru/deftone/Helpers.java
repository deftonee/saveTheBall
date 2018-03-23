package ru.deftone;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by deftone on 12.03.2018.
 */

public class Helpers {

    public static Vector2[] calcRegularPolygonVertices(float r, int n) {
        double radNextX = 0, radNextY = r;
        double polarX, polarY;
        double tempX, tempY;
        Vector2 [] result = new Vector2[n];

        for(int i = 0; i < n; i++)
        {
            polarX = 1 * Math.cos(Math.acos(-1.0) * 2 / n);
            polarY = 1 * Math.sin(Math.acos(-1.0) * 2 / n);
            tempX = radNextX * polarX - radNextY * polarY;
            tempY = radNextX * polarY + radNextY * polarX;
            radNextX = tempX;
            radNextY = tempY;
            result[i] = new Vector2((float)radNextX, (float)radNextY);
        }
        return result;
    }

}
