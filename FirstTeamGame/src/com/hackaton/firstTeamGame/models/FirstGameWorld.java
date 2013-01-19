package com.hackaton.firstTeamGame.models;

import com.badlogic.gdx.audio.Sound;

import aurelienribon.tweenengine.TweenManager;

public class FirstGameWorld {
	private InputStatus inputStatus;
	private TweenManager tweenManager = new TweenManager();
	
	public FirstGameWorld(InputStatus inputStatus){
		this.inputStatus = inputStatus;
	}
	
	public void next(float delta) {		
		tweenManager.update(delta);
	}
}
