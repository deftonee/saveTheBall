package ru.deftone.figures;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Shape2D;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by deftone on 02.02.2018.
 */



public interface Figure extends Disposable, Shape2D {

    Body getBody();

    float getWidth();

    float getHeight();

    Vector2 getPosition();

    void draw(Batch batch, float parentAlpha);

    void drawDebug(ShapeRenderer shapes);

    void moveToPosition(float x, float y);
}
