package com.baybaka.lievwp.android.helper;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AssetLoader {

    private static String[] particles =
            new String[]{"effect1.p", "effect2.p", "effect3.p", "effect4.p"};

    public static List<TextureRegion> texturesList = new ArrayList<>();

    public static void configureEffect(ParticleEffect pe) {
        int index = new Random().nextInt(particles.length - 1);

        pe.load(Gdx.files.internal("effects/" + particles[index]), Gdx.files.internal("effects"));
        pe.getEmitters().first().setPosition(0, 0);

        pe.start();
    }

    public static Animation genRandomAnimation() {
        Random random = new Random();
        int size = random.nextInt(2) + 3;
        TextureRegion[] textures = new TextureRegion[size];
        for (int i = 0; i < size; i++) {
            int index = random.nextInt(texturesList.size());
            textures[i] = texturesList.get(index);
        }
        Animation animation = new Animation(0.1f, textures);
        animation.setPlayMode(Animation.PlayMode.LOOP_PINGPONG);
        return animation;
    }

    public static void load() {
        Texture atlas = new Texture(Gdx.files.internal("atlas.png"));
        atlas.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        int width = 75;
        int height = 50;

        int[] coordinatesY = new int[]{100, 180, 273};
        int[] coordinatesX = new int[]{24, 114, 211, 318, 410, 515, 615};

        for (int y : coordinatesY) {
            for (int x : coordinatesX) {
                texturesList.add(new TextureRegion(atlas, x, y, width, height));
            }
        }

    }

    public static void dispose() {

    }
}
