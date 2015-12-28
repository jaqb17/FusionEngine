package engineTester;

import org.lwjgl.opengl.Display;

import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Entity;
import Entities.Light;
import renderEngine.DisplayManager;
import renderEngine.Loader;
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

		StaticShader shader = new StaticShader();
		Renderer renderer = new Renderer(shader);

		RawModel model = OBJLoader.loadObjModel("dragon", loader);

		TexturedModel staticModel1 = new TexturedModel(model, new ModelTexture(loader.loadTexture("dragonTexture")));
		ModelTexture texture1 = staticModel1.getTexture();

		texture1.setShineDamper(150);
		texture1.setReflectivity(75);

		Entity entity = new Entity(staticModel1, new Vector3f(0f, -2f, -10f), 0, 180.0f, 0, 0.5f);
		Light light = new Light(new Vector3f(0, 5f, -11f), new Vector3f(1f, 1f, 1f));

		Camera camera = new Camera();

		while (!Display.isCloseRequested()) {

			camera.move();

			renderer.prepare();
			shader.start();
			shader.loadLight(light);
			shader.loadViewMatrix(camera);
			renderer.render(entity, shader);

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
