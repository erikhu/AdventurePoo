package com.game.adventurespoo.builders;

import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.Fixture;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;
import com.game.adventurespoo.components.Position;

public class BuilderBody {

	public static Body builderBodyDynamic(World mundo , Position position, float radio){
	
		BodyDef def = new BodyDef();
		
		def.position.x = position.x;
		def.position.y = position.y;	
		def.type = BodyDef.BodyType.DynamicBody;
		
		Body cuerpo = mundo.createBody(def);
		
		CircleShape circle = new CircleShape();
		circle.setRadius(radio);
		
		FixtureDef fix =  new FixtureDef();
		fix.shape = circle;
		fix.density = 0.5f;
		fix.friction = 0.4f;
		fix.restitution = 0.6f;
		
		Fixture fixture = cuerpo.createFixture(fix);
		
		circle.dispose();
		
		
		return cuerpo;
	};
	
	public static Body builderBodyStatic(World mundo, Position posicion , float ancho , float alto){
		
		BodyDef def = new BodyDef();
		def.type = BodyDef.BodyType.StaticBody;
		def.position.set(posicion.x, posicion.y);
		Body cuerpo = mundo.createBody(def);
		PolygonShape cuadro = new PolygonShape();
		cuadro.setAsBox(ancho,alto);
		FixtureDef fix = new FixtureDef();
		fix.shape = cuadro;
		fix.density = 1;
		Fixture fixture = cuerpo.createFixture(fix);
		cuadro.dispose();
		return cuerpo;
	}
}
