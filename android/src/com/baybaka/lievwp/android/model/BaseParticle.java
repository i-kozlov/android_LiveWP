package com.baybaka.lievwp.android.model;

import com.badlogic.gdx.graphics.g2d.Animation;
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
    Animation animation;

    public void incPassedTime(float delta) {
        runTime += delta;
    }

    public void die() {
        isAlive = false;
//        velocity.y = 0;
        if (pe != null) {
            pe.dispose();
        }

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
//        pe = new ParticleEffect();
//        AssetLoader.configureEffect(pe);
        animation = AssetLoader.genRandomAnimation();
    }

    public Animation getAnimation() {
        return animation;
    }

    public int getSize() {
        return size;
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

    public void accelerateByGravity(Vector2 accelerometer) {
//        Vector2 copy = new Vector2(acceleration);
        acceleration.add(accelerometer);

//        if (acceleration.len() > maxAcceleration) {
//            acceleration = copy;
//        }
    }

    public Vector2 getVelocity() {
        return velocity;
    }

    public Vector2 getAcceleration() {
        return acceleration;
    }

    public void addAccelelometerVectorToVelocity(Vector2 accelerometer) {
        velocity.add(accelerometer);
    }
}
