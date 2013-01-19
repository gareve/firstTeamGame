package com.hackaton.firstTeamGame.tweens;

import aurelienribon.tweenengine.TweenAccessor;

import com.badlogic.gdx.math.Rectangle;

public class BasicTweenAccessor implements TweenAccessor<Rectangle>{
	@Override
	public int getValues(Rectangle target, int tweenType, float[] returnValues) {
		returnValues[0] = target.height;
		return 1;
	}

	@Override
	public void setValues(Rectangle target, int tweenType, float[] newValues) {
		target.height = newValues[0];
	}
}