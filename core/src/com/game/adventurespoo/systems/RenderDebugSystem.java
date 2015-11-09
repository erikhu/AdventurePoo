package com.game.adventurespoo.systems;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.ashley.core.EntitySystem;
import com.badlogic.ashley.core.Family;
import com.badlogic.ashley.utils.ImmutableArray;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.game.adventurespoo.components.CameraComponent;
import com.game.adventurespoo.components.Mapper;
import com.game.adventurespoo.components.WorldComponent;

public class RenderDebugSystem extends EntitySystem {

	public Box2DDebugRenderer debug = new Box2DDebugRenderer();
	ImmutableArray<Entity> entitiesMundo;
	ImmutableArray<Entity> entitiesCamara;
	WorldComponent mundoComp;
	
	public RenderDebugSystem(){
		debug = new Box2DDebugRenderer();
	}
	
	@Override
	public void update(float delta){
		CameraComponent camaraComp = Mapper.camara.get(entitiesCamara.first());
		System.out.println("La camara tiene en ancho : " + camaraComp.getCamara().viewportWidth);
		debug.render(mundoComp.getMundo(), camaraComp.getCamara().combined);
	}
	
	@Override
	public void addedToEngine(Engine motor){
		Family familiaMundo = Family.all(WorldComponent.class).get();
		mundoComp = Mapper.mundo.get(motor.getEntitiesFor(familiaMundo).first());
		
		Family familiarCam  = Family.all(CameraComponent.class).get();
		entitiesCamara = motor.getEntitiesFor(familiarCam);
	}
}
