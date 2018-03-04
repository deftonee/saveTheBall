package com.mystudio.gamename;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by deftone on 28.02.2018.
 */

public class Resources {

    private static Resources instance;

    int WALL_THICKNESS = 5;
    int OBSTACLE_MIN_SIZE = 50;
    int OBSTACLE_MAX_SIZE = 150;

    GameContainer gc;
    public Stage stage;
    public World world;
    public Actor ball;
    public Actor [] walls = new Actor[4];
    public List<Actor> obstacles = new ArrayList<Actor>(10);

    private Resources(GameContainer gc){
        this.gc = gc;

        stage = gc.createStage(new ScreenViewport());

        world = new World(new Vector2(0, 0), true);

        ball = new BallBuilder().build(world,
                gc.getWidth() / 2, gc.getHeight() / 2, 50);
        stage.addActor(ball);

        ActorBuilder sob = new StaticObstacleBuilder();
        // upper
        walls[0] = sob.build(world,
                gc.getWidth() / 2, WALL_THICKNESS / 2,
                gc.getWidth(), WALL_THICKNESS);
        //bottom
        walls[1] = sob.build(world,
                gc.getWidth() / 2, gc.getHeight() - WALL_THICKNESS / 2,
                gc.getWidth(), WALL_THICKNESS);
        //left
        walls[2] = sob.build(world,
                WALL_THICKNESS / 2, gc.getHeight() / 2,
                WALL_THICKNESS, gc.getHeight());
        //right
        walls[3] = sob.build(world,
                gc.getWidth() - WALL_THICKNESS / 2, gc.getHeight() / 2,
                WALL_THICKNESS, gc.getHeight());

        for (Actor wall: walls){
            stage.addActor(wall);
        }

    }

    public void addRandomObstacle(){
        Random r = new Random();
        obstacles.add(new RectangleObstacleBuilder().build(
                world,
                r.nextInt(gc.getWidth() - 2 * WALL_THICKNESS) + WALL_THICKNESS,
                r.nextInt(gc.getWidth() - 2 * WALL_THICKNESS) + WALL_THICKNESS,
                r.nextInt(OBSTACLE_MAX_SIZE - OBSTACLE_MIN_SIZE) + OBSTACLE_MIN_SIZE,
                r.nextInt(OBSTACLE_MAX_SIZE - OBSTACLE_MIN_SIZE) + OBSTACLE_MIN_SIZE
        ));
    }

    public void draw(GameContainer gc, Graphics g){
        g.setBackgroundColor(Color.WHITE);
        g.setLineHeight(4);
        g.setColor(Color.BLACK);
        ball.draw(g);

        for (Actor wall: walls){
            wall.draw(g);
        }

        for (Actor obstacle: obstacles){
            obstacle.draw(g);
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
