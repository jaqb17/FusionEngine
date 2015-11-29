package engineTester;

import org.lwjgl.opengl.Display;

import org.lwjgl.util.vector.Vector3f;

import Entities.Camera;
import Entities.Entity;
import renderEngine.DisplayManager;
import renderEngine.Loader;
import renderEngine.OBJLoader;
import models.RawModel;
import models.TexturedModel;
import renderEngine.Renderer;
import shaders.StaticShader;
import textures.ModelTexture;

//first succesfull compilation on windows!

public class MainGameLoop {

    public static void main(String[] args) {

	DisplayManager.createDisplay();

	Loader loader = new Loader();

	StaticShader shader = new StaticShader();
	Renderer renderer = new Renderer(shader);

	RawModel model = OBJLoader.loadObjModel("dragon", loader);
	ModelTexture texture = new ModelTexture(loader.loadTexture("stallTexture"));
	TexturedModel staticModel = new TexturedModel(model, texture);

	Entity entity = new Entity(staticModel, new Vector3f(0, 0, -15f), 0, 0, 0, 0.5f);

	

	Camera camera = new Camera();

	while (!Display.isCloseRequested()) {
	    entity.increaseRotation(0, 1, 0);
	    entity.increasePosition(0, 0,-0.002f );
	    camera.move();
	    renderer.prepare();
	    shader.start();
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
