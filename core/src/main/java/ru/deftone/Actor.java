package ru.deftone;


import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

import ru.deftone.figures.Figure;

/**
 * Created by deftone on 28.01.2018.
 */

public class Actor extends Widget {

    private Figure figure;

    private ActorState state;

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

    public void draw(Batch batch, float parentAlpha){
        figure.draw(batch, parentAlpha);
    }

    public void drawDebug(ShapeRenderer shapes) {
        figure.drawDebug(shapes);
    }

    public Body getBody(){
        return figure.getBody();
    }

    public void act(float delta) {
        super.act(delta);
        Vector2 position = figure.getPosition();
        setBounds(position.x, position.y, figure.getWidth(), figure.getHeight());
    }

    public float getWidth() {
        return figure.getWidth();
    }

    public float getHeight() {
        return figure.getHeight();
    }

    public Vector2 getPosition(){
        return figure.getPosition();
    }

    public void setPosition(float x, float y){
        figure.setPosition(x, y);
        super.setPosition(x, y);
    }

    public boolean contains(float x, float y) {
        return figure.contains(x, y);
    }
}
