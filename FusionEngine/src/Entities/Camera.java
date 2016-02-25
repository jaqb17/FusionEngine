package Entities;

import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.util.vector.Vector3f;

public class Camera {
	private Vector3f position =new Vector3f(0,0,0);
	private float pitch;
	private float yaw;
	private float roll;
	
	public Camera() {}
	
	
	public void move()
	{
		if(Keyboard.isKeyDown(Keyboard.KEY_S))
		{
			position.y-=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_W))
		{
			position.y+=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_A))
		{
			position.x-=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_D))
		{
			position.x+=0.1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Q))
		{
			pitch+=0.3f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_E))
		{
			pitch-=0.3f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_Z))
		{
			yaw+=1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_C))
		{
			yaw-=1f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_F))
		{
			position.z-=0.05f;
		}
		if(Keyboard.isKeyDown(Keyboard.KEY_G))
		{
			position.z+=0.05f;
		}
		

	}

	public Vector3f getPosition() {
		return position;
	}

	public float getPitch() {
		return pitch;
	}

	public float getYaw() {
		return yaw;
	}

	public float getRoll() {
		return roll;
	}
	
	
	
}
