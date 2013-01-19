package com.hackaton.firstTeamGame.models;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;
import com.hackaton.firstTeamGame.GameConstants;
import com.hackaton.firstTeamGame.models.Soldier.SoldierType;

import aurelienribon.tweenengine.TweenManager;

public class FirstGameWorld {
	private final String TAG = FirstGameWorld.class.getSimpleName();
	
	private InputStatus inputStatus;
	private TweenManager tweenManager = new TweenManager();
	
	public Collection<Soldier> soldiersA,soldiersB;
	public Collection<Bullet> bulletsA,bulletsB;
	
	private final float SPAWN_TIME = 1f;
	
	private float time;
	
	public FirstGameWorld(InputStatus inputStatus){
		this.inputStatus = inputStatus;
		
		soldiersA = new LinkedList<Soldier>();
		soldiersB = new LinkedList<Soldier>();
		
		bulletsA = new LinkedList<Bullet>();
		bulletsB = new LinkedList<Bullet>();
		
		time = 0f;
	}
	
	public void next(float delta) {
		time += delta;if(time >= SPAWN_TIME){
			while(time >= SPAWN_TIME)time -= SPAWN_TIME;
			soldiersA.add(createSoldier(true));
			soldiersB.add(createSoldier(false));
		}

		for(Iterator<Soldier> it = soldiersA.iterator();it.hasNext();){
			Soldier soldier = it.next();
			soldier.next(delta,bulletsA,soldiersB);
		}
		for(Iterator<Soldier> it = soldiersB.iterator();it.hasNext();){
			Soldier soldier = it.next();
			soldier.next(delta,bulletsB,soldiersA);
		}
		
		for(Iterator<Bullet> it = bulletsA.iterator();it.hasNext();){
			Bullet bullet = it.next();

			Soldier hitSoldier = null;//bullet.intersects(delta,soldiersB);
			if(hitSoldier != null){
				//hitSoldier.receiveDamage(bullet.damage);
				bullet.kill();
			}else{
				//bullet.next(delta,soldiersB);
			}
		}
		
		tweenManager.update(delta);
	}

	private Soldier createSoldier(boolean forTeamA) {
		float x = forTeamA ? -Soldier.WIDTH : GameConstants.GAME_WIDTH;
		float y = GameConstants.GAME_HEIGHT * 0.10f;
		SoldierType soldierType = Math.random() <= 0.60 ? SoldierType.Sargent : SoldierType.Officer;
		Vector2 speed = new Vector2((forTeamA?1f:-1f) * GameConstants.SOLDIER_SPEED, 0f);
		float defense = 0f;
		
		Soldier soldier = new Soldier(x, y, soldierType, !forTeamA, defense, speed);
		
		Weapon weapon = null;
		if(soldierType == SoldierType.Officer)
			weapon = new Rifle();
		else
			weapon = new Knife();
		
		soldier.setWeapon(weapon);
		
		Gdx.app.log(TAG, "Creating Soldier");
		
		return soldier;
	}
}
