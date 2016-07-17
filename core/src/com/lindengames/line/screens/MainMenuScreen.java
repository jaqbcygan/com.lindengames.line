package com.lindengames.line.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.lindengames.line.LineGame;
import com.lindengames.line.utilities.Constants;

public class MainMenuScreen extends ScreenAdapter {

    private final LineGame game;

    public MainMenuScreen(final LineGame game){


        this.game = game;
        Label title = new Label(Constants.GAME_NAME, Constants.SKIN, "roboto90", new Color(.40f, .40f, .40f, 1));

        Container<Label> titleContainer = new Container<Label>(title);
        titleContainer.setPosition(stage.getViewport().getScreenWidth() / 2, stage.getViewport().getScreenHeight() - viewport.getScreenHeight() / 5);

        stage.addActor(titleContainer);

        Table childTable = new Table(Constants.SKIN);
        childTable.setPosition(stage.getViewport().getScreenWidth() / 2, stage.getViewport().getScreenHeight() / 2);

        stage.addActor(childTable);

        Button button1 = new Button(Constants.SKIN);
        Button button2 = new Button(Constants.SKIN);
        Button button3 = new Button(Constants.SKIN);

        childTable.add(button1, button2, button3);

        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(Constants.FADING_TIME)));
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
        camera.position.set(width / 2, height / 2, 0);
        viewport.update(width, height, true);
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
