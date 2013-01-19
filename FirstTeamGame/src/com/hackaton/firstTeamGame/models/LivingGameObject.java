package com.hackaton.firstTeamGame.models;

public class LivingGameObject extends GameObject {
	
	public boolean isAlive;
	public LivingGameObject(float x,float y,float width,float height){
		super(x,y,width,height);
		isAlive = true;
	}

	public void kill(){
		isAlive = false;
	}
}
