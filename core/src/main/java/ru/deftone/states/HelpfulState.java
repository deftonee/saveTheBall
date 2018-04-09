package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import ru.deftone.Actor;
import ru.deftone.Helpers;
import ru.deftone.Resources;

public class HelpfulState extends ActorState {

    public HelpfulState(Actor actor) {
        super(actor);
    }

    public boolean touchDown(float x, float y) {
        actor.getBody().setAngularVelocity(0);
        return true;
    }


    public void touchDragged(float x, float y) {
        Helpers.moveActorToTarget(actor, x, y);
    }

    public void beginContact(Actor anotherActor) {
        if (anotherActor.isBall()) {
            actor.setState(new HarmfulState(actor));
            Resources.getInstance().incScore();
        }
    }

    public void endContact(Actor anotherActor) {

    }

    public Color getColor() {
        return Color.GREEN;
    }

}
