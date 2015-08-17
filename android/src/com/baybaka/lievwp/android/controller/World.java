package com.baybaka.lievwp.android.controller;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.baybaka.lievwp.android.helper.Helper;
import com.baybaka.lievwp.android.model.BaseParticle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
    private float runTime = 0;
    private float lastUpdate = 0;
    private int secondsToUpdate = 2;

    private int maxCount = 3;
    private Helper mHelper;

    public World() {
        mHelper = new Helper(this);
    }

    public void setMaxCount(int maxCount) {
        this.maxCount = maxCount;
    }

    public List<BaseParticle> getParticles() {
        return mParticles;
    }

    private List<BaseParticle> mParticles = new ArrayList<BaseParticle>();

    public void update(float delta) {

        runTime += delta;

//        Gdx.app.log("GameScreen FPS", (1/delta) + "");
        if (Gdx.input.isTouched()) {
            Log.i("log", "touched");
        }

        float x = Gdx.input.getAccelerometerX();
        if (Math.abs(x) > 1) {

            Log.i("acc", String.valueOf(x));
        }
        // add acceleration
        doAction(delta);
    }

    private void doAction(float delta) {

        for (Iterator<BaseParticle> iterator = mParticles.iterator(); iterator.hasNext();) {
            BaseParticle p = iterator.next();

            p.incPassedTime(delta);
            p.move(delta);

            if (needToRemove(p)) {
                iterator.remove();
            }
        }

        if ((runTime - lastUpdate) > secondsToUpdate) {
            lastUpdate = runTime;

            if (mParticles.size() < maxCount) {
                mParticles.add(mHelper.createNewParticle());
            }
        }
    }

    private boolean needToRemove(BaseParticle p) {
        if (!p.isAlive()) {
            p.die();

            return true;
        }

        return false;
    }


}
