package com.game.adventurespoo;

import com.badlogic.ashley.core.Engine;
import com.badlogic.ashley.core.Entity;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.game.adventurespoo.builders.BuilderBody;
import com.game.adventurespoo.components.CameraComponent;
import com.game.adventurespoo.components.Physc;
import com.game.adventurespoo.components.Position;
import com.game.adventurespoo.components.WorldComponent;
import com.game.adventurespoo.systems.RenderDebugSystem;
import com.game.adventurespoo.systems.WorldSystem;

public class AdventurePoo2 extends ApplicationAdapter{
	
	Engine motor;
	
	@Override
	public void create(){
		
		motor = new Engine();
		
		WorldComponent mundo = new WorldComponent();
		Position posicionCuadro = new Position();
		posicionCuadro.x = 0;
		posicionCuadro.y = 0;
		
		Position posicionBola = new Position();
		posicionBola.x = 4;
		posicionBola.y = 2.8f;
		
		Physc fisicaCuadro = new Physc(BuilderBody.builderBodyStatic(mundo.getMundo(), posicionCuadro, 8, .5f));
		Physc fisicaBola = new Physc(BuilderBody.builderBodyDynamic(mundo.getMundo(), posicionBola , 1));
		
		CameraComponent camara = new CameraComponent(8,4.8f, 4 , 2.4f);
		
		
		Entity cuadro = new Entity();
		Entity bola = new Entity();
		Entity mundoEntidad = new Entity();
		Entity camaraEntidad = new Entity();
		
		RenderDebugSystem render = new RenderDebugSystem();
		WorldSystem mundoSistema = new WorldSystem();
		
		cuadro.add(posicionCuadro);
		cuadro.add(fisicaCuadro);
		
		bola.add(posicionBola);
		bola.add(fisicaBola);
		
		camaraEntidad.add(camara);
		
		mundoEntidad.add(mundo);
		
		motor.addEntity(mundoEntidad);
		motor.addEntity(camaraEntidad);
		motor.addEntity(cuadro);
		motor.addEntity(bola);
		motor.addSystem(mundoSistema);
		motor.addSystem(render);
		
	}

	@Override
	public void render(){
		
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		motor.update(Gdx.graphics.getDeltaTime());
	}
}
