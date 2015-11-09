package com.game.adventurespoo.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector3;

public class CameraComponent implements Component{
	
	private OrthographicCamera  camara;
	
	public CameraComponent(OrthographicCamera camara){
		setCamara(camara);
	}
	
	public CameraComponent( float viewWidth ,float viewHeight ){
		setCamara(new OrthographicCamera(viewWidth , viewHeight));
	}
	
	public CameraComponent(float viewWidth,float viewHeight , float posicionX , float posicionY){
		OrthographicCamera camara = new OrthographicCamera(viewWidth , viewHeight);
		camara.position.set(posicionX, posicionY, 0);
		camara.update();
		setCamara(camara);
	}
	
	public CameraComponent(){
		setCamara(new OrthographicCamera());
	}

	public OrthographicCamera getCamara() {
		return camara;
	}

	public void setCamara(OrthographicCamera camara) {
		this.camara = camara;
	}

}
