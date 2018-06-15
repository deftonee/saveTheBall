package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import ru.deftone.Actor;

/**
 * Allows game objects behave differently on some game events
 * Created by deftone on 03.02.2018.
 */



public abstract class ActorState {

    Actor actor;

    public ActorState(Actor actor) {
        this.actor = actor;
    }

    // methods responsible for physics
    public void beginContact(Actor anotherActor) {}
    public void endContact(Actor anotherActor) {}

    // methods responsible for touch control
    public boolean touchDown(float x, float y) {
        return false;
    }
    public void touchDragged(float x, float y) {}
    public void touchUp(float x, float y) {}

    // methods responsible for drawing on screen
    public Color getColor() {
        return Color.WHITE;
    }
    public boolean drawDebug(ShapeRenderer shapes) {
        return false;
    }

    // executes every game cycle iteration
    public void act(float delta) {}

}

