package com.baybaka.lievwp.android.model;

import com.badlogic.gdx.math.Vector2;

public abstract class  AbstractParticle {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 acceleration;

    protected float lifetime;
    protected int size;

    protected boolean isAlive;
    private static float maxAcceleration;
    protected static float maxVelocity;

    public abstract void move(float delta);

    public void die() {
        isAlive = false;
//        velocity.y = 0;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void accelerate(float x , float y) {
        Vector2 copy = new Vector2(acceleration);
        acceleration.add(x, y);

        if (acceleration.len() > maxAcceleration) {
            acceleration = copy;
        }
    }
}
