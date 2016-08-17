package com.lindengames.line.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.lindengames.line.LineGame;
import com.lindengames.line.objects.Line;
import com.lindengames.line.utilities.Constants;

public class GameScreen extends ScreenAdapter {

    private final LineGame game;
    private Sprite bg;
    private Line line;

    public World world;

    private Box2DDebugRenderer debugRenderer;

    public GameScreen(LineGame game){
        this.game = game;
        bg = new Sprite(new Texture("bg.png"));
        bg.setColor(Color.BLACK);
        bg.setSize(viewport.getWorldWidth(), viewport.getWorldHeight());
        bg.setPosition(0, 0);
        viewport = new StretchViewport(Constants.WORLD_WIDTH, Constants.WORLD_HEIGHT, camera);
        viewport.apply();
        camera.position.set(camera.viewportWidth / 2, camera.viewportHeight / 2, 0);
        debugRenderer = new Box2DDebugRenderer();
        line = new Line();
        createLine();
    }

    public void createLine(){

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(0, 0);
        bodyDef.type = BodyDef.BodyType.StaticBody;

        ChainShape chain = createLineChain();

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = chain;

        Fixture fixture = world.createBody(bodyDef).createFixture(fixtureDef);

        chain.dispose();
    }

    public ChainShape createLineChain(){
        ChainShape chain = new ChainShape();
        Array<Vector2> vertices = new Array<Vector2>();
        vertices.addAll(
                new Vector2(0, viewport.getWorldHeight() / 2),
                new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2));
        chain.createChain((Vector2[]) vertices.toArray(Vector2.class));
        return chain;
    }

    @Override
    public void render(float delta){
        Gdx.gl.glClearColor(1, 1, 1, 0);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.begin();
        bg.draw(game.batch);
        game.batch.end();
        world.step(1/60, 6, 2);
        debugRenderer.render(world, camera.combined);
    }

    public Viewport getViewport(){
        return viewport;
    }

    public void setViewport(Viewport viewport){
        this.viewport = viewport;
    }

}
