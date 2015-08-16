package com.baybaka.lievwp.android.controller;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.baybaka.lievwp.android.model.BaseParticle;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class World {
    private float runTime;
    private int maxCount = 3;
    private List<BaseParticle> mParticles = new ArrayList<BaseParticle>();

    public void update(float delta) {

        ifNewSecond(delta);

        runTime += delta;
//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        if (Gdx.input.isTouched()) {
            Log.i("log", "touched");
        }

        float x = Gdx.input.getAccelerometerX();
        if (Math.abs(x) > 1) {

            Log.i("acc", String.valueOf(x));
        }

    }

    private void ifNewSecond(float delta) {
        if (((runTime + delta) /1000 - runTime/ 1000) == 1) {
            if (mParticles.size() > maxCount) {
                mParticles.add(createNewParticle());
            }
        }
    }

    private BaseParticle createNewParticle() {
        Random random = new Random();
        float speed = random.nextFloat(); // *(maxX - minX) + minX;
        Vector2 velocity = new Vector2(speed, 0);
        velocity.rotate(random.nextFloat() * 360);
        return null;
    }
}
