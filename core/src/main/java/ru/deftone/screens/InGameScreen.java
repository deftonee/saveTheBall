package ru.deftone.screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import java.util.Random;
import ru.deftone.Actor;
import ru.deftone.MyGame;
import ru.deftone.Resources;
import ru.deftone.actor_builders.ActorBuilder;
import ru.deftone.actor_builders.BallBuilder;
import ru.deftone.actor_builders.CircleObstacleBuilder;
import ru.deftone.actor_builders.HexagonObstacleBuilder;
import ru.deftone.actor_builders.LevelExitBuilder;
import ru.deftone.actor_builders.PentagonObstacleBuilder;
import ru.deftone.actor_builders.RectangleObstacleBuilder;
import ru.deftone.actor_builders.StaticObstacleBuilder;
import ru.deftone.actor_builders.TriangleObstacleBuilder;
import ru.deftone.listeners.CollisionListener;
import ru.deftone.listeners.GestureListener;
import ru.deftone.states.HelpfulState;


/**
 * Created by deftone on 28.01.2018.
 */

public class InGameScreen extends ScreenAdapter {
    private int FIGURE_NUMBER = 5;
    private float WALL_THICKNESS = 4;

    public InGameScreen(Game game) {

        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        Resources res = Resources.getInstance();

        res.createStage();
        res.setGoal(3);
        InputMultiplexer im = new InputMultiplexer();
        im.addProcessor(new GestureDetector(new GestureListener(this)));
        im.addProcessor(res.getStage());
        Gdx.input.setInputProcessor(im);

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
                builder = (ActorBuilder) Resources.obstacleTypes[
                        random.nextInt(Resources.obstacleTypes.length)].newInstance();
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

        Resources res = Resources.getInstance();

        if (res.getGame().getState() == MyGame.GameState.Running) {
            Random random = new Random();

            int helpfulOnes = 0;

            for (Actor obstacle : res.getObstacles()) {
                if (obstacle.getState() instanceof HelpfulState)
                    helpfulOnes++;
            }
            if (helpfulOnes < 2) {
                Actor obstacle = res.getObstacles().get(random.nextInt(res.getObstacles().size()));
                obstacle.setState(new HelpfulState(obstacle));
            }

            res.getWorld().step(delta, 6, 2);
            res.getStage().act(delta);
        }

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glDisable(GL20.GL_BLEND);
        res.getStage().draw();
    }

    public void resize(int width, int height) {
        super.resize(width, height);
    }

    public void dispose() {
        Resources.getInstance().dispose();
    }
}
