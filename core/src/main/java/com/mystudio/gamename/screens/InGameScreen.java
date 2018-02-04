package com.mystudio.gamename.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.BallBuilder;
import com.mystudio.gamename.ObstacleBuilder;

import org.mini2Dx.core.game.GameContainer;
import org.mini2Dx.core.graphics.Graphics;
import org.mini2Dx.core.screen.BasicGameScreen;
import org.mini2Dx.core.screen.GameScreen;
import org.mini2Dx.core.screen.ScreenManager;


/**
 * Created by deftone on 28.01.2018.
 */

public class InGameScreen extends BasicGameScreen {
    public static final int ID = 1337;
    final float WALL_THICKNESS = 5;
    Actor ball;
    Actor [] walls = new Actor[4];

    public void initialise(GameContainer gc){
        World world = new World(new Vector2(0, -20), true);

        ball = BallBuilder.build(world, 10f);
//        ball.getFigure().getBody().applyForceToCenter(10f, 10f, true);
        // upper
        walls[0] = ObstacleBuilder.build(world,
                0, 0,
                gc.getWidth(), WALL_THICKNESS);
        //bottom
        walls[0] = ObstacleBuilder.build(world,
                0, gc.getHeight() - WALL_THICKNESS,
                gc.getWidth(), WALL_THICKNESS);
        //left
        walls[0] = ObstacleBuilder.build(world,
                0, 0,
                WALL_THICKNESS, gc.getHeight());
        //right
        walls[0] = ObstacleBuilder.build(world,
                gc.getWidth() - WALL_THICKNESS, 0,
                WALL_THICKNESS, gc.getHeight());

    }

    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {

    }

    public void render(GameContainer gc, Graphics g){
        g.setBackgroundColor(Color.WHITE);

        g.setLineHeight(4);
        g.setColor(Color.BLACK);
        ball.draw(g);

        for (Actor wall: walls){
            wall.draw(g);
        }
    }


    public void interpolate(GameContainer gc, float alpha){

    }

    public int getId(){
        return ID;
    }


}
