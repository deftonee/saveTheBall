package ru.deftone;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Disposable;

/**
 * Created by deftone on 28.02.2018.
 */

public class Resources implements Disposable {

    private static Resources instance;

    public Stage stage;
    public World world;
    public Actor ball;
    public Actor [] walls = new Actor[4];
    public List<Actor> obstacles = new ArrayList<Actor>(10);
    public int score = 0;
    public int goal = 0;
//    public int time = 0;

    private Resources() {}

    public void draw() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        Gdx.gl.glEnable(GL20.GL_BLEND);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glDisable(GL20.GL_BLEND);

        stage.draw();

    }


    public static Resources getInstance() {
        if (instance == null){
            instance = new Resources();
        }
        return instance;
    }


    public void dispose() {
        stage.dispose();
        world.dispose();
    }


}
