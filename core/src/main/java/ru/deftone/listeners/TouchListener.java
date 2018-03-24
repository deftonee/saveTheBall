package ru.deftone.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.deftone.Actor;

/**
 * Created by deftone on 18.03.2018.
 */

public class TouchListener extends InputListener {
    Actor actor;

    public TouchListener(Actor actor) {
        this.actor = actor;
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        return actor.contains(event.getStageX(), event.getStageY());
    }

    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        actor.setPosition(event.getStageX(), event.getStageY());
    }

    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
    }


}
