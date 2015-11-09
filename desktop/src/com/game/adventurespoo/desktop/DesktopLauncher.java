package com.game.adventurespoo.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.game.adventurespoo.AdventuraPoo;
import com.game.adventurespoo.AdventurePoo2;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.height = 480;
		config.width = 800;
		new LwjglApplication(new AdventurePoo2(), config);
	}
}
