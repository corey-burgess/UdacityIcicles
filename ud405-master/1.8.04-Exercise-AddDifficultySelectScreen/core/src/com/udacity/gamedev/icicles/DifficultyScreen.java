package com.udacity.gamedev.icicles;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.FitViewport;


public class DifficultyScreen extends InputAdapter implements Screen {

    public static final String TAG = DifficultyScreen.class.getName();

    IciclesGame game;

    ShapeRenderer renderer;
    SpriteBatch batch;
    FitViewport viewport;

    BitmapFont font;

    public DifficultyScreen(IciclesGame game) {
        this.game = game;
    }

    @Override
    public void show() {
        renderer = new ShapeRenderer();
        batch = new SpriteBatch();

        // TODO: Initialize a FitViewport with the difficulty world size constant
        viewport = new FitViewport(Constants.DIFF_WORLD_SIZE, Constants.DIFF_WORLD_SIZE);
        Gdx.input.setInputProcessor(this);

        font = new BitmapFont();
        // TODO: Set the font scale using the constant we defined
        font.getData().setScale(Constants.LABEL_SCALE);
        font.getRegion().getTexture().setFilter(TextureFilter.Linear, TextureFilter.Linear);
    }

    @Override
    public void render(float delta) {
        // TODO: Apply the viewport
        viewport.apply();

        Gdx.gl.glClearColor(Constants.BACKGROUND_COLOR.r, Constants.BACKGROUND_COLOR.g, Constants.BACKGROUND_COLOR.b, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        // TODO: Set the ShapeRenderer's projection matrix
        renderer.setProjectionMatrix(viewport.getCamera().combined);


        // TODO: Use ShapeRenderer to draw the buttons
        renderer.begin(ShapeRenderer.ShapeType.Filled);
        renderer.setColor(Constants.COLD_COLOR);
        renderer.circle(Constants.COLD_CENTER.x, Constants.COLD_CENTER.y, Constants.BUTTON_RADIUS, 64);
        renderer.setColor(Constants.COLDER_COLOR);
        renderer.circle(Constants.COLDER_CENTER.x, Constants.COLDER_CENTER.y, Constants.BUTTON_RADIUS, 64);
        renderer.setColor(Constants.COLDEST_COLOR);
        renderer.circle(Constants.COLDEST_CENTER.x, Constants.COLDEST_CENTER.y, Constants.BUTTON_RADIUS, 64);
        renderer.end();


        // TODO: Set the SpriteBatche's projection matrix
        batch.setProjectionMatrix(viewport.getCamera().combined);

        // TODO: Use SpriteBatch to draw the labels on the buttons
        // HINT: Use GlyphLayout to get vertical centering
        batch.begin();

        final GlyphLayout coldLayout = new GlyphLayout(font, Constants.EASY_LABEL);
        font.draw(batch, Constants.EASY_LABEL, Constants.COLD_CENTER.x, Constants.COLD_CENTER.y + coldLayout.height / 2, 0, Align.center, false);

        final GlyphLayout colderLayout = new GlyphLayout(font, Constants.EASY_LABEL);
        font.draw(batch, Constants.MEDIUM_LABEL, Constants.COLDER_CENTER.x, Constants.COLDER_CENTER.y + colderLayout.height / 2, 0, Align.center, false);

        final GlyphLayout coldestLayout = new GlyphLayout(font, Constants.EASY_LABEL);
        font.draw(batch, Constants.HARD_LABEL, Constants.COLDEST_CENTER.x, Constants.COLDEST_CENTER.y + coldestLayout.height / 2, 0, Align.center, false);

        batch.end();

    }

    @Override
    public void resize(int width, int height) {
        // TODO: Update the viewport
        viewport.update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        batch.dispose();
        font.dispose();
        renderer.dispose();
    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {

        // TODO: Unproject the touch from the screen to the world
        Vector2 worldTouch = viewport.unproject(new Vector2(screenX, screenY));

        // TODO: Check if the touch was inside a button, and launch the icicles screen with the appropriate difficulty
        if (worldTouch.dst(Constants.COLD_CENTER) < Constants.BUTTON_RADIUS){
            game.showIciclesScreen(Constants.Difficulty.EASY);
        }

        if (worldTouch.dst(Constants.COLDER_CENTER) < Constants.BUTTON_RADIUS){
            game.showIciclesScreen(Constants.Difficulty.MEDIUM);
        }

        if (worldTouch.dst(Constants.COLDEST_CENTER) < Constants.BUTTON_RADIUS){
            game.showIciclesScreen(Constants.Difficulty.HARD);
        }

        return true;
    }
}
