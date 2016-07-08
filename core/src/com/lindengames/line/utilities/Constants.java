package com.lindengames.line.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.lindengames.line.LineGame;


public class Constants {

    public static final Skin SKIN = new Skin(Gdx.files.internal("uiskin.json"));
    public static final String CO_NAME = "Linden Games";
    public static final String GAME_NAME = "Line";
    public static final LineGame GAME = new LineGame();

}
