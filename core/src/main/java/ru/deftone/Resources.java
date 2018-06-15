package ru.deftone;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.Window;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ru.deftone.actor_builders.CircleObstacleBuilder;
import ru.deftone.actor_builders.HexagonObstacleBuilder;
import ru.deftone.actor_builders.PentagonObstacleBuilder;
import ru.deftone.actor_builders.RectangleObstacleBuilder;
import ru.deftone.actor_builders.TriangleObstacleBuilder;
import ru.deftone.screens.InGameScreen;

/**
 * Singleton that contains actors so everybody can access them from everywhere
 * Created by deftone on 28.02.2018.
 */

public class Resources implements Disposable {

    public enum ScreenEnum {

        FIRST {
            public Screen getScreen(Object... params) {
                return new InGameScreen(Resources.getInstance().game);
            }
        };
//        LEVEL_SELECT {
//            public AbstractScreen getScreen(Object... params) {
//                return new LevelSelectScreen();
//            }
//        },
//        GAME {
//            public AbstractScreen getScreen(Object... params) {
//                return new GameScreen((Integer) params[0]);
//            }
//        };

        public abstract Screen getScreen(Object... params);

        private static ScreenEnum[] vals = values();
        public ScreenEnum next()
        {
            return vals[(this.ordinal()+1) % vals.length];
        }
    }

    private static Resources instance;

    public MyGame getGame() {
        return game;
    }

    private MyGame game;

    private Stage stage;
    private World world;
    private Actor ball;
    private Actor levelExit;
    private Actor [] walls = new Actor[4];
    private List<Actor> obstacles = new ArrayList<Actor>(10);
    private Window menu;
    private int score = 0;
    private int goal = 0;

    public static Class [] obstacleTypes = {
        RectangleObstacleBuilder.class,
        CircleObstacleBuilder.class,
        TriangleObstacleBuilder.class,
        PentagonObstacleBuilder.class,
        HexagonObstacleBuilder.class
    };

    private Resources() {}

    public static Resources getInstance() {
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }

    public void initialize(MyGame game) {
        this.game = game;
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
        sv.setUnitsPerPixel(Helpers.toBox2d(1));
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
        System.out.println("Resources has been removed");
    }

    public void endLevel() {

    }

    public Window getMenu() {
        return menu;
    }

    public void setMenu(Window menu) {
        this.menu = menu;
        stage.addActor(menu);
    }


    public void showScreen(ScreenEnum screenEnum, Object... params) {

        // Get current screen to dispose it
        Screen currentScreen = game.getScreen();

        // Show new screen
        Screen newScreen = screenEnum.getScreen(params);
        game.setScreen(newScreen);

        // Dispose previous screen
        if (currentScreen != null) {
            currentScreen.dispose();
        }
    }

    Window createPauseWindow() {
        Skin skin = new Skin(Gdx.files.internal("vis/skin/x1/uiskin.json"));
        Window menu = new Window("Pause menu", skin);
        TextButton button = new TextButton("Close", skin);
        button.addListener( new ClickListener() {
            public boolean touchDown(InputEvent event, float x, float y, int pointer, int button) {
                game.resume();
                return false;
            }
        });
        menu.add(button);
        menu.setScale(0.3f);
        menu.setVisible(false);
        return menu;
    }
}

