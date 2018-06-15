package ru.deftone.listeners;

import com.badlogic.gdx.physics.box2d.Contact;
import com.badlogic.gdx.physics.box2d.ContactImpulse;
import com.badlogic.gdx.physics.box2d.ContactListener;
import com.badlogic.gdx.physics.box2d.Manifold;

import ru.deftone.Actor;

/**
 * Delegates physics events to actors
 * Created by deftone on 18.03.2018.
 */

public class CollisionListener implements ContactListener {

    public void beginContact(Contact contact) {
        Actor actorA = (Actor) contact.getFixtureA().getBody().getUserData();
        Actor actorB = (Actor) contact.getFixtureB().getBody().getUserData();
        actorA.beginContact(actorB);
    }

    public void endContact(Contact contact) {
        Actor actorA = (Actor) contact.getFixtureA().getBody().getUserData();
        Actor actorB = (Actor) contact.getFixtureB().getBody().getUserData();
        actorA.endContact(actorB);
        assert true;
    }

    public void preSolve(Contact contact, Manifold oldManifold) {
        assert true;
    }

    public void postSolve(Contact contact, ContactImpulse impulse) {
        assert true;
    }

}
