package ru.deftone.listeners;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import ru.deftone.Actor;

/**
 * Created by deftone on 18.03.2018.
 */

public class TouchListener extends InputListener {
    Actor actor;
    float touchX, touchY;

    public TouchListener(Actor actor) {
        this.actor = actor;
    }

    public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
        touchX = x;
        touchY = y;
        return actor.touchDown(event.getStageX() - touchX, event.getStageY() - touchY);
    }

    public void touchDragged(InputEvent event, float x, float y, int pointer) {
        actor.touchDragged(event.getStageX() - touchX, event.getStageY() - touchY);
    }

    public void touchUp(InputEvent event, float x, float y, int pointer, int button) {
        actor.touchUp(event.getStageX() - touchX, event.getStageY() - touchY);
    }

}
