package com.hackaton.firstTeamGame.models;

import java.util.Collection;

public interface SimulatableObject {
	public void next(float delta, Collection<Bullet> bullets, Collection<Soldier> enemies);
}
