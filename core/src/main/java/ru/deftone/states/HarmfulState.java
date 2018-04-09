package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import ru.deftone.Actor;
import ru.deftone.Helpers;
import ru.deftone.Resources;

public class HarmfulState extends ActorState {

    public HarmfulState(Actor actor) {
        super(actor);
    }

    public boolean touchDown(float x, float y) {
        actor.getBody().setAngularVelocity(0);
        return true;
    }

    public void touchDragged(float x, float y) {
        Helpers.moveActorToTarget(actor, x, y);
    }

    public Color getColor() {
        return Color.RED;
    }

    public void beginContact(Actor anotherActor) {
        if (anotherActor.isBall())
            Resources.getInstance().decScore();
    }

}
