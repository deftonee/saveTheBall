package ru.deftone.figures;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;

/**
 * Created by deftone on 02.02.2018.
 */



public abstract class Figure {

//    Shape shape;
    Body body;

//    public Shape getShape() {
//        return shape;
//    }

    public Body getBody(){
        return body;
    }

    public void draw(){
//        shape.draw();
    };

    public float getWidth(){
//        return shape.getMaxX() - shape.getMinX();
        return 0f;
    }

    public float getHeight(){
//        return shape.getMaxY() - shape.getMinY();
        return 0f;
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
