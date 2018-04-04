package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;

import ru.deftone.Actor;

public class BallState extends ActorState {

    public BallState(Actor actor) {
        super(actor);
    }

    public boolean touchDown(float x, float y) {
        return false;
    }

    public Color getColor() {
        return Color.WHITE;
    }
}
