package com.lindengames.line;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;
import com.lindengames.line.screens.SplashScreen;
import com.lindengames.line.utilities.Constants;


public class LineGame extends Game {

	public SpriteBatch batch;

	public LineGame() {
		super();
	}

	@Override
	public void create() {
		batch = new SpriteBatch();
		Constants.SKIN.add("roboto40", createRoboto40Font());
		Constants.SKIN.add("roboto90", createRoboto90Font());
		setScreen(new SplashScreen(this));
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void setScreen(Screen screen) {
		super.setScreen(screen);
	}

	@Override
	public Screen getScreen() {
		return super.getScreen();
	}

	@Override
	public void dispose () {
		batch.dispose();
	}

	@Override
	public void pause() {
		super.pause();
	}

	@Override
	public void resume() {
		super.resume();
	}

	public BitmapFont createRoboto40Font() {
		BitmapFont roboto40 = null;
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator((Gdx.files.internal("roboto.ttf")));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 40;
		roboto40 = fontGenerator.generateFont(fontParameter);
		return roboto40;
	}
	public BitmapFont createRoboto90Font() {
		BitmapFont roboto90 = null;
		FreeTypeFontGenerator fontGenerator = new FreeTypeFontGenerator((Gdx.files.internal("roboto.ttf")));
		FreeTypeFontParameter fontParameter = new FreeTypeFontParameter();
		fontParameter.size = 90;
		roboto90 = fontGenerator.generateFont(fontParameter);
		return roboto90;
	}
}
