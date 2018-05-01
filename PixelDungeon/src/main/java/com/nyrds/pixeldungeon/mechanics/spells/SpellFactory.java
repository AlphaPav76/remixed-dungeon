package com.nyrds.pixeldungeon.mechanics.spells;

import android.support.annotation.Nullable;

import com.nyrds.android.util.TrackedRuntimeException;
import com.nyrds.pixeldungeon.ml.EventCollector;
import com.watabou.pixeldungeon.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class SpellFactory {

	static private Map<String, Class<? extends Spell>> mSpellsList = new HashMap<>();
	static private Map<Class<? extends Spell>,String>  mNamesList = new HashMap<>();

	static private Map<String,ArrayList<String>> mSpellsByAffinity = new HashMap<>();
	static {
		initSpellsMap();
	}

	private static void registerSpellClass(Class<? extends Spell> spellClass) {
		mSpellsList.put(spellClass.getSimpleName(), spellClass);
		mNamesList.put(spellClass, spellClass.getSimpleName());

		try {
			Spell spell = spellClass.newInstance();
			String affinity = spell.getMagicAffinity();

			if(!mSpellsByAffinity.containsKey(affinity)) {
				mSpellsByAffinity.put(affinity, new ArrayList<String>());
			}

			mSpellsByAffinity.get(affinity).add(spellClass.getSimpleName());

		} catch (InstantiationException e) {
			throw new TrackedRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new TrackedRuntimeException(e);
		}
	}

	private static void initSpellsMap() {
		registerSpellClass(SummonDeathling.class);
		//registerSpellClass(CausePainSpell.class);
		//registerSpellClass(RaiseDead.class);
		//registerSpellClass(Desecrate.class);

		registerSpellClass(WindGust.class);
		registerSpellClass(Ignite.class);
		registerSpellClass(RootSpell.class);
		registerSpellClass(FreezeGlobe.class);

		registerSpellClass(MagicTorch.class);
		registerSpellClass(Healing.class);
		//registerSpellClass(TownPortal.class);
	}

	public static boolean hasSpellForName (String name) {
		return mSpellsList.get(name) != null;
	}

	@Nullable
	public static Spell getSpellByName(String name) {
		try {
			Class<? extends Spell> spellClass =  mSpellsList.get(name);
			if (spellClass == null) {
				EventCollector.logEvent("bug", Utils.format("Unknown spell: [%s], getting Magic Torch instead",name));
				spellClass =  mSpellsList.get("MagicTorch");
			}
			return spellClass.newInstance();
		} catch (InstantiationException e) {
			throw new TrackedRuntimeException(e);
		} catch (IllegalAccessException e) {
			throw new TrackedRuntimeException(e);
		}
	}

	@Nullable
	public static ArrayList<String> getSpellsByAffinity(String affinity) {
		return mSpellsByAffinity.get(affinity);
	}

}
