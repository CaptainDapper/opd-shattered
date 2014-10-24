package com.shatteredpixel.shatteredpixeldungeon.actors.blobs;


import com.shatteredpixel.shatteredpixeldungeon.effects.BlobEmitter;
import com.shatteredpixel.shatteredpixeldungeon.effects.particles.GooWarnParticle;

/**
 * Created by Evan on 29/09/2014.
 */
public class GooWarn extends Blob {

    //cosmetic blob, used to warn noobs that goo's pump up should, infact, be avoided.

    protected int pos;

    @Override
    protected void evolve() {
        for (int i=0; i < LENGTH; i++) {

            int offv = cur[i] > 0 ? cur[i] - 1 : 0;
            off[i] = offv;

            if (offv > 0) {
                volume += offv;
            }
        }


    }

    public void seed( int cell, int amount ) {
        int diff = amount - cur[cell];
        if (diff > 0) {
            cur[cell] = amount;
            volume += diff;
        }
    }

    @Override
    public void use( BlobEmitter emitter ) {
        super.use( emitter );
        emitter.start(GooWarnParticle.FACTORY, 0.05f, 0 );
    }

    @Override
    public String tileDesc() {
        return "Dark energy is building here!";
    }
}

