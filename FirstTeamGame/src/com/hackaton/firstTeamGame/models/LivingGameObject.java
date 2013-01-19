package com.hackaton.firstTeamGame.models;

import com.badlogic.gdx.math.Vector2;

public class LivingGameObject extends GameObject{
	public boolean isAlive;
	float life;
	int keyFrame;
	float timeFrame;
	
	public Vector2 speed;
	
	public LivingGameObject(float x,float y,float width,float height){
		super(x,y,width,height);
		isAlive = true;
		keyFrame = 0;
		timeFrame = 0f;
	}

	public void setSpeed(Vector2 speed){
		this.speed = speed;
	}

	public LivingGameObject(float x,float y,float width,float height,float initialLife){
		super(x,y,width,height);
		isAlive = true;
		life = initialLife;
		
		keyFrame = 0;
		timeFrame = 0f;
	}
	
	public void nextAnimation(float delta){
		timeFrame += delta;
		
	}

	public void kill(){
		isAlive = false;
	}

	public boolean isAlive(){
		return isAlive;
	}
}
