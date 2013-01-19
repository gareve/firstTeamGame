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
	
	public Soldier(float x,float y,SoldierType type,boolean faceLeft,float defense,Vector2 speed,Weapon weapon){
		super(x,y,WIDTH,HEIGHT);
		this.type = type;
		this.state = SoldierState.WALK;
		this.setSpeed(speed);
		this.faceLeft = faceLeft;
		this.defense = defense;
		this.weapon = weapon;
	}

	@Override
	public void next(float delta) {
		Vector2 position = new Vector2(this.shape.x, this.shape.y);
		this.shape.x = this.shape.x + speed.x*delta;
		this.shape.y = this.shape.y + speed.y*delta;
	}
	
	public boolean canShoot(Collection<Soldier> enemies){
		return weapon.canShoot(enemies, this.faceLeft);
	}
	
	public void shoot(Vector2 direction){
		weapon.fireWeapon(this.faceLeft);
	}
	
	public void receiveDamage(float damage){
		this.life -= damage;
	}
}
