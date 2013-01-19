package com.hackaton.firstTeamGame.view;

import java.util.Collection;
import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.hackaton.firstTeamGame.GameConstants;
import com.hackaton.firstTeamGame.models.FirstGameWorld;
import com.hackaton.firstTeamGame.models.Soldier;

public class FirstGameRenderer {
	private FirstGameWorld gameWorld;
	private OrthographicCamera camera;
	private ShapeRenderer shapeRenderer = new ShapeRenderer();
	private SpriteBatch spriteBatch = new SpriteBatch();
	private FPSLogger fpsLogger = new FPSLogger();
	
	public FirstGameRenderer(){
		loadResources();
		
		camera = new OrthographicCamera(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
		camera.position.x = GameConstants.GAME_WIDTH / 2f;
		camera.position.y = GameConstants.GAME_HEIGHT / 2f;
		camera.update();
	}
	
	public void loadResources(){
		loadTextures();
		loadSounds();
	}
	
	private void loadTextures(){
	}
	private void loadSounds(){
	}
	
	public void resize(float width,float height){
	}
	
	public void setFirstGameWorld(FirstGameWorld firstGameWorld){
		this.gameWorld = firstGameWorld;
	}

	public void render(){
		initCamera();

		drawSoldiers(gameWorld.soldiersA);
		drawSoldiers(gameWorld.soldiersB);
	}

	private void drawSoldiers(Collection<Soldier> soldiers) {
		
		shapeRenderer.begin(ShapeType.Rectangle);
		for(Iterator<Soldier> it = soldiers.iterator();it.hasNext();){
			Soldier soldier = it.next();
			if(soldier.faceLeft)
				shapeRenderer.setColor(0.0f, 1.0f, 0.0f, 1f);
			else
				shapeRenderer.setColor(0.0f, 0.0f, 1.0f, 1f);
			shapeRenderer.rect(soldier.shape.x,soldier.shape.y,soldier.shape.width,soldier.shape.height);
		}
		shapeRenderer.end();
	}

	public void initCamera(){
		shapeRenderer.setProjectionMatrix(camera.combined);
		spriteBatch.getProjectionMatrix().setToOrtho2D(0f, 0, GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
		
		Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);
		
		Gdx.gl.glBlendFunc(GL10.GL_SRC_ALPHA, GL10.GL_ONE_MINUS_SRC_ALPHA);
		
		fpsLogger.log();
	}
}
