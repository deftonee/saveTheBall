package ru.deftone.actor_builders;

import com.badlogic.gdx.scenes.scene2d.Touchable;
import ru.deftone.Actor;
import ru.deftone.listeners.TouchListener;

/**
 * Created by deftone on 04.02.2018.
 */

public abstract class TouchableObstacleBuilder extends ActorBuilder {

    void postBuild (Actor actor) {
        super.postBuild(actor);
        actor.setTouchable(Touchable.enabled);
        actor.addListener(new TouchListener(actor));
    }

}
