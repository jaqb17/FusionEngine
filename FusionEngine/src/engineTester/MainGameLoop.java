package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import models.RawModel;
import models.TexturedModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();

		
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		StaticShader shader = new StaticShader();

		float[] vertices = { -0.5f, 0.5f, 0f, -0.5f, -0.5f, 0f, 0.5f, -0.5f, 0f, 0.5f, 0.5f, 0f };

		int[] indices = { 0, 1, 3, 3, 1, 2 };

		float[] textureCoords=
		{
			0,0,
			0,1f,
			1,1f,
			1,0
		};
		
		RawModel model = loader.loadToVAO(vertices,textureCoords, indices);
		ModelTexture texture = new ModelTexture(loader.loadTexture("image"));
		TexturedModel texturedModel = new TexturedModel(model, texture);

		while (!Display.isCloseRequested()) {
			renderer.prepare();
			shader.start();
			renderer.render(texturedModel);
			shader.stop();
			// logika
			// renderer.render(model);
			DisplayManager.updateDisplay();
			
		}
		shader.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
