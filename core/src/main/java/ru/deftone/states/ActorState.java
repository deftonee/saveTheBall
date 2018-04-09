package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.deftone.Actor;

/**
 * Created by deftone on 03.02.2018.
 */



public abstract class ActorState {

    Actor actor;

    public ActorState(Actor actor) {
        this.actor = actor;
    }

    public void beginContact(Actor anotherActor) {}

    public void endContact(Actor anotherActor) {}

    public boolean touchDown(float x, float y) {
        return false;
    }

    public void touchDragged(float x, float y) {}

    public void touchUp(float x, float y) {}

    public Color getColor() {
        return Color.WHITE;
    }

    public boolean drawDebug(ShapeRenderer shapes) {
        return false;
    }

    public void act(float delta) {}

}

