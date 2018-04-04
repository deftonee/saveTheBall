package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;

import ru.deftone.Actor;

public class HelpfulState extends ActorState {

    public HelpfulState(Actor actor) {
        super(actor);
    }

    public void endContact(Actor anotherActor) {
        if (anotherActor.getState() instanceof BallState) {
            actor.setState(new HarmfulState(actor));
        }
    }

    public Color getColor() {
        return Color.GREEN;
    }

}
