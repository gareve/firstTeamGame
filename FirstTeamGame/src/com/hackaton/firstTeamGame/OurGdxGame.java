package com.hackaton.firstTeamGame;

import aurelienribon.tweenengine.Tween;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Rectangle;
import com.hackaton.firstTeamGame.screens.FirstScreen;
import com.hackaton.firstTeamGame.tweens.BasicTweenAccessor;

public class OurGdxGame extends Game {

	@Override
	public void create() {
		Gdx.app.setLogLevel(Application.LOG_DEBUG);
		
		Tween.registerAccessor(Rectangle.class, new BasicTweenAccessor());
		setScreen(new FirstScreen(this));
	}
}
