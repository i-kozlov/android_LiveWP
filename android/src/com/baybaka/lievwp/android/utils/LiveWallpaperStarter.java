package com.baybaka.lievwp.android.utils;

import com.badlogic.gdx.Game;
import com.baybaka.lievwp.android.helper.AssetLoader;
import com.baybaka.lievwp.android.screen.LiveWallpaperScreen;

public class LiveWallpaperStarter extends Game {

    @Override
    public void create() {
        AssetLoader.load();
        setScreen(new LiveWallpaperScreen(this));
    }


    @Override
    public void dispose() {
        super.dispose();
        AssetLoader.dispose();
    }
}
