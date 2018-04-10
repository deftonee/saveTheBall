package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;

import ru.deftone.Actor;
import ru.deftone.Resources;

public class InactiveLevelExitState extends ActorState {

    public InactiveLevelExitState(Actor actor) {
        super(actor);
    }

    public Color getColor() {
        return Color.BLACK;
    }

    public void act(float delta) {
        Resources res = Resources.getInstance();
        if (res.goalAchieved())
            actor.setState(new LevelExitState(actor));
    }

}
