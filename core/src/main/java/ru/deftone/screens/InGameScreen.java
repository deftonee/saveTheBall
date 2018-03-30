package ru.deftone.screens;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import ru.deftone.Actor;
import ru.deftone.actor_builders.ActorBuilder;
import ru.deftone.actor_builders.BallBuilder;
import ru.deftone.Resources;
import ru.deftone.actor_builders.CircleObstacleBuilder;
import ru.deftone.actor_builders.HexagonObstacleBuilder;
import ru.deftone.actor_builders.PentagonObstacleBuilder;
import ru.deftone.actor_builders.RectangleObstacleBuilder;
import ru.deftone.actor_builders.StaticObstacleBuilder;
import ru.deftone.actor_builders.TriangleObstacleBuilder;


/**
 * Created by deftone on 28.01.2018.
 */

public class InGameScreen extends ScreenAdapter {
    float WALL_THICKNESS = 4;

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

    public InGameScreen(Game game){
        debugRenderer = new Box2DDebugRenderer();

        Resources res = Resources.getInstance();

        ScreenViewport sv = new ScreenViewport();
        res.stage = new Stage(sv);

        Gdx.input.setInputProcessor(res.stage);

        res.world = new World(new Vector2(0, 0), true);

        int screenWidth = Gdx.graphics.getWidth(), screenHeight = Gdx.graphics.getHeight();

        res.ball = new BallBuilder().build(
                new Vector2(screenWidth / 2, screenHeight / 2), 20);
        res.stage.addActor(res.ball);


        ActorBuilder builder = new StaticObstacleBuilder();
        // upper
        res.walls[0] = builder.build(
                new Vector2(screenWidth / 2, WALL_THICKNESS / 2),
                screenWidth, WALL_THICKNESS);
        //bottom
        res.walls[1] = builder.build(
                new Vector2(screenWidth / 2, screenHeight - WALL_THICKNESS / 2),
                screenWidth, WALL_THICKNESS);
        //left
        res.walls[2] = builder.build(
                new Vector2(WALL_THICKNESS / 2, screenHeight / 2),
                WALL_THICKNESS, screenHeight);
        //right
        res.walls[3] = builder.build(
                new Vector2(screenWidth - WALL_THICKNESS / 2, screenHeight / 2),
                WALL_THICKNESS, screenHeight);

        for (Actor wall: res.walls){
            res.stage.addActor(wall);
        }

        Random r = new Random();

        for (int i = 0; i < FIGURE_NUMBER; i++){
            try {
                builder = (ActorBuilder) obstacleTypes[
                        r.nextInt(obstacleTypes.length)].newInstance();
                Actor obstacle = builder.build(new Vector2(
                        r.nextInt(screenWidth - builder.MAX_SIZE) + builder.MAX_SIZE,
                        r.nextInt(screenWidth - builder.MAX_SIZE) + builder.MAX_SIZE
                ));
                res.obstacles.add(obstacle);
                res.stage.addActor(obstacle);
            }
            catch (InstantiationException e) { e.printStackTrace(); }
            catch (IllegalAccessException e) { e.printStackTrace(); }
        }

//        res.ball.getBody().applyForceToCenter(300f, 2000f, true);
//        res.ball.getBody().applyAngularImpulse(200f, true);
        res.ball.getBody().setLinearVelocity(new Vector2(30000,800000));

        res.stage.getRoot().setDebug(true, true);

    }

    public void render(float delta) {
        Resources res = Resources.getInstance();
        res.stage.act();
        res.world.step(delta, 6, 2);

        debugRenderer.render(res.world, res.stage.getCamera().combined);

        res.draw();
    }

    public void dispose() {
        Resources.getInstance().dispose();
    }
}
