package ru.deftone.android;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;

import android.os.Bundle;

import ru.deftone.MyGame;

public class AndroidLauncher extends AndroidApplication {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        config.useAccelerometer = false;
        config.useCompass = false;
        config.hideStatusBar = true;
        config.useWakelock = true;

        initialize(new MyGame(), config);
    }
}
