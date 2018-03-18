package com.mystudio.gamename.listeners;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.mystudio.gamename.Actor;

/**
 * Created by deftone on 18.03.2018.
 */

public class TouchListener extends InputListener {
    Actor actor;

    public TouchListener(Actor actor) {
        this.actor = actor;
    }

    public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        actor.setPosition(event.getStageX(), event.getStageY());
        System.out.println("TestActor.touchDown()");
        return true;  // must return true for touchUp event to occur
    }

    public void touchDragged (InputEvent event, float x, float y, int pointer) {
        actor.setPosition(event.getStageX(), event.getStageY());
        System.out.println("TestActor.touchDragged()");
    }

    public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
        System.out.println("TestActor.touchUp()");
    }


}
