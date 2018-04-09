package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;

import ru.deftone.Actor;
import ru.deftone.Resources;

public class LevelExitState extends ActorState {

    public LevelExitState(Actor actor) {
        super(actor);
    }

    public Color getColor() {
        return Color.YELLOW;
    }

    public void act(float delta) {
        Resources res = Resources.getInstance();
        Actor ball = res.getBall();
        if (ball.maxX() < actor.maxX() &&
                ball.minX() > actor.minX() &&
                ball.maxY() < actor.maxY() &&
                ball.minY() > actor.minY()) {
            System.out.println("WIN!!!");
        }
    }

}
