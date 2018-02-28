package com.mystudio.gamename.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.mystudio.gamename.Actor;
import com.mystudio.gamename.Resources;

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

    private Box2DDebugRenderer debugRenderer;

    public void initialise(GameContainer gc){
        Resources res = Resources.getInstance(gc);

        debugRenderer = new Box2DDebugRenderer();

        res.ball.getBody().applyForceToCenter(300f, 20f, true);

        res.ball.getBody().applyAngularImpulse(20f, true);

    }

    public void update(GameContainer gc, ScreenManager<? extends GameScreen> screenManager, float delta) {

        try {
            Resources res = Resources.getInstance();
            res.stage.act();
            res.world.step(delta, 6, 2);

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }

    }

    public void render(GameContainer gc, Graphics g){
//        stage.draw();
        try {
            Resources res = Resources.getInstance();
            g.setBackgroundColor(Color.WHITE);
            g.setLineHeight(4);
            g.setColor(Color.BLACK);
            res.ball.draw(g);

            for (Actor wall: res.walls){
                wall.draw(g);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
    }


    public void interpolate(GameContainer gc, float alpha){

    }

    public int getId(){
        return ID;
    }


}
