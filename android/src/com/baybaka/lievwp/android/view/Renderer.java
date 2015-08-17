package com.baybaka.lievwp.android.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.baybaka.lievwp.android.controller.World;
import com.baybaka.lievwp.android.model.BaseParticle;

public class Renderer {


    private World mWorld;

    OrthographicCamera mFixedCamera, camera2;
    SpriteBatch batch;
    SpriteBatch batch2;

    private ShapeRenderer shapeRenderer;

    Texture textureBg;
    TextureRegion background;

    ParticleEffect pe;


    public Renderer(World world) {

        mWorld = world;

        mFixedCamera = new OrthographicCamera(480, 640);
//        mFixedCamera.position.set(mFixedCamera.viewportWidth / 2, mFixedCamera.viewportHeight / 2, 0);

        camera2 = new OrthographicCamera(480, 640);
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

        pe = new ParticleEffect();
        pe.load(Gdx.files.internal("effects/effect1.p"), Gdx.files.internal("effects"));
        pe.getEmitters().first().setPosition(0, 0);

        pe.start();
    }

    public void render(float delta) {


//        pe.setPosition(-x,y);

        batch.begin();

        batch.draw(textureBg, 0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());


        batch.end();


        batch2.begin();

//        Texture txt = new Texture("bob/bob_02.png");
//        Sprite sprite = new Sprite(txt, -x, -y, 150, 150);
//        sprite.setColor(Color.WHITE);
//        sprite.draw(batch2);

//        Pixmap p = new Pixmap(256, 256, Pixmap.Format.RGBA8888);

        Texture texture = new Texture("bob/bob_01.png");

        batch2.draw(texture, x, -y, 50, 50);

//        pe.draw(batch, delta);

        for (BaseParticle particle: mWorld.getParticles()) {
            ParticleEffect effect = particle.getPe();
            effect.setPosition(particle.getPosition().x, particle.getPosition().y);
            effect.draw(batch2, delta);
        }

        pe.setPosition(-x, y);
        pe.draw(batch2, delta);

        batch2.end();


        if (pe.isComplete())
            pe.reset();



        x++;
        y++;

        if (x > mFixedCamera.viewportWidth / 2 || y > mFixedCamera.viewportHeight / 2) {
            x = 0;
            y = 0;
        }
    }

    int x = 50, y = 50;
    int x1 = 50, y1 = 50;

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
