package com.hackaton.firstTeamGame.models;

import java.util.Collection;

import com.badlogic.gdx.math.Vector2;

public class Soldier extends LivingGameObject{
	public static final float WIDTH = 10f;
	public static final float HEIGHT = 20f;
	public static final float LIFE = 20f;
	
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
		super(x, y, WIDTH, HEIGHT, LIFE);
		this.type = type;
		this.state = SoldierState.WALK;
		this.faceLeft = faceLeft;
		this.defense = defense;
		this.speed = speed;
	}
	
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
		this.weapon.setOwner(this);
	}

	public void next(float delta, Collection<Bullet> bullets, Collection<Soldier> enemies) {
		if(this.weapon.canShoot(enemies)) {
			setShooting();
		}
		else {
			setWalking();
		}
		
		if(this.state == SoldierState.WALK) {
			this.shape.x = this.shape.x + this.speed.x*delta;
		}
		else if(this.state == SoldierState.SHOT) {
			Bullet bullet = this.shoot();
			if(bullet != null) {
				bullets.add(bullet);
			}
		}
	}
	
	private void setShooting() {
		this.state = SoldierState.SHOT;
		keyFrame = 0;
		timeFrame = 0;
	}
	
	private void setWalking() {
		this.state = SoldierState.WALK;
		keyFrame = 0;
		timeFrame = 0;
	}
	
	public void setDead() {
		this.state = SoldierState.DEAD;
		keyFrame = 0;
		timeFrame = 0;
	}
	
	public boolean canShoot(Collection<Soldier> enemies){
		return weapon.canShoot(enemies);
	}
	
	public Bullet shoot(){
		Bullet bullet = this.weapon.fireWeapon();
		return bullet;
	}
	
	public void receiveDamage(float damage){
		life -= damage;
	}
	
	public void nextAnimation(float delta){
		timeFrame += delta;
		
	}
}
