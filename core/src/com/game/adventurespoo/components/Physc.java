package com.game.adventurespoo.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.physics.box2d.Body;

public class Physc implements Component{

	public Body cuerpo;
	
	public Physc(Body cuerpo){
		this.cuerpo = cuerpo;
	}
	
	public void setBody(Body body){
		this.cuerpo = body;
	}
	
	public Body getBody(){
		return cuerpo;
	}
}
