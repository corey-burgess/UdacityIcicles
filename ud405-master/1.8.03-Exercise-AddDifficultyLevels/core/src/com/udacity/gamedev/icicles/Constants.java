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
    public static final float ICICLE_SPAWNS_PER_SECOND = 10.0f;
    public static final Color ICICLE_COLOR = Color.WHITE;

    public static final float HUD_FONT_REFERENCE_SCREEN_SIZE = 480.0f;
    public static final float HUD_MARGIN = 20.0f;

    // TODO: Create constants for difficulty labels ("Cold", "Colder", "Coldest")
    public static final String DIFFICULTY_COLD = "Cold";
    public static final String DIFFICULTY_COLDER = "Colder";
    public static final String DIFFICULTY_COLDEST = "Coldest";

    // TODO: Create constants for the icicle spawn rates for the various difficulties
    public static final float COLD_ICICLE_RATE = 5;
    public static final float COLDER_ICICLE_RATE = 15;
    public static final float COLDEST_ICICLE_RATE = 25;

    // TODO: Create Difficulty enum holding the spawn rate and label for each difficulty
    public enum Difficulty {
        COLD(DIFFICULTY_COLD, COLD_ICICLE_RATE),
        COLDER(DIFFICULTY_COLDER, COLDER_ICICLE_RATE),
        COLDEST(DIFFICULTY_COLDEST, COLDEST_ICICLE_RATE);

        private final String name;
        private final float rate;

        Difficulty(String name, float rate){
            this.name = name;
            this.rate = rate;
        }

        public String getName(){
            return this.name;
        }

        public float getRate(){
            return this.rate;
        }

    }
}
