package com.udacity.gamedev.icicles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;


public class Constants {
    public static final float WORLD_SIZE = 10.0f;
    public static final Color BACKGROUND_COLOR = Color.BLUE;

    public static final float PLAYER_HEAD_RADIUS = 0.5f;
    public static final float PLAYER_HEAD_HEIGHT = 4.0f * PLAYER_HEAD_RADIUS;
    public static final float PLAYER_LIMB_WIDTH = 0.1f;
    public static final int PLAYER_HEAD_SEGMENTS = 20;
    public static final Color PLAYER_COLOR = Color.BLACK;
    public static final float PLAYER_MOVEMENT_SPEED = 10.0f;

    public static final float ACCELEROMETER_SENSITIVITY = 0.5f;
    public static final float GRAVITATIONAL_ACCELERATION = 9.8f;

    public static final float ICICLES_HEIGHT = 1.0f;
    public static final float ICICLES_WIDTH = 0.5f;
    public static final Vector2 ICICLES_ACCELERATION = new Vector2(0, -5.0f);
    public static final Color ICICLE_COLOR = Color.WHITE;

    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480.0f;
    public static final float HUD_MARGIN = 20.0f;

    public static final String EASY_LABEL = "Cold";
    public static final String MEDIUM_LABEL = "Colder";
    public static final String HARD_LABEL = "Coldest";

    public static final float EASY_SPAWNS_PER_SECOND = 5;
    public static final float MEDIUM_SPAWNS_PER_SECOND = 15;
    public static final float HARD_SPAWNS_PER_SECOND = 25;

    // TODO: Add constants for the color of each difficulty select circle
    public static final Color COLD_COLOR = new Color(0.2f, 0.2f, 1, 1);
    public static final Color COLDER_COLOR = new Color(0.5f, 0.5f, 1, 1);
    public static final Color COLDEST_COLOR = new Color(0.7f, 0.7f, 1, 1);
    // TODO: Add constant for the size of the difficulty world
    public static final float DIFF_WORLD_SIZE = 480.0f;

    // TODO: Add constant for the radius of the difficulty select "buttons"
    public static final float BUTTON_RADIUS = DIFF_WORLD_SIZE/9;

    // TODO: Add constant for the scale of the difficulty labels (1.5 works well)
    public static final float LABEL_SCALE = 1.5f;

    // TODO: Add Vector2 constants for the centers of the difficulty select buttons
    public static final Vector2 COLD_CENTER = new Vector2(DIFF_WORLD_SIZE/4, DIFF_WORLD_SIZE/2);
    public static final Vector2 COLDER_CENTER = new Vector2(DIFF_WORLD_SIZE/2, DIFF_WORLD_SIZE/2);
    public static final Vector2 COLDEST_CENTER = new Vector2(DIFF_WORLD_SIZE/4 + DIFF_WORLD_SIZE/2, DIFF_WORLD_SIZE/2);

    public enum Difficulty {
        EASY(EASY_SPAWNS_PER_SECOND, EASY_LABEL),
        MEDIUM(MEDIUM_SPAWNS_PER_SECOND, MEDIUM_LABEL),
        HARD(HARD_SPAWNS_PER_SECOND, HARD_LABEL);

        float spawnRate;
        String label;

        Difficulty(float spawnRate, String label) {
            this.spawnRate = spawnRate;
            this.label = label;
        }
    }
}
