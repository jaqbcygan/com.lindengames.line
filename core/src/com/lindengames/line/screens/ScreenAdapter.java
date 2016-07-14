package com.lindengames.line.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public abstract class ScreenAdapter implements Screen {

    OrthographicCamera camera;
    Viewport viewport;

    Stage stage;

    public ScreenAdapter(){
        camera = new OrthographicCamera();

        viewport = new ScreenViewport(camera);

        stage = new Stage(viewport);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        stage.act(Math.min(Gdx.graphics.getDeltaTime(), 1 / 45f));
        stage.draw();

    }

    @Override
    public void resize(int width, int height) {
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

    }

    @Override
    public void dispose() {

    }
}
