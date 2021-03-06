package ru.deftone.states;

import ru.deftone.Actor;
import ru.deftone.Resources;

public class InactiveLevelExitState extends ActorState {

    public InactiveLevelExitState(Actor actor) {
        super(actor);
        actor.setVisible(false);
    }

    public void act(float delta) {
        Resources res = Resources.getInstance();
        if (res.goalAchieved())
            actor.setState(new LevelExitState(actor));
    }

}
