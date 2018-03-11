package com.mystudio.gamename;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by deftone on 04.02.2018.
 */

public class PentagonObstacleBuilder extends ActorBuilder {
    public float defaultFriction = 0;
    public float defaultRestitution = 1;
    public float defaultDensity = 10;

    Figure getFigure(World world, Vector2 position, float ... params) {
        float radius;
        if (params.length == 1) {
            radius = params[0];
        } else {
            Random r = new Random();
            radius = (r.nextInt(MAX_SIZE - MIN_SIZE) + MIN_SIZE) / 2;
        }
        return new PolygonFigure(world, BodyDef.BodyType.DynamicBody,
                position, Helpers.calcRegularPolygonVertices(radius, 5),
                defaultFriction, defaultRestitution, defaultDensity);
    }

    ActorState getState() {
        return null;
    }

    public void actualizePosition() {}

    public Vector2[] calcVertices(float r, int n) {
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
