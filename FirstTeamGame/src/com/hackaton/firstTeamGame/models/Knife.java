package com.hackaton.firstTeamGame.models;

import java.util.Collection;

public class Knife extends Weapon {

	public Knife() {
		super();
	}

	@Override
	public boolean canShoot(Collection<Soldier> enemies) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Bullet fireWeapon() {
		// TODO Auto-generated method stub
		return null;
	}

}
