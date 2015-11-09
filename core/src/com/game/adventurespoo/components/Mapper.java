package com.game.adventurespoo.components;

import com.badlogic.ashley.core.ComponentMapper;

public class Mapper {
	public static ComponentMapper<Physc> fisica = ComponentMapper.getFor(Physc.class);
	public static ComponentMapper<Position> posicion = ComponentMapper.getFor(Position.class);
	public static ComponentMapper<WorldComponent> mundo = ComponentMapper.getFor(WorldComponent.class);
	public static ComponentMapper<CameraComponent> camara  = ComponentMapper.getFor(CameraComponent.class);
}
