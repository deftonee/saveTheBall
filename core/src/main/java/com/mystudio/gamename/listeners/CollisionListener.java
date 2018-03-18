package com.mystudio.gamename.listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

/**
 * Created by deftone on 18.03.2018.
 */

public class CollisionListener implements ContactListener {

    public void beginContact(Contact contact) {
        assert true;
    }

    public void endContact(Contact contact) {
        assert true;
    }

    public void preSolve(Contact contact, Manifold oldManifold) {
        assert true;
    }

    public void postSolve(Contact contact, ContactImpulse impulse) {
        assert true;
    }

}