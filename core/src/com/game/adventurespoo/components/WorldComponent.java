package com.game.adventurespoo.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;

public class WorldComponent implements Component{

	private World mundo;
	
	public WorldComponent(){
		setMundo(new World(new Vector2(0,-10), true));
	}
	
	public WorldComponent(int h , int v , boolean decision){
		setMundo(new World(new Vector2(h,v), decision));
	}
	
	public WorldComponent(World mundo){
		setMundo(mundo);
	}
	

	public World getMundo() {
		return mundo;
	}

	public void setMundo(World mundo) {
		this.mundo = mundo;
	}
	
}
