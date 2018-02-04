package com.mystudio.gamename;

import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import org.mini2Dx.core.geom.Parallelogram;
import org.mini2Dx.core.geom.Rectangle;

/**
 * Created by deftone on 02.02.2018.
 */

public class RectangleFigure extends Figure {

    public RectangleFigure(World world, BodyDef.BodyType type,
                           float x, float y, float width, float height){
        BodyDef def = new BodyDef();
        def.type = type;
        body = world.createBody(def);

        shape = new Rectangle(x, y, width, height);

        PolygonShape bodyShape = new PolygonShape();
        bodyShape.setAsBox(((Parallelogram)shape).getWidth(), ((Parallelogram) shape).getHeight());
        body.createFixture(bodyShape, 1);
        bodyShape.dispose();

    }

}
