package Entities;

import org.lwjgl.util.vector.Vector3f;

import models.TexturedModel;

public class Entity {
	private TexturedModel model;
	private Vector3f position;
	private float RotX, RotY, RotZ;
	private float scale;
	public Entity(TexturedModel model, Vector3f position, float rotX, float rotY, float rotZ, float scale) {
	
		this.model = model;
		this.position = position;
		RotX = rotX;
		RotY = rotY;
		RotZ = rotZ;
		this.scale = scale;
	}
	
	
	public void increasePosition(float dx, float dy, float dz)
	{
		this.position.x+=dx;
		this.position.y+=dy;
		this.position.z+=dz;
	}
	
	public void increaseRotation(float rx, float ry, float rz)
	{
		this.RotX+=rx;
		this.RotY+=ry;
		this.RotZ+=rz;
	}
	
	public TexturedModel getModel() {
		return model;
	}
	public void setModel(TexturedModel model) {
		this.model = model;
	}
	public Vector3f getPosition() {
		return position;
	}
	public void setPosition(Vector3f position) {
		this.position = position;
	}
	public float getRotX() {
		return RotX;
	}
	public void setRotX(float rotX) {
		RotX = rotX;
	}
	public float getRotY() {
		return RotY;
	}
	public void setRotY(float rotY) {
		RotY = rotY;
	}
	public float getRotZ() {
		return RotZ;
	}
	public void setRotZ(float rotZ) {
		RotZ = rotZ;
	}
	public float getScale() {
		return scale;
	}
	public void setScale(float scale) {
		this.scale = scale;
	}
	
	
}
