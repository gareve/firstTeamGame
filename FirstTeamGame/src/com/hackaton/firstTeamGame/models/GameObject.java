package com.hackaton.firstTeamGame.models;

import com.badlogic.gdx.math.Rectangle;

public class GameObject {
	public Rectangle shape;
	
	public float WIDTH,HEIGHT;
	
	public GameObject(float x,float y,float width,float height){
		this.WIDTH = width;
		this.HEIGHT = height;
		this.shape = new Rectangle(x, y, WIDTH, HEIGHT);
	}
}
