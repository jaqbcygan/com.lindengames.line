package com.lindengames.line.screens;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;
import com.badlogic.gdx.utils.Timer.Task;
import com.lindengames.line.LineGame;
import com.lindengames.line.utilities.Constants;

public class MainMenuScreen extends ScreenAdapter {

    private final LineGame game;

    public MainMenuScreen(final LineGame game){

        this.game = game;
        Label title = new Label(Constants.GAME_NAME, Constants.SKIN, "roboto90", new Color(.40f, .40f, .40f, 1));

        Container<Label> titleContainer = new Container<Label>(title);
        titleContainer.setPosition(stage.getViewport().getWorldWidth() / 2, stage.getViewport().getWorldHeight() - viewport.getWorldHeight() / 5);

        stage.addActor(titleContainer);

        Sprite settingsButtonSprite = new Sprite(new Texture("settings_button.9.png"));
        settingsButtonSprite.setSize(74, 74);
        SpriteDrawable settingsButtonDrawable = new SpriteDrawable(settingsButtonSprite);

        Sprite playButtonSprite = new Sprite(new Texture("play_button.9.png"));
        SpriteDrawable playButtonDrawable = new SpriteDrawable(playButtonSprite);

        ImageButton settingsButton = new ImageButton(settingsButtonDrawable);

        ImageButton playButton = new ImageButton(playButtonDrawable);
        playButton.addListener(new ChangeListener() {
            @Override
            public void changed(ChangeEvent event, Actor actor) {
                stage.addAction(Actions.sequence(Actions.alpha(1), Actions.fadeOut(Constants.FADING_TIME)));
                timer.scheduleTask(new Task() {
                    @Override
                    public void run() {
                        game.setScreen(new GameScreen(game));
                    }
                }, Constants.FADING_TIME);
            }
        });
        //---------------------------------------------------------------------------------------------------------
        Container<ImageButton> btContainer = new Container<ImageButton>(playButton);
        stage.addActor(btContainer);
        btContainer.setPosition(stage.getViewport().getWorldWidth() / 2, stage.getViewport().getWorldHeight() / 2);
        //---------------------------------------------------------------------------------------------------------
        Button button3 = new Button(Constants.SKIN);


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
    public void resize(int width, int height){
        stage.getViewport().update(width, height, true);
        stage.getViewport().apply(true);
        stage.getViewport().getCamera().position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
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
