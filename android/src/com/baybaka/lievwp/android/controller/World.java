package com.baybaka.lievwp.android.controller;

import android.util.Log;

import com.badlogic.gdx.Gdx;

public class World {
    public void update(float delta) {

//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        if (Gdx.input.isTouched()) {
            Log.i("log", "touched");
        }

        float x = Gdx.input.getAccelerometerX();
        if (Math.abs(x) > 1) {

            Log.i("acc", String.valueOf(x));
        }

    }
}
