package com.mystudio.gamename;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import org.mini2Dx.core.game.GameContainer;

/**
 * Created by deftone on 28.02.2018.
 */

public class Resources {

    private static Resources instance;

    float WALL_THICKNESS = 5;
    public Stage stage;
    public World world;
    public Actor ball;
    public Actor [] walls = new Actor[4];

    private Resources(GameContainer gc){

        stage = gc.createStage(new ScreenViewport());

        world = new World(new Vector2(0, 0), true);

        ball = new BallBuilder().build(world,
                gc.getWidth() / 2, gc.getHeight() / 2, 50);
        stage.addActor(ball);

        ActorBuilder ob = new ObstacleBuilder();
        // upper
        walls[0] = ob.build(world,
                gc.getWidth() / 2, WALL_THICKNESS / 2,
                gc.getWidth(), WALL_THICKNESS);
        //bottom
        walls[1] = ob.build(world,
                gc.getWidth() / 2, gc.getHeight() - WALL_THICKNESS / 2,
                gc.getWidth(), WALL_THICKNESS);
        //left
        walls[2] = ob.build(world,
                WALL_THICKNESS / 2, gc.getHeight() / 2,
                WALL_THICKNESS, gc.getHeight());
        //right
        walls[3] = ob.build(world,
                gc.getWidth() - WALL_THICKNESS / 2, gc.getHeight() / 2,
                WALL_THICKNESS, gc.getHeight());

        for (Actor wall: walls){
            stage.addActor(wall);
        }

    }

    public static Resources getInstance(GameContainer gc){
        if (instance == null){
            instance = new Resources(gc);
        }
        return instance;
    }

    public static Resources getInstance() throws Exception {
        if (instance == null){
            throw new Exception("Game resources isn't initialized!");
        }
        return instance;
    }

    public void dispose() {
        stage.dispose();
    }


}
