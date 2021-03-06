package com.hackaton.firstTeamGame.models;

import java.util.Collection;

public abstract class Weapon{
	public float damage;
	public float range;
	public Soldier owner;
	
	public Weapon() {
	}

	public abstract boolean canShoot(Collection<Soldier> enemies);
	public abstract Bullet fireWeapon();
	
	public void setOwner(Soldier owner) {
		this.owner = owner;
	}
}
