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
	//ModelTexture texture = new ModelTexture(loader.loadTexture("dragonTexture"));
	TexturedModel staticModel1 = new TexturedModel(model, new ModelTexture(loader.loadTexture("dragonTexture")));
	ModelTexture texture1 = staticModel1.getTexture();
	texture1.setShineDamper(275);
	texture1.setReflectivity(100);
	
	//TexturedModel staticModel2 = new TexturedModel(model, new ModelTexture(loader.loadTexture("dragonTextureb")));
	//ModelTexture texture2 = staticModel2.getTexture();
	//texture2.setShineDamper(3);
	//texture2.setReflectivity(10);
	
	Entity entity = new Entity(staticModel1, new Vector3f(4f, 0, -10f), 0, 0, 0, 0.5f);
	Light light = new Light(new Vector3f (0,0,0f),new Vector3f(1f,1f,1f));
	//Entity entity2 = new Entity(staticModel2, new Vector3f(-4f, 0, -10f), 0, 0, 0, 0.5f);
	
	

	Camera camera = new Camera();

	while (!Display.isCloseRequested()) {
	    entity.increaseRotation(0, 1, 0);
	  //  entity2.increaseRotation(0, -1, 0);
	   // entity.increasePosition(0, 0,-0.002f );
	    camera.move();
	    renderer.prepare();
	    shader.start();
	    shader.loadLight(light);
	    shader.loadViewMatrix(camera);
	    renderer.render(entity, shader);
	   // renderer.render(entity2, shader);
	   
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
