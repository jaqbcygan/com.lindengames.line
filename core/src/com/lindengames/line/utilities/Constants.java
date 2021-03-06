package com.lindengames.line.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;


public class Constants {

    public static final Skin SKIN = new Skin(Gdx.files.internal("uiskin.json"));
    public static final String CO_NAME = "Linden Games";
    public static final String GAME_NAME = "Line";
    public static final float FADING_TIME = 1;
    public static final int WORLD_HEIGHT = 100;
    public static final int WORLD_WIDTH = 100;
    public static final World WORLD = new World(new Vector2(0, -10), true);
}
