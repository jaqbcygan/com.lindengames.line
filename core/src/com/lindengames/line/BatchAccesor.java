package com.lindengames.line;

import aurelienribon.tweenengine.TweenAccessor;
import com.badlogic.gdx.graphics.g2d.Batch;

public class BatchAccesor implements TweenAccessor<Batch>{

    public static final int ALPHA = 0;

    @Override
    public int getValues(Batch target, int tweenType, float[] values) {
        switch (tweenType){
            case ALPHA:
                values[0] = target.getColor().a;
                return 1;
            default:
                assert false;
                return -1;
        }
    }

    @Override
    public void setValues(Batch target, int tweenType, float[] values) {
         switch (tweenType){
             case ALPHA:
                 target.setColor(target.getColor().r, target.getColor().g, target.getColor().b, values[0]);
                 break;
             default:
                 assert false;
         }
    }
}
