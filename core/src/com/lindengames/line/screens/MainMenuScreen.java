package com.lindengames.line.screens;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.lindengames.line.utilities.Constants;

public class MainMenuScreen extends ScreenAdapter {

    public MainMenuScreen(){

        Table table = new Table();
        stage.addActor(table);
        Label title = new Label(Constants.GAME_NAME, Constants.SKIN, "roboto40", new Color(.40f, .40f, .40f, 1));
        table.add(title);
        table.row();

        table.setDebug(true);

    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void render(float delta) {
        super.render(delta);
    }

    @Override
    public void resize(int width, int height) {
        super.resize(width, height);
    }

    @Override
    public void pause() {
        super.pause();
    }

    @Override
    public void resume() {
        super.resume();
    }

    @Override
    public void hide() {
        super.hide();
    }

    @Override
    public void dispose() {
        super.dispose();
    }
}
