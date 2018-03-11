package com.mystudio.gamename;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.PolygonShape;

import org.mini2Dx.core.geom.Shape;
import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by deftone on 02.02.2018.
 */

public abstract class Figure {

    Shape shape;
    Body body;

    public Shape getShape() {
        return shape;
    }

    public Body getBody(){
        return body;
    }

    public void draw(Graphics g){
        shape.draw(g);
    };

    public float getWidth(){
        return 0;
    }

    public float getHeight(){
        return 0;
    }

    public abstract void actualizePosition();

    public static Vector2 [] getVertices(Fixture f, Vector2 origin){
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
