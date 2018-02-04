package com.mystudio.gamename;


import org.mini2Dx.core.graphics.Graphics;

/**
 * Created by deftone on 28.01.2018.
 */

public class Actor {

    private Figure figure;

    private ActorState state;

    Actor(Figure figure, ActorState state){
        this.figure = figure;
        this.state = state;
    }

    public void setFigure(Figure figure){
        this.figure = figure;
    }

    public Figure getFigure(){
        return figure;
    }

    public ActorState getState() {
        return state;
    }

    public void setState(ActorState state) {
        this.state = state;
    }

    public void draw(Graphics g){
        figure.draw(g);
    };


}
