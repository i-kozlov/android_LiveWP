package com.baybaka.lievwp.android.helper;

import com.baybaka.lievwp.android.MyApp;
import com.baybaka.lievwp.android.controller.World;
import com.baybaka.lievwp.android.model.BaseParticle;
import com.baybaka.lievwp.android.model.ParticleFactory;
import com.baybaka.lievwp.android.utils.SharedPreferenceController;

import java.util.Random;

public class Helper {
    private float minSpeed;
    private float maxSpeed;
    private float minAccel;
    private float maxAccel;
    private int minLifetime;
    private int maxLifetime;
    private int minSize;
    private int maxSize;

    private SharedPreferenceController pref;
    private World mWorld;

    public Helper(World world) {

        mWorld = world;
        pref = SharedPreferenceController.getInstance();
        loadValues();
    }

    public void loadValues() {
        minSpeed = pref.getMinSpeed();
        maxSpeed = pref.getMaxSpeed();
        minAccel = pref.getMinAcceleration();
        maxAccel = pref.getMaxAcceleration();
        minSize = pref.getMinSize();
        maxSize = pref.getMaxSize();
        minLifetime = pref.getMinLifeTime();
        maxLifetime = pref.getMaxLifeTime();

        mWorld.setMaxCount(pref.getQuantity());
    }

    public BaseParticle createNewParticle() {
        if (MyApp.isUpdated()) {
            loadValues();
            MyApp.setUpdated(false);
        }

        float speed = getRandon(minSpeed, maxSpeed);
        float acceleration = getRandon(minAccel, maxAccel);
        int lifetime = (int) getRandon(minLifetime, maxLifetime);
        int size = (int) getRandon(minSize, maxSize);

        return ParticleFactory.newInstance(speed, acceleration, size, lifetime);
    }

    private Random rand = new Random();

    private float getRandon(float min, float max) {
        return rand.nextFloat() * (max - min) + min;
    }
}
