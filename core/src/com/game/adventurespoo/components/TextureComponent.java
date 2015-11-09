package com.game.adventurespoo.components;

import com.badlogic.ashley.core.Component;
import com.badlogic.gdx.graphics.Texture;

public class TextureComponent implements Component{
		private Texture textura;
		
		public TextureComponent(Texture textura){
			setTextura(textura);
		}
		
		public Texture getTextura(){
			return textura;
		}
		
		public void setTextura(Texture textura){
			this.textura = textura;
		}
		
}
