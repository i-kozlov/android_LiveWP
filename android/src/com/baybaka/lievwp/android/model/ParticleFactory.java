package com.baybaka.lievwp.android.model;

import com.badlogic.gdx.math.Vector2;

import java.util.Random;

public class ParticleFactory {
    public static BaseParticle newInstance(float speed, float accel, int size, int lifetime) {
        Vector2 velocity = new Vector2(speed, 0);
        velocity.rotate(getRotateAngle());

        Vector2 acceleration = new Vector2(accel, 0);
        acceleration.rotate(getRotateAngle());

        return new ParticleLinearDirection(velocity, acceleration, lifetime, size);
    }

    private static Random rand = new Random();

    private static float getRotateAngle() {
        return rand.nextFloat() * 360;
    }
}
