package com.hackaton.firstTeamGame.models;

import java.util.Collection;
import java.util.Iterator;

public class Bullet extends LivingGameObject{
	
	public float damage;
	
	public Bullet(float x, float y, float width, float height) {
		super(x, y, width, height);
	}
	
	public Soldier intersects(float delta, Collection<Soldier> enemies) {
		float newX = this.shape.x + delta * speed.x;
		for (Iterator<Soldier> iterator = enemies.iterator(); iterator.hasNext();) {
			Soldier enemy = (Soldier)iterator.next();
			if (enemy.shape.x <= newX && enemy.shape.x + enemy.shape.width >= newX) {
				return enemy;
			}
		}
		return null;
	}

}
