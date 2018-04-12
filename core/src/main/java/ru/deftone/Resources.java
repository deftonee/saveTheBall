package ru.deftone;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

/**
 * Created by deftone on 28.02.2018.
 */

public class Resources implements Disposable {

    private static Resources instance;

    private Stage stage;
    private World world;
    private Actor ball;
    private Actor levelExit;
    private Actor [] walls = new Actor[4];
    private List<Actor> obstacles = new ArrayList<Actor>(10);
    private int score = 0;
    private int goal = 0;

    private Resources() {}

    public static Resources getInstance() {
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }

    public Actor getBall() {
        return ball;
    }

    public void setBall(Actor ball) {
        if (ball != null) {
            this.ball = ball;
            stage.addActor(ball);
        } else if (this.ball != null) {
            stage.getRoot().removeActor(this.ball);
            this.ball.dispose();
        }
    }

    public Actor getLevelExit() {
        return levelExit;
    }

    public void setLevelExit(Actor levelExit) {

        if (levelExit != null) {
            this.levelExit = levelExit;
            stage.addActor(levelExit);
        } else if (this.levelExit != null) {
            stage.getRoot().removeActor(this.levelExit);
            this.levelExit.dispose();
        }
    }

    public Actor[] getWalls() {
        return walls;
    }

    public void addWall(Actor wall, int index) {
        this.walls[index] = wall;
        stage.addActor(wall);
    }

    public List<Actor> getObstacles() {
        return obstacles;
    }

    public void addObstacle(Actor obstacle) {
        this.obstacles.add(obstacle);
        stage.addActor(obstacle);
    }

    public void incScore() {
        if (score < goal)
            score++;
    }

    public void decScore() {
        if (score > 0)
            score--;
    }

    public Stage getStage() {
        return stage;
    }

    public void createStage() {
        ScreenViewport sv = new ScreenViewport();
        sv.setUnitsPerPixel(Helpers.toBox2d(sv.getUnitsPerPixel()));
        stage = new Stage(sv);
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public int getScore() {
        return score;
    }

    public int getGoal() {
        return goal;
    }

    public boolean goalAchieved() {
        return score == goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public void dispose() {
        stage.dispose();
        world.dispose();
    }
}
