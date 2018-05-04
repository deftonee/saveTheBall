package ru.deftone;

import com.badlogic.gdx.Game;

public class MyGame extends Game {

    private GameState state;

    public GameState getState() {
        return state;
    }

    public void setState(GameState state) {
        this.state = state;
    }

    public enum GameState {
        Running,
        Paused
    }

	public void create() {
        Resources res = Resources.getInstance();
        res.initialize(this);
        res.createPauseWindow();
        res.showScreen(Resources.ScreenEnum.FIRST);
        state = GameState.Running;
    }

    public void render() {
        super.render();
    }

    public void pause() {
        state = GameState.Paused;
        Resources res = Resources.getInstance();
        res.getMenu().setVisible(true);
    }

    public void resume() {
        state = GameState.Running;
        Resources res = Resources.getInstance();
        res.getMenu().setVisible(false);
    }

    public void dispose() {
        getScreen().dispose();
    }

}
