package com.baybaka.lievwp;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;


public class MyGdxGame extends ApplicationAdapter {
    SpriteBatch batch;
    SpriteBatch batch2;
    ParticleEffect pe;
    ParticleEffect pe2;


    Texture textureBg;
    TextureRegion background;

    @Override
    public void create() {
        batch = new SpriteBatch();
        batch2 = new SpriteBatch();

        pe = new ParticleEffect();
        pe.load(Gdx.files.internal("effects/effect1.p"), Gdx.files.internal("effects"));
        pe.getEmitters().first().setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        pe.start();

        pe2 = new ParticleEffect();
        pe2.load(Gdx.files.internal("effects/effect3.p"), Gdx.files.internal("effects"));
        pe2.getEmitters().first().setPosition(Gdx.graphics.getWidth() / 2 - 100, Gdx.graphics.getHeight() / 2 - 100);
        pe2.start();


        textureBg = new Texture("background.png");
//        textureBg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background = new TextureRegion(textureBg, 0, 0, 256, 512);
    }

    float x = 100, y = 100;

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//        pe.update();
//        pe2.update(Gdx.graphics.getDeltaTime());

        pe.setPosition(x++, y++);

//        batch.enableBlending();
        batch.begin();

        batch.draw(textureBg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        pe.draw(batch, Gdx.graphics.getDeltaTime());
        pe2.draw(batch, Gdx.graphics.getDeltaTime());

//        batch.disableBlending();
        batch.end();


        if (pe.isComplete())
            pe.reset();
        if (pe2.isComplete())
            pe2.reset();
    }
}
