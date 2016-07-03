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
        fontParameter.size = 25;
        fontParameter.color = Color.BLACK;
        hack25 = fontGenerator.generateFont(fontParameter);

        stage = new Stage(viewport);
        Table table = new Table();
        Skin skin = new Skin(Gdx.files.internal("uiskin.json"));
        skin.add("default-font", hack25, BitmapFont.class);
        Gdx.input.setInputProcessor(stage);

        table.setFillParent(true);
        stage.addActor(table);

        table.setDebug(true);

        Image logo = new Image(img);
        Label splashText = new Label("Linden Games", skin);

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
        camera.update();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 30f));
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
        stage.getViewport().update(width, height);
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
