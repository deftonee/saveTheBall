package com.mystudio.gamename.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.ActorBuilder;
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
    Stage stage;
    Actor ball;
    Actor [] walls = new Actor[4];
    World world;

    public void initialise(GameContainer gc){
        world = new World(new Vector2(0, -20), true);
        stage = gc.createStage(new ScreenViewport());

        ball = new BallBuilder().build(world,
                gc.getWidth() / 2, gc.getHeight() / 2, 100);
        stage.addActor(ball);
        // upper

        ActorBuilder ob = new ObstacleBuilder();
        walls[0] = ob.build(world,
                0, 0, gc.getWidth(), WALL_THICKNESS);
        //bottom
        walls[1] = ob.build(world,
                0, gc.getHeight() - WALL_THICKNESS, gc.getWidth(), WALL_THICKNESS);
        //left
        walls[2] = ob.build(world,
                0, 0, WALL_THICKNESS, gc.getHeight());
        //right
        walls[3] = ob.build(world,
                gc.getWidth() - WALL_THICKNESS, 0, WALL_THICKNESS, gc.getHeight());

        for (Actor wall: walls){
            stage.addActor(wall);
        }


        ball.getBody().applyForceToCenter(300f, 200f, true);

    }

    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {
        stage.act();
        world.step(delta / 1000, 6, 2);
    }

    public void render(GameContainer gc, Graphics g){
//        stage.draw();
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
