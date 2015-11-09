package com.game.adventurespoo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;

public class AdventuraPoo extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	World mundo ;
	Box2DDebugRenderer render;
	public OrthographicCamera camara ;
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		mundo = new World(new Vector2(0,-10) ,true);
		render = new Box2DDebugRenderer();
		camara = new OrthographicCamera(8 , 4.8f);
		camara.position.x = 4;
		camara.position.y = 2.4f;
		camara.update();
		
		buildBody();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		
		mundo.step(Gdx.graphics.getDeltaTime() , 6,2);
		render.render(mundo, camara.combined);
		
	}
	
	public void buildBody(){
		BodyDef def = new BodyDef();
		def.position.x = 4f;
		def.position.y = 2.4f;
		def.type = BodyType.DynamicBody;
		
		Body cuerpo = mundo.createBody(def);
		
		CircleShape circulo = new CircleShape();
		circulo.setRadius(.15f);
		
		FixtureDef fix = new FixtureDef();
		fix.shape = circulo;
		fix.density = 1;
		
		cuerpo.createFixture(fix);
		
		circulo.dispose();
	}
}
