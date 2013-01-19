package com.hackaton.firstTeamGame.input;



import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.input.GestureDetector.GestureListener;
import com.badlogic.gdx.math.Vector2;

public class GameInputListener implements InputProcessor,GestureListener{
	private static final String TAG = GameInputListener.class.getSimpleName();
	
	public GameInputListener() {
	}
		
	/**********************************************
	 *** Basic Input(Keyboard and Touch) Events ***
	 **********************************************/
	
	@Override
	public boolean keyDown(int keycode) {
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG,String.format("TouchDown in %d %d with index = %d",screenX,screenY,pointer));
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		//Gdx.app.log(TAG,String.format("TouchUp in %d %d with index = %d",screenX,screenY,pointer));
		return true;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
	
	/**********************
	 *** Touch Gestures ***
	 **********************/

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		//Gdx.app.log(TAG,String.format("Tap in %.2f %.2f %d times",x,y,count));
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		//Gdx.app.log(TAG,String.format("LongPress in %.2f %.2f",x,y));
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		//Gdx.app.log(TAG,String.format("Fling with Velocity(%.2f %.2f",velocityX,velocityY));
		return false;
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		//Gdx.app.log(TAG,String.format("Pan in %.2f %.2f with delta %.2f %.2f",x,y,deltaX,deltaY));
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		//Gdx.app.log(TAG,String.format("Zoom in ini = %.2f, out = %.2f",initialDistance,distance));
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2,Vector2 pointer1, Vector2 pointer2) {
		/*
		Gdx.app.log(TAG,String.format("Pinch starting in %.2f %.2f and %.2f %.2f",
				initialPointer1.x,
				initialPointer1.y,
				initialPointer2.x,
				initialPointer2.y
				));
		*/
		return false;
	}
}

