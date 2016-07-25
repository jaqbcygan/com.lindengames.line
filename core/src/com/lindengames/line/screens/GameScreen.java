package com.lindengames.line.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.lindengames.line.LineGame;
import com.lindengames.line.objects.Line;

public class GameScreen extends ScreenAdapter {

    private final LineGame game;
    private Line line;
    private World world;
    private Box2DDebugRenderer debugRenderer;

    public GameScreen(LineGame game){
        this.game = game;
        world = new World(new Vector2(0, -10), true);
        debugRenderer = new Box2DDebugRenderer();
        line = new Line(world);
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(0, 0, 0, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        world.step(1/60, 6, 2);
        debugRenderer.render(world, camera.combined);
    }

}
