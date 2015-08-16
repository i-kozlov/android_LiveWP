package com.baybaka.lievwp.android.model;

import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.math.Vector2;
import com.baybaka.lievwp.android.helper.AssetLoader;

public abstract class BaseParticle {

    protected Vector2 position;
    protected Vector2 velocity;
    protected Vector2 acceleration;

    protected int lifetime;
    protected int size;

    protected float runTime;

    protected boolean isAlive = true;
    private static float maxAcceleration;
    protected static float maxVelocity;

    public abstract void move(float delta);

    ParticleEffect pe;

    public void passedTime(float delta) {
        runTime+= delta;
    }

    public void die() {
        isAlive = false;
//        velocity.y = 0;
        pe.dispose();
    }

    public BaseParticle(Vector2 velocity, Vector2 acceleration, int lifetime, int size) {
        this.velocity = velocity;
        this.acceleration = acceleration;
        this.lifetime = lifetime;
        this.size = size;

        this.position = new Vector2(0, 0);

        initParticle();
    }

    private void initParticle() {
        pe = new ParticleEffect();
        AssetLoader.configureEffect(pe);
    }

    public Vector2 getPosition() {
        return position;
    }

    public ParticleEffect getPe() {

        return pe;
    }

    public boolean isAlive() {
        return isAlive && runTime < lifetime;
    }

    public void accelerate(float x, float y) {
        Vector2 copy = new Vector2(acceleration);
        acceleration.add(x, y);


        if (acceleration.len() > maxAcceleration) {
            acceleration = copy;
        }
    }
}
