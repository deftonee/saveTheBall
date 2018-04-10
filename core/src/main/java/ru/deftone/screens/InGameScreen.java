package ru.deftone.screens;

import java.util.Random;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import ru.deftone.Actor;
import ru.deftone.Helpers;
import ru.deftone.actor_builders.ActorBuilder;
import ru.deftone.actor_builders.BallBuilder;
import ru.deftone.Resources;
import ru.deftone.actor_builders.CircleObstacleBuilder;
import ru.deftone.actor_builders.HexagonObstacleBuilder;
import ru.deftone.actor_builders.LevelExitBuilder;
import ru.deftone.actor_builders.PentagonObstacleBuilder;
import ru.deftone.actor_builders.RectangleObstacleBuilder;
import ru.deftone.actor_builders.StaticObstacleBuilder;
import ru.deftone.actor_builders.TriangleObstacleBuilder;
import ru.deftone.listeners.CollisionListener;
import ru.deftone.states.HelpfulState;


/**
 * Created by deftone on 28.01.2018.
 */

public class InGameScreen extends ScreenAdapter {
    float WALL_THICKNESS = 4;

    int FIGURE_NUMBER = 5;


    public static Class [] obstacleTypes = {
            RectangleObstacleBuilder.class,
            CircleObstacleBuilder.class,
            TriangleObstacleBuilder.class,
            PentagonObstacleBuilder.class,
            HexagonObstacleBuilder.class
    };

    public InGameScreen(Game game){

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

        Resources res = Resources.getInstance();

        res.createStage();
        res.setGoal(3);
        Gdx.input.setInputProcessor(res.getStage());

        World world = new World(new Vector2(0, 0), true);
        res.setWorld(world);
        world.setContactListener(new CollisionListener());

        res.setBall(
                new BallBuilder().build(
                        new Vector2(screenWidth / 2, screenHeight / 2), 25));

        ActorBuilder builder = new StaticObstacleBuilder();
        // upper
        res.addWall(builder.build(
                new Vector2(screenWidth / 2, -1 - WALL_THICKNESS / 2),
                screenWidth, WALL_THICKNESS
        ), 0);
        // bottom
        res.addWall(builder.build(
                new Vector2(screenWidth / 2, screenHeight + WALL_THICKNESS / 2 + 1),
                screenWidth, WALL_THICKNESS
        ), 1);
        // left
        res.addWall(builder.build(
                new Vector2(0 - WALL_THICKNESS / 2, screenHeight / 2),
                WALL_THICKNESS, screenHeight
        ), 2);
        // right
        res.addWall(builder.build(
                new Vector2(screenWidth + WALL_THICKNESS / 2 + 1, screenHeight / 2),
                WALL_THICKNESS, screenHeight
        ), 3);

        Random random = new Random();
        for (int i = 0; i < FIGURE_NUMBER; i++){
            try {
                builder = (ActorBuilder) obstacleTypes[
                        random.nextInt(obstacleTypes.length)].newInstance();
                res.addObstacle(builder.build());
            }
            catch (InstantiationException e) { e.printStackTrace(); }
            catch (IllegalAccessException e) { e.printStackTrace(); }
        }

        res.setLevelExit(new LevelExitBuilder().build());

        res.getBall().getBody().setLinearVelocity(new Vector2(10,20));

        res.getStage().getRoot().setDebug(true, true);

    }

    public void render(float delta) {
        Random random = new Random();

        Resources res = Resources.getInstance();
        res.getStage().act();
        int helpfulOnes = 0;

        for (Actor obstacle: res.getObstacles()) {
            if (obstacle.getState() instanceof HelpfulState)
                helpfulOnes++;
        }
        if (helpfulOnes < 2){
            Actor obstacle = res.getObstacles().get(random.nextInt(res.getObstacles().size()));
            obstacle.setState(new HelpfulState(obstacle));
        }

        res.getWorld().step(delta, 6, 2);

        res.draw();
    }

    public void dispose() {
        Resources.getInstance().dispose();
    }
}
