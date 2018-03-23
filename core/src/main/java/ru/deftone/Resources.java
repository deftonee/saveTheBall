package ru.deftone;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;

/**
 * Created by deftone on 28.02.2018.
 */

public class Resources {

    private static Resources instance;

    public Stage stage;
    public World world;
    public Actor ball;
    public Actor [] walls = new Actor[4];
    public List<Actor> obstacles = new ArrayList<Actor>(10);
    public int score = 0;
    public int goal = 0;
//    public int time = 0;

    private Resources(){}

    public void draw(){
//        g.setBackgroundColor(Color.WHITE);
//        g.setLineHeight(4);
//        g.setColor(Color.BLUE);
//        ball.draw(g);
//
//        g.setColor(Color.BLACK);
//
//        for (Actor wall: walls){
//            wall.draw(g);
//        }
//
//        for (Actor obstacle: obstacles){
//            obstacle.draw(g);
//        }

    }


    public static Resources getInstance(){
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
