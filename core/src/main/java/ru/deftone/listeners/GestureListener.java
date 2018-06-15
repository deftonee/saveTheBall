package ru.deftone.listeners;

import com.badlogic.gdx.input.GestureDetector;

import ru.deftone.screens.InGameScreen;

public class GestureListener extends GestureDetector.GestureAdapter {
    InGameScreen screen;

    public GestureListener(InGameScreen screen) {
        this.screen = screen;
    }
    public boolean tap (float x, float y, int count, int button) {
        boolean result = false;
        if (count == 2) {
            screen.pause();
            result = true;
        }
        return result;
    }

}
