package com.mystudio.gamename;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.mystudio.gamename.screens.InGameScreen;
import com.mystudio.gamename.screens.InitialScreen;

import org.mini2Dx.core.game.ScreenBasedGame;
import org.mini2Dx.core.graphics.Graphics;

public class MyMini2DxGame extends ScreenBasedGame {
	public static final String GAME_IDENTIFIER = "com.mystudio.gamename";

	@Override
    public void initialise() {

        this.addScreen(new InitialScreen());
        this.addScreen(new InGameScreen());

    }

    public int getInitialScreenId(){
	    return InGameScreen.ID;
    }

    @Override
    public void update(float delta) {
        super.update(delta);

    }
    
    @Override
    public void interpolate(float alpha) {
        super.interpolate(alpha);

    }
    
    @Override
    public void render(Graphics g) {
        super.render(g);

    }


}
