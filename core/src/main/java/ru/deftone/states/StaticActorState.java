package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;

import ru.deftone.Actor;

public class StaticActorState extends ActorState {

    public StaticActorState(Actor actor) {
        super(actor);
    }

    public Color getColor() {
        return Color.WHITE;
    }

}
