package com.nyrds.pixeldungeon.mobs.necropolis;

import android.support.annotation.NonNull;

import com.nyrds.pixeldungeon.mobs.common.MobSpawner;
import com.watabou.pixeldungeon.Dungeon;
import com.watabou.pixeldungeon.actors.Actor;
import com.watabou.pixeldungeon.actors.Char;
import com.watabou.pixeldungeon.actors.mobs.Mob;
import com.watabou.pixeldungeon.effects.Pushing;

public class JarOfSouls extends UndeadMob {

	public JarOfSouls() {
		hp(ht(70));
		defenseSkill = 5;

		pacified = true;
		
		exp = 0;
		maxLvl = 13;

		postpone(20);
		
		//loot = new SoulShard();
		//lootChance = 1f;
	}

	@Override
	public int damageRoll() {
		return 0;
	}
	
	@Override
	public int attackSkill( Char target ) {
		return 0;
	}
	
	@Override
    public boolean act(){
		super.act();
		if (enemySeen){
			spawnUndead();
		}
		return true;
	}

	private void spawnUndead(){
		getSprite().zap(getEnemy().getPos(), null);

		Mob newMob = MobSpawner.spawnRandomMob(Dungeon.level, getPos());

		int mobPos = Dungeon.level.getEmptyCellNextTo(getPos());

		if (Dungeon.level.cellValid(mobPos)) {
			newMob.setPos(mobPos);
			Actor.addDelayed(new Pushing(newMob, getPos(), newMob.getPos()), -1);
			Dungeon.level.press(mobPos, newMob);
		}
		postpone(15);
	}

	@Override
	public int dr() {
		return 0;
	}

	@Override
	public boolean getCloser(int target) {
		return false;
	}

	@Override
    public boolean getFurther(int target) {
		return false;
	}

	@Override
	public boolean canBePet() {
		return false;
	}

	@Override
	public boolean zap(@NonNull Char enemy) {
		return false;
	}
}
