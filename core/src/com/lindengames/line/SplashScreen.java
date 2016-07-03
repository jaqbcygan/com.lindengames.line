package com.lindengames.line;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;


public class SplashScreen implements Screen {

    private LineGame game;
    private Stage stage;
    private Texture img;
    private BitmapFont hack25;

    private OrthographicCamera camera;
    private Viewport viewport;

    public SplashScreen(LineGame game){

        this.game = game;

        camera = new OrthographicCamera();
        viewport = new ScreenViewport(camera);

        img = new Texture("logo_100.png");

        FreeTypeFontGenerator fontGenerator;
        FreeTypeFontGenerator.FreeTypeFontParameter fontParameter;

        fontGenerator = new FreeTypeFontGenerator((Gdx.files.internal("hack.ttf")));
        fontParameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        fontParameter.size = 35;
        fontParameter.color = new Color(.75f, .75f, .75f, 1);
        hack25 = fontGenerator.generateFont(fontParameter);

        stage = new Stage(viewport);
        Table table = new Table();
        table.setPosition(stage.getViewport().getScreenX() / 2, stage.getViewport().getScreenY() / 2 );
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));

        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        stage.addActor(table);

        Image logo = new Image(img);
        skin.add("hack25", hack25);
        Label splashText = new Label("Linden Games", skin, "hack25", new Color(.40f, .40f, .40f, 1));

        table.add(logo);
        table.row();
        table.add(splashText);

    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        stage.getViewport().update(width, height, true);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {
        img.dispose();
    }
}
