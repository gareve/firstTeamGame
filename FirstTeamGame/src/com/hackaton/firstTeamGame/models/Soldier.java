package com.hackaton.firstTeamGame.models;

import java.util.Collection;

import com.badlogic.gdx.math.Vector2;

public class Soldier extends LivingGameObject implements SimulatableObject{
	public static final float WIDTH = 10f;
	public static final float HEIGHT = 20f;
	
	public static enum SoldierState{
		WALK,SHOT,DEAD
	}
	public static enum SoldierType{
		Sargent,Officer
	}
	
	public SoldierState state;
	public SoldierType type;

	Weapon weapon;

	public boolean faceLeft;
	public float defense;
	
	public Soldier(float x,float y,SoldierType type,boolean faceLeft,float defense,Vector2 speed){
		super(x,y,WIDTH,HEIGHT);
		this.type = type;
		state = SoldierState.WALK;
		this.faceLeft = faceLeft;
		this.defense = defense;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.weapon.setOwner(this);
	}

	@Override
	public void next(float delta) {
	}
	
	public boolean canShoot(Collection<Soldier> enemies){
		return weapon.canShoot(enemies);
	}
	
	public void shoot(Vector2 direction){
		weapon.fireWeapon();
	}
	
	public void receiveDamage(float damage){
		life -= damage;
	}
}
