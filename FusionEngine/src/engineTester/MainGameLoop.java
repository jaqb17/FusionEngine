package engineTester;

import org.lwjgl.opengl.Display;

import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.MasterRenderer;
import renderEngine.OBJLoader;
import models.RawModel;
import models.TexturedModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

public class MainGameLoop {

	public static void main(String[] args) {

		DisplayManager.createDisplay();

		Loader loader = new Loader();

		

		RawModel model = OBJLoader.loadObjModel("stall", loader);

		TexturedModel staticModel1 = new TexturedModel(model, new ModelTexture(loader.loadTexture("stallTexture")));
		ModelTexture texture1 = staticModel1.getTexture();

		texture1.setShineDamper(1000);
		texture1.setReflectivity(1);

		Entity entity = new Entity(staticModel1, new Vector3f(0f, -2f, -10f), 0, 180.0f, 0, 0.5f);
		Light light = new Light(new Vector3f(0, 5f, 0f), new Vector3f(1f, 1f, 1f));

		Camera camera = new Camera();

		MasterRenderer renderer = new MasterRenderer();
		
		while (!Display.isCloseRequested()) {

			camera.move();
			
			renderer.processEntity(entity);
			
		
			
			 renderer.render(light,camera);
			DisplayManager.updateDisplay();

		}
		renderer.cleanUp();
		loader.cleanUp();
		DisplayManager.closeDisplay();

	}

}
