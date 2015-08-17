package com.baybaka.lievwp.android.model;

import com.badlogic.gdx.math.Vector2;

public class ParticleLinearDirection extends BaseParticle {


    public ParticleLinearDirection(Vector2 velocity, Vector2 acceleration, int lifetime, int size) {
        super(velocity, acceleration, lifetime, size);
    }

    @Override
    public void move(float delta) {

        velocity.add(acceleration.cpy().scl(delta));

        position.add(velocity.cpy().scl(delta));
    }
}
