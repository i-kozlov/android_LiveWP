package com.baybaka.lievwp.android.screen;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.baybaka.lievwp.android.view.World;
import com.baybaka.lievwp.android.view.Renderer;

public class LiveWallpaperScreen implements Screen {
    Game game;
    private float runTime;

    World world;
    Renderer renderer;

    public LiveWallpaperScreen(final Game game) {
        this.game = game;

        world = new World();
        renderer = new Renderer(world);
    }

    @Override
    public void render(float delta) {
        runTime += delta;

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        world.update(delta);
        renderer.render(delta);
    }


    @Override
    public void dispose() {
        Gdx.app.log("LiveWallpaperScreen", "dispose called");

    }

    @Override
    public void hide() {
        Gdx.app.log("LiveWallpaperScreen", "hide called");

    }

    @Override
    public void pause() {
        Gdx.app.log("LiveWallpaperScreen", "pause called");

    }


    @Override
    public void resize(int width, int height) {
        Gdx.app.log("LiveWallpaperScreen", "resize called");
    }

    @Override
    public void resume() {
        Gdx.app.log("LiveWallpaperScreen", "resume called");

    }

    @Override
    public void show() {
        Gdx.app.log("LiveWallpaperScreen", "show called");

    }
}
