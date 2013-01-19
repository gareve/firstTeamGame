package com.hackaton.firstTeamGame.models;

import com.badlogic.gdx.math.Rectangle;

public class GameObject {
	public Rectangle shape;
	
	public GameObject(float x,float y,float width,float height){
		this.shape = new Rectangle(x, y, width, height);
	}
}
