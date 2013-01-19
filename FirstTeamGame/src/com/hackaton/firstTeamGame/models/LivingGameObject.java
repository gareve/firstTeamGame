package com.hackaton.firstTeamGame.models;

public class LivingGameObject extends GameObject{
	public boolean isAlive;
	float life;
	int keyFrame;
	float timeFrame;
	
	public LivingGameObject(float x,float y,float width,float height){
		super(x,y,width,height);
		isAlive = true;
		keyFrame = 0;
		timeFrame = 0f;
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
