package ru.deftone;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.ui.Widget;
import com.badlogic.gdx.utils.Disposable;

import ru.deftone.figures.Figure;
import ru.deftone.states.ActorState;
import ru.deftone.states.BallState;

/**
 * All objects in game must be inherited from this.
 * All drawing work is delegated to {@link Figure} instance
 * Behavior must be defined with {@link ActorState} instance
 * Created by deftone on 28.01.2018.
 */

public class Actor extends Widget implements Disposable {

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
        if (!state.drawDebug(shapes))
            figure.drawDebug(shapes);
    }

    public Body getBody(){
        return figure.getBody();
    }




    public void act(float delta) {
        super.act(delta);
        state.act(delta);
        Vector2 position = figure.getPosition();
        setBounds(position.x, position.y, getWidth(), getHeight());
    }

    public float getWidth() {
        float result = super.getWidth();
        if (result == 0)
            result = figure.getWidth();
        return result;
    }

    public float getHeight() {
        float result = super.getHeight();
        if (result == 0)
            result = figure.getHeight();
        return result;
    }

    public Vector2 getPosition(){
        return figure.getPosition();
    }

    public void moveToPosition(float x, float y){
        figure.moveToPosition(x, y);
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

    public boolean isBall() {
        return state instanceof BallState;
    }

    public float maxX() {
        return getPosition().x + getWidth() / 2;
    }

    public float minX() {
        return getPosition().x - getWidth() / 2;
    }

    public float maxY() {
        return getPosition().y + getHeight() / 2;
    }

    public float minY() {
        return getPosition().y - getHeight() / 2;
    }

    public void dispose() {
        figure.dispose();
    }

}
