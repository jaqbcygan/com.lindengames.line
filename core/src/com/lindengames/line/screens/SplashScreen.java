package com.lindengames.line.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.Timer;
import com.badlogic.gdx.utils.Timer.Task;
import com.lindengames.line.utilities.Constants;

public class SplashScreen extends ScreenAdapter {

    private Texture img;
    private Timer timer;
    private Task task;

    public SplashScreen(){
        img = new Texture("logo_100.png");

        Table table = new Table();
        table.setPosition(stage.getViewport().getScreenX() / 2, stage.getViewport().getScreenY() / 2 );
        table.setFillParent(true);
        stage.addActor(table);

        Image logo = new Image(img);
        Label splashText = new Label(Constants.CO_NAME, Constants.SKIN, "roboto40", new Color(.40f, .40f, .40f, 1));

        table.add(logo);
        table.row();
        table.add(splashText);

        stage.addAction(Actions.sequence(Actions.alpha(0), Actions.fadeIn(1)));
        timer = new Timer();
        task = new Task() {
            @Override
            public void run() {
                stage.addAction(Actions.sequence(Actions.alpha(1), Actions.fadeOut(1)));
                Constants.GAME.setScreen(new MainMenuScreen());
            }
        };
        timer.scheduleTask(task, 2.5f);

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
        stage.dispose();
        img.dispose();
    }
}
