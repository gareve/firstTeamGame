package com.hackaton.firstTeamGame.screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.input.GestureDetector;
import com.hackaton.firstTeamGame.OurGdxGame;
import com.hackaton.firstTeamGame.input.GameInputListener;
import com.hackaton.firstTeamGame.models.FirstGameWorld;
import com.hackaton.firstTeamGame.models.InputStatus;
import com.hackaton.firstTeamGame.view.FirstGameRenderer;

public class FirstScreen implements Screen {
	private FirstGameWorld gameWorld;
	private FirstGameRenderer renderer;
	private InputStatus inputStatus;
	private OurGdxGame ourGdxGame;
	
	public FirstScreen(OurGdxGame ourGdxGame){
		this.ourGdxGame = ourGdxGame;
	}
	
	@Override
	public void render(float delta) {
		gameWorld.next(delta);
		renderer.render();
	}

	@Override
	public void resize(int width, int height) {
		renderer.resize(width, height);
	}

	@Override
	public void show() {
		inputStatus = new InputStatus();
		renderer = new FirstGameRenderer();
		gameWorld = new FirstGameWorld(inputStatus);
		
		InputMultiplexer multiplexer = new InputMultiplexer(new GameInputListener(),new GestureDetector(new GameInputListener()));
		Gdx.input.setInputProcessor(multiplexer);
		
		renderer.setFirstGameWorld(gameWorld);
	}

	@Override
	public void hide() {
		Gdx.input.setInputProcessor(null);
	}

	@Override
	public void pause() {
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
		Gdx.input.setInputProcessor(null);
	}
}
