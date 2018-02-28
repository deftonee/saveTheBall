package com.mystudio.gamename;


import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by deftone on 28.01.2018.
 */

public class Actor extends Widget {

    private Figure figure;

    private ActorState state;

    Actor(Figure figure, ActorState state){
        this.figure = figure;
        this.state = state;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Figure getFigure(){
        return figure;
    }

    public ActorState getState() {
        return state;
    }

    public void setState(ActorState state) {
        this.state = state;
    }

    public void draw(Graphics g){
        figure.draw(g);
    }

    public Body getBody(){
        return figure.getBody();
    }

    public void act(float delta) {
        super.act(delta);

        Body body = getBody();

        this.setRotation(body.getAngle()*  MathUtils.radiansToDegrees);

        this.setPosition(
            body.getPosition().x - this.getWidth() / 2,
            body.getPosition().y - this.getHeight() / 2
        );
    }

    public float getWidth() {
        return figure.getWidth();
    }

    public float getHeight() {
        return figure.getHeight();
    }

    public void setPosition (float x, float y) {
        super.setPosition(x, y);
        figure.shape.setX(x);
        figure.shape.setY(y);
    }

}
