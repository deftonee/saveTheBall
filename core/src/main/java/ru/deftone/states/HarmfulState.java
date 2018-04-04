package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

import ru.deftone.Actor;

public class HarmfulState extends ActorState {

    public HarmfulState(Actor actor) {
        super(actor);
    }

    public boolean touchDown(float x, float y) {
        return true;
    }

    void moveToTarget(float targetX, float targetY) {
        Vector2 toTarget = new Vector2(targetX, targetY).sub(actor.getBody().getWorldCenter());
        toTarget.scl(4);
        actor.getBody().setLinearVelocity(toTarget);
        actor.getBody().setAngularVelocity(0);
    }

    public void touchDragged(float x, float y) {
        moveToTarget(x, y);
    }

    public Color getColor() {
        return Color.RED;
    }
}
