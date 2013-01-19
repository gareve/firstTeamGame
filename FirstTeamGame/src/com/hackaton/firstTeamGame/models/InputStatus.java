package com.hackaton.firstTeamGame.models;

public class InputStatus {
	private boolean isLeft,isRight,isUp,isDown;
	
	public InputStatus(){
		isLeft = false;
		isRight = false;
		isUp = false;
		isDown = false;
	}
	
	public void pressLeft(){
		isLeft = true;
		isRight = false;
	}
	
	public void pressRight(){
		isLeft = false;
		isRight = true;
	}
	
	public void pressUp(){
		isUp = true;
		isDown = false;
	}
	
	public void pressDown(){
		isUp = false;
		isDown = true;
	}
	
	
}
