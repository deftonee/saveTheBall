package ru.deftone;

import com.badlogic.gdx.Game;

import ru.deftone.screens.InGameScreen;

public class MyGame extends Game {

	public void create() {
        setScreen(new InGameScreen(this));
    }

    public void render() {
        super.render();
    }

    public void dispose() {
        Resources.getInstance().dispose();
    }

}
