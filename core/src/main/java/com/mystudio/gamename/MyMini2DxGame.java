package com.mystudio.gamename;

import com.mystudio.gamename.screens.InGameScreen;
import com.mystudio.gamename.screens.InitialScreen;

import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;


public class MyMini2DxGame extends ScreenBasedGame {

	public static final String GAME_IDENTIFIER = "com.mystudio.gamename";

	public void initialise() {

        this.addScreen(new InitialScreen());
        this.addScreen(new InGameScreen());

    }

    public int getInitialScreenId(){
	    return InGameScreen.ID;
    }

    public void update(float delta) {
        super.update(delta);
//        if (Gdx.input.isKeyJustPressed(Input.Keys.BACK)){
//            Gdx.app.exit();
//        }
    }
    
    public void interpolate(float alpha) {
        super.interpolate(alpha);

    }
    
    public void render(Graphics g) {
        super.render(g);

    }

    public void dispose() {
        try {
            Resources.getInstance().dispose();
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(1);
        }

    }



}
