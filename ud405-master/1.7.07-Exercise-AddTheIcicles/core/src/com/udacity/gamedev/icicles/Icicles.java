package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;


public class Icicles {

    public static final String TAG = Icicles.class.getName();

    // TODO: Add an array of icicles and a viewport

    Viewport viewport;

    Array<Icicle> icicleArray;

    public Icicles(Viewport viewport) {
        this.viewport = viewport;
        init();
    }

    public void init() {
        // TODO: Initialize the array of icicles
        icicleArray = new Array<Icicle>(false, 100);
    }

    public void update(float delta) {
        // TODO: Replace hard-coded spawn rate with a constant
        if (MathUtils.random() < delta * Constants.ICICLE_SPAWNS_PER_SECOND) {
            // TODO: Add a new icicle at the top of the viewport at a random x position
            Vector2 newIciclePosition = new Vector2(
                    MathUtils.random() * viewport.getWorldWidth(),
                    viewport.getWorldHeight()
            );
            Icicle newIcicle = new Icicle(newIciclePosition);
            icicleArray.add(newIcicle);
        }

        // TODO: Update each icicle
        for (Icicle icicle : icicleArray) {
            icicle.update(delta);
        }

    }

    public void render(ShapeRenderer renderer) {
        // TODO: Set ShapeRenderer Color
        renderer.setColor(Constants.ICICLE_COLOR);

        // TODO: Render each icicle
        for(Icicle icicle : icicleArray) {
            icicle.render(renderer);
        }

    }
}
