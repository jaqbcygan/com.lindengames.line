package com.lindengames.line.objects;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import com.badlogic.gdx.utils.Array;
import com.lindengames.line.screens.GameScreen;
import com.lindengames.line.utilities.Constants;

public class Line {

    public Line(){
    }

    public void createLine() {

        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(0, 0);
        bodyDef.type = BodyDef.BodyType.StaticBody;

        ChainShape chain = createLineChain();

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = chain;

        Fixture fixture = Constants.WORLD.createBody(bodyDef).createFixture(fixtureDef);

        chain.dispose();
    }
    public ChainShape createLineChain(){
        ChainShape chain = new ChainShape();
        Array<Vector2> vertices = new Array<Vector2>();
        vertices.addAll(
                new Vector2(0, GameScreen.getViewport.getWorldHeight() / 2),
                new Vector2(viewport.getWorldWidth() / 2, viewport.getWorldHeight() / 2));
        chain.createChain((Vector2[]) vertices.toArray(Vector2.class));
        return chain;
    }
}

