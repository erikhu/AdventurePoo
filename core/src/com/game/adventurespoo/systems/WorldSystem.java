package com.game.adventurespoo.systems;

import com.badlogic.ashley.core.ComponentMapper;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.game.adventurespoo.components.Mapper;
import com.game.adventurespoo.components.Physc;
import com.game.adventurespoo.components.WorldComponent;

public class WorldSystem extends EntitySystem{
	
	private ImmutableArray<Entity> entities;

	public WorldSystem(){
	
	}
	
	@Override
	public void addedToEngine(Engine motor){
		Family familia = Family.all(WorldComponent.class).get();
		entities = motor.getEntitiesFor(familia);
	}
	
	@Override
	public void update(float delta){
		for (Entity entidad : entities){
			WorldComponent obj = Mapper.mundo.get(entidad);
			if(obj != null){
				obj.getMundo().step(Gdx.graphics.getDeltaTime() , 6, 2);
				
			}
		}

	}
	
	
	
	
}
