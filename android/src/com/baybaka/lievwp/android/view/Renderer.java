package com.baybaka.lievwp.android.view;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Renderer {


    private World mWorld;

    OrthographicCamera camera;
    SpriteBatch batch;

    private ShapeRenderer shapeRenderer;

    Texture textureBg;
    TextureRegion background;

    ParticleEffect pe;


    public Renderer(World world) {

        mWorld = world;

        camera = new OrthographicCamera(320, 480);
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
//        camera.update();

        batch = new SpriteBatch();
        batch.setProjectionMatrix(camera.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(camera.combined);

        textureBg = new Texture("wb.jpg");
        textureBg.setFilter(Texture.TextureFilter.Linear, Texture.TextureFilter.Linear);
        background = new TextureRegion(textureBg, 0, 0, 256, 512);

        pe = new ParticleEffect();
        pe.load(Gdx.files.internal("test1"),Gdx.files.internal(""));
        pe.getEmitters().first().setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        pe.start();
    }

    public void render(float delta) {

        pe.update(Gdx.graphics.getDeltaTime());
        batch.begin();

        batch.draw(background, 0, 0, camera.viewportWidth, camera.viewportHeight);

//        Texture txt = new Texture ("badlogic.jpg");
//        Sprite sprite = new Sprite(txt, x ,y, 450, 450);
//        sprite.draw(batch);

        Pixmap p = new Pixmap(256, 256, Pixmap.Format.RGBA8888);
        Texture texture = new Texture ("bob/bob_01.png");
        batch.draw(texture, x, -y, 50, 50);
        pe.draw(batch);
        batch.end();
        if (pe.isComplete())
            pe.reset();
//        useShape();

        x++; y++;

        if (x > camera.viewportWidth / 2 || y > camera.viewportHeight/ 2) {
            x = 0;
            y = 0;
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

        if (x > camera.viewportWidth / 2 || y > camera.viewportHeight/ 2) {
            x = 0;
            y = 0;
        }

    }

}
