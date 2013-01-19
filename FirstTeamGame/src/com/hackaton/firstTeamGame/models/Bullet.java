package com.hackaton.firstTeamGame.models;

import java.util.Collection;

public class Bullet extends LivingGameObject implements SimulatableObject{
	
	public float damage;
	
	public Bullet(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	public Soldier intersects(float delta, Collection<Soldier> soldiers) {
		return null;
	}

	@Override
	public void next(float delta, Collection<Bullet> bullets,
			Collection<Soldier> enemies) {
		// TODO Auto-generated method stub
		
	}
}
