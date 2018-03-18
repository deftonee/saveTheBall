package com.mystudio.gamename.figures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

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
        return shape.getMaxX() - shape.getMinX();
    }

    public float getHeight(){
        return shape.getMaxY() - shape.getMinY();
    }

    public abstract void actualizePosition();

    public Vector2 getPosition(){
        return body.getPosition();
    }

    public void setPosition(float x, float y){
        body.setTransform(x, y, body.getAngle());
        actualizePosition();
    }
}
