package com.baybaka.lievwp.android.controller;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.baybaka.lievwp.android.helper.Helper;
import com.baybaka.lievwp.android.model.BaseParticle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class World {
    private float runTime = 0;
    private float lastUpdate = 0;
    private int createNewTimeOut = 1;

    private float lastUpdateForAccelerometer = 0;
    private final float ACCELEROMETER_THRESHOLD = 0.3f;

    private int maxCount = 3;
    private Helper mHelper;
    private int maxWidth;
    private int maxHeight;

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

        Vector2 accelerometer = null;

        if (runTime - lastUpdateForAccelerometer > ACCELEROMETER_THRESHOLD) {

            lastUpdateForAccelerometer = runTime;
            float x = Gdx.input.getAccelerometerX();
            float y = Gdx.input.getAccelerometerY();
            accelerometer = new Vector2(-x, -y);
        }
        doAction(delta, accelerometer);
    }

    private void doAction(float delta, Vector2 accelerometer) {

        for (Iterator<BaseParticle> iterator = mParticles.iterator(); iterator.hasNext(); ) {
            BaseParticle p = iterator.next();

            p.incPassedTime(delta);
            if (accelerometer != null) {
                p.addAccelelometerVectorToVelocity(accelerometer);
            }
            p.move(delta);

            if (needToRemove(p)) {
                iterator.remove();
            }
        }

        if ((runTime - lastUpdate) > createNewTimeOut) {
            lastUpdate = runTime;

            if (mParticles.size() < maxCount) {
                mParticles.add(mHelper.createNewParticle());
            }
        }
    }

    private boolean needToRemove(BaseParticle p) {
        if (!p.isAlive() || leftScreen(p)) {
            p.die();

            return true;
        }

        return false;
    }

    private boolean leftScreen(BaseParticle p) {
        return Math.abs(p.getPosition().x) > maxWidth || Math.abs(p.getPosition().y) > maxHeight;
    }


    public void setScreenLimits(int viewportWidth, int viewportHeight) {

        maxWidth = viewportWidth;
        maxHeight = viewportHeight;
    }
}
