package com.baybaka.lievwp.android.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.baybaka.lievwp.android.controller.World;
import com.baybaka.lievwp.android.model.BaseParticle;

public class Renderer {


    private final int mViewportWidth;
    private final int mViewportHeight;
    private World mWorld;

    OrthographicCamera mFixedCamera, camera2;
    SpriteBatch batch;
    SpriteBatch batch2;

    private ShapeRenderer shapeRenderer;

    Texture textureBg;
    TextureRegion background;
    private float runtime;


    public Renderer(World world) {

        mWorld = world;

        mViewportWidth = 480;
        mViewportHeight = 640;
        mFixedCamera = new OrthographicCamera(mViewportWidth, mViewportHeight);
//        mFixedCamera.position.set(mFixedCamera.viewportWidth / 2, mFixedCamera.viewportHeight / 2, 0);

        camera2 = new OrthographicCamera(mViewportWidth, mViewportHeight);
        camera2.position.set(camera2.viewportWidth / 2, camera2.viewportHeight / 2, 0);
//        mFixedCamera.update();

        batch = new SpriteBatch();
//        batch.setProjectionMatrix(mFixedCamera.combined);

        batch2 = new SpriteBatch();
        batch2.setProjectionMatrix(camera2.combined);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(mFixedCamera.combined);

        textureBg = new Texture("background.png");
//        textureBg.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);
//        background = new TextureRegion(textureBg, 0, 0, 640, 480);

        mWorld.setScreenLimits(mViewportWidth, mViewportHeight);
    }

    public void render(float delta) {
        runtime += delta;

        batch.begin();

        batch.draw(textureBg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());

        batch.end();

        batch2.begin();


        for (BaseParticle particle : mWorld.getParticles()) {
//            ParticleEffect effect = particle.getPe();
//            effect.setPosition(particle.getPosition().x, particle.getPosition().y);
//            effect.draw(batch2, delta);
//
//
//            if (effect.isComplete())
//                effect.reset();
//
            batch2.draw(particle.getAnimation().getKeyFrame(runtime),
                    particle.getPosition().x, particle.getPosition().y,
                    particle.getSize(), particle.getSize());
        }

        batch2.end();

        updateXY();
    }

    private void updateXY() {
        x++;
        y++;
        if (x > 300) {
            x = -50;
            y = -50;
        }
    }

    int x = 50, y = 50;

    private void useShape() {
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);


        shapeRenderer.setColor(55 / 255.0f, 80 / 255.0f, 100 / 255.0f, 1);


        shapeRenderer.identity();
        shapeRenderer.rect(x++, y++, 136, 66);

        shapeRenderer.circle(-x, -y, 100);
        shapeRenderer.end();

        if (x > mFixedCamera.viewportWidth / 2 || y > mFixedCamera.viewportHeight / 2) {
            x = 0;
            y = 0;
        }

    }

    public void dispose() {
        batch.dispose();
        batch2.dispose();
    }
}
