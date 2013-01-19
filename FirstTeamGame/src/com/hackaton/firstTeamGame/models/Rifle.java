package com.hackaton.firstTeamGame.models;

import java.util.Collection;
import java.util.Iterator;

import com.badlogic.gdx.math.Vector2;
import com.hackaton.firstTeamGame.GameConstants;

public class Rifle extends Weapon {
	
	Collection<Bullet> bullets;
	
	public Rifle() {
		super();
		damage = 5f;
		range = 2f;
	}

	@Override
	public boolean canShoot(Collection<Soldier> enemies) {
		// TODO Auto-generated method stub
		Soldier enemy,
				owner = this.owner;
		
		float range = this.range;
		
		for (Iterator<Soldier> iterator = enemies.iterator(); iterator.hasNext();) {
			enemy = (Soldier)iterator.next();
			if (owner.faceLeft) {
				if (enemy.shape.x < owner.shape.x && enemy.shape.x + range >= owner.shape.x) {
					return true;
				}
			} else {
				if (enemy.shape.x > owner.shape.x && owner.shape.x + range >= enemy.shape.x) {
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Bullet fireWeapon() {
		// TODO Auto-generated method stub
		Bullet bullet = new Bullet(owner.shape.x + owner.shape.width, owner.shape.y + owner.shape.height, 5, 5, this.damage);
		bullet.setSpeed(new Vector2(GameConstants.BULLET_SPEED, 0));
		return bullet;
	}

}
