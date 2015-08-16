package com.baybaka.lievwp.android.model;

public class ParticleLinearDirection extends BaseParticle {


    @Override
    public void move(float delta) {

        velocity.add(acceleration.cpy().scl(delta));


        position.add(velocity.cpy().scl(delta));
    }
}
