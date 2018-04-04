package ru.deftone;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;

import ru.deftone.figures.Figure;
import ru.deftone.states.ActorState;

/**
 * Created by deftone on 28.01.2018.
 */

public class Actor extends Widget {

    private Figure figure;

    private ru.deftone.states.ActorState state;

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Figure getFigure(){
        return figure;
    }

    public ru.deftone.states.ActorState getState() {
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

    public com.badlogic.gdx.scenes.scene2d.Actor hit (float x, float y, boolean touchable) {
        if (touchable && getTouchable() != Touchable.enabled) return null;
        return figure.contains(x, y) ? this : null;

    }

    public void beginContact(Actor anotherActor) {
        state.beginContact(anotherActor);
    }

    public void endContact(Actor anotherActor) {
        state.endContact(anotherActor);
    }

    public boolean touchDown(float x, float y) {
        return state.touchDown(x, y);
    }

    public void touchDragged(float x, float y) {
        state.touchDragged(x, y);
    }

    public void touchUp(float x, float y) {
        state.touchUp(x, y);
    }

    public Color getColor() {
        return state.getColor();
    }

}
