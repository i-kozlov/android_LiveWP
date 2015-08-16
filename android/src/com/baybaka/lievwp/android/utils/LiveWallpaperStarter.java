package com.baybaka.lievwp.android.utils;

import com.badlogic.gdx.Game;
import com.baybaka.lievwp.android.screen.LiveWallpaperScreen;

public class LiveWallpaperStarter extends Game {

    @Override
    public void create() {
        setScreen(new LiveWallpaperScreen(this));
    }

}
