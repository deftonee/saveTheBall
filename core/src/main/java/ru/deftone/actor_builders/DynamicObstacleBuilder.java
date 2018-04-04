package ru.deftone.actor_builders;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import ru.deftone.Actor;
import ru.deftone.listeners.TouchListener;
import ru.deftone.states.ActorState;
import ru.deftone.states.HarmfulState;

/**
 * Created by deftone on 04.02.2018.
 */

public abstract class DynamicObstacleBuilder extends ActorBuilder {
    public float defaultFriction = 1;
    public float defaultRestitution = 1;
    public float defaultDensity = 3;


    ActorState getState(Actor actor) {
        return new HarmfulState(actor);
    }


    void postBuild (Actor actor) {
        super.postBuild(actor);
        actor.setTouchable(Touchable.enabled);
        actor.addListener(new TouchListener(actor));
    }

}
