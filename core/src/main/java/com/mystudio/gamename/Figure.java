package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.Body;

import org.mini2Dx.core.geom.Shape;
import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by deftone on 02.02.2018.
 */

public class Figure {

    Shape shape;
    Body body;

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


}
