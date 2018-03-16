package com.mystudio.gamename.screens;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.actor_builders.ActorBuilder;
import com.mystudio.gamename.actor_builders.BallBuilder;
import com.mystudio.gamename.Resources;
import com.mystudio.gamename.actor_builders.CircleObstacleBuilder;
import com.mystudio.gamename.actor_builders.HexagonObstacleBuilder;
import com.mystudio.gamename.actor_builders.PentagonObstacleBuilder;
import com.mystudio.gamename.actor_builders.RectangleObstacleBuilder;
import com.mystudio.gamename.actor_builders.StaticObstacleBuilder;
import com.mystudio.gamename.actor_builders.TriangleObstacleBuilder;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;

import java.util.Random;


/**
 * Created by deftone on 28.01.2018.
 */

public class InGameScreen extends BasicGameScreen {
    public static final int ID = 1337;
    int WALL_THICKNESS = 5;

    // TODO remove it
    private Box2DDebugRenderer debugRenderer;

    public static Class [] obstacleTypes = {
            RectangleObstacleBuilder.class,
            CircleObstacleBuilder.class,
            TriangleObstacleBuilder.class,
            PentagonObstacleBuilder.class,
            HexagonObstacleBuilder.class
    };
    int FIGURE_NUMBER = 7;

    public void initialise(GameContainer gc){
        debugRenderer = new Box2DDebugRenderer();

        Resources res = Resources.getInstance();

        ScreenViewport sv = new ScreenViewport();
        res.stage = gc.createStage(sv);

        res.world = new World(new Vector2(0, 0), true);

        res.ball = new BallBuilder().build(
                new Vector2(gc.getWidth() / 2, gc.getHeight() / 2), 50);
        res.stage.addActor(res.ball);

        ActorBuilder sob = new StaticObstacleBuilder();
        // upper
        res.walls[0] = sob.build(
                new Vector2(gc.getWidth() / 2, WALL_THICKNESS / 2),
                gc.getWidth(), WALL_THICKNESS);
        //bottom
        res.walls[1] = sob.build(
                new Vector2(gc.getWidth() / 2, gc.getHeight() - WALL_THICKNESS / 2),
                gc.getWidth(), WALL_THICKNESS);
        //left
        res.walls[2] = sob.build(
                new Vector2(WALL_THICKNESS / 2, gc.getHeight() / 2),
                WALL_THICKNESS, gc.getHeight());
        //right
        res.walls[3] = sob.build(
                new Vector2(gc.getWidth() - WALL_THICKNESS / 2, gc.getHeight() / 2),
                WALL_THICKNESS, gc.getHeight());

        for (Actor wall: res.walls){
            res.stage.addActor(wall);
        }

        Random r = new Random();

        for (int i = 0; i < FIGURE_NUMBER; i++){
            try {
                ActorBuilder builder = (ActorBuilder) obstacleTypes[
                        r.nextInt(obstacleTypes.length)].newInstance();
                Actor obstacle = builder.build(new Vector2(
                        r.nextInt(gc.getWidth() - builder.MAX_SIZE) + builder.MAX_SIZE,
                        r.nextInt(gc.getWidth() - builder.MAX_SIZE) + builder.MAX_SIZE
                ));
                res.obstacles.add(obstacle);
                res.stage.addActor(obstacle);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

//        res.ball.getBody().applyForceToCenter(300f, 2000f, true);
//        res.ball.getBody().applyAngularImpulse(20f, true);
        res.ball.getBody().setLinearVelocity(new Vector2(3000,8000));

    }

    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        Resources res = Resources.getInstance();
        res.stage.act();
        res.world.step(delta, 6, 2);

    }

    public void render(GameContainer gc, Graphics g){
        Resources res = Resources.getInstance();
        debugRenderer.render(res.world, g.getProjectionMatrix());
        res.draw(gc, g);
    }


    public void interpolate(GameContainer gc, float alpha){

    }

    public int getId(){
        return ID;
    }


}
