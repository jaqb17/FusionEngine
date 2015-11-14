package engineTester;

import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.GL11;

import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.RawModel;
import renderEngine.Renderer;

public class MainGameLoop {

	public static void main(String[] args) {
		
		DisplayManager.createDisplay();
		System.out.println(GL11.glGetString(GL11.GL_VERSION));
		Loader loader = new Loader();
		Renderer renderer = new Renderer();
		
		float[] vertices = {
				-0.5f, 0.5f, 0f,
				-0.5f, -0.5f, 0f,
				0.5f, -0.5f, 0f,
				
				0.5f, -0.5f, 0f,
				0.5f, 0.5f, 0f,
				-0.5f, 0.5f, 0f
		};
		
//		RawModel model = loader.loadToVAO(vertices);
	 	
		
		while(!Display.isCloseRequested())
		{
			//renderer.prepare();
			//logika
			//renderer.render(model);
			DisplayManager.updateDisplay();
		}
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
