package ru.deftone.states;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import ru.deftone.Actor;
import ru.deftone.Resources;
import ru.deftone.figures.CircleFigure;

/**
 * Use only in BallBuilder with CircleFigure
 */
public class BallState extends ActorState {

    public BallState(Actor actor) {
        super(actor);
    }

    public Color getColor() {
        return Color.WHITE;
    }

    public boolean drawDebug(ShapeRenderer shapes) {
        Vector2 bodyPosition = actor.getBody().getPosition();
        Resources res = Resources.getInstance();
        float radius = ((CircleFigure) actor.getFigure()).getRadius();
        shapes.setColor(Color.BLUE);
        shapes.arc(
                bodyPosition.x, bodyPosition.y, radius,
                0, res.getScore() / res.getGoal() * 360);
        shapes.setColor(Color.WHITE);
        shapes.arc(
                bodyPosition.x, bodyPosition.y, radius,
                res.getScore() / res.getGoal() * 360, (1 - res.getScore() / res.getGoal()) * 360);
        return true;
    }
}
