package com.nyrds.pixeldungeon.mechanics.spells;

import com.nyrds.android.util.TrackedRuntimeException;
import com.nyrds.pixeldungeon.items.artifacts.CandleOfMindVision;
import com.nyrds.pixeldungeon.items.chaos.ChaosArmor;
import com.nyrds.pixeldungeon.items.chaos.ChaosBow;
import com.nyrds.pixeldungeon.items.chaos.ChaosCrystal;
import com.nyrds.pixeldungeon.items.chaos.ChaosStaff;
import com.nyrds.pixeldungeon.items.chaos.ChaosSword;
import com.nyrds.pixeldungeon.items.common.ElvenBow;
import com.nyrds.pixeldungeon.items.common.ElvenDagger;
import com.nyrds.pixeldungeon.items.common.GoldenSword;
import com.nyrds.pixeldungeon.items.common.RatArmor;
import com.nyrds.pixeldungeon.items.common.RatHide;
import com.nyrds.pixeldungeon.items.common.RatKingCrown;
import com.nyrds.pixeldungeon.items.common.SacrificialSword;
import com.nyrds.pixeldungeon.items.common.WandOfShadowbolt;
import com.nyrds.pixeldungeon.items.common.armor.NecromancerArmor;
import com.nyrds.pixeldungeon.items.common.armor.NecromancerRobe;
import com.nyrds.pixeldungeon.items.common.armor.SpiderArmor;
import com.nyrds.pixeldungeon.items.common.rings.RingOfFrost;
import com.nyrds.pixeldungeon.items.food.Candy;
import com.nyrds.pixeldungeon.items.food.ChristmasTurkey;
import com.nyrds.pixeldungeon.items.food.PumpkinPie;
import com.nyrds.pixeldungeon.items.food.RottenPumpkinPie;
import com.nyrds.pixeldungeon.items.guts.HeartOfDarkness;
import com.nyrds.pixeldungeon.items.guts.PseudoAmulet;
import com.nyrds.pixeldungeon.items.guts.armor.GothicArmor;
import com.nyrds.pixeldungeon.items.guts.weapon.melee.Claymore;
import com.nyrds.pixeldungeon.items.guts.weapon.melee.Halberd;
import com.nyrds.pixeldungeon.items.guts.weapon.ranged.CompositeCrossbow;
import com.nyrds.pixeldungeon.items.guts.weapon.ranged.RubyCrossbow;
import com.nyrds.pixeldungeon.items.guts.weapon.ranged.WoodenCrossbow;
import com.nyrds.pixeldungeon.items.icecaves.IceKey;
import com.nyrds.pixeldungeon.items.icecaves.WandOfIcebolt;
import com.nyrds.pixeldungeon.items.material.IceGuardianCoreModule;
import com.nyrds.pixeldungeon.items.material.SoulShard;
import com.nyrds.pixeldungeon.items.material.SpiderQueenCarapace;
import com.nyrds.pixeldungeon.items.necropolis.BlackSkull;
import com.nyrds.pixeldungeon.items.necropolis.BlackSkullOfMastery;
import com.nyrds.pixeldungeon.items.necropolis.BladeOfSouls;
import com.nyrds.pixeldungeon.ml.EventCollector;
import com.watabou.noosa.Game;
import com.watabou.pixeldungeon.actors.mobs.npcs.WandMaker;
import com.watabou.pixeldungeon.items.Amulet;
import com.watabou.pixeldungeon.items.Ankh;
import com.watabou.pixeldungeon.items.ArmorKit;
import com.watabou.pixeldungeon.items.Codex;
import com.watabou.pixeldungeon.items.DewVial;
import com.watabou.pixeldungeon.items.Dewdrop;
import com.watabou.pixeldungeon.items.Gold;
import com.watabou.pixeldungeon.items.Item;
import com.watabou.pixeldungeon.items.LloydsBeacon;
import com.watabou.pixeldungeon.items.SpiderCharm;
import com.watabou.pixeldungeon.items.Stylus;
import com.watabou.pixeldungeon.items.TomeOfMastery;
import com.watabou.pixeldungeon.items.Torch;
import com.watabou.pixeldungeon.items.Weightstone;
import com.watabou.pixeldungeon.items.armor.AssasinArmor;
import com.watabou.pixeldungeon.items.armor.BattleMageArmor;
import com.watabou.pixeldungeon.items.armor.BerserkArmor;
import com.watabou.pixeldungeon.items.armor.ClothArmor;
import com.watabou.pixeldungeon.items.armor.ElfArmor;
import com.watabou.pixeldungeon.items.armor.FreeRunnerArmor;
import com.watabou.pixeldungeon.items.armor.GladiatorArmor;
import com.watabou.pixeldungeon.items.armor.HuntressArmor;
import com.watabou.pixeldungeon.items.armor.LeatherArmor;
import com.watabou.pixeldungeon.items.armor.MageArmor;
import com.watabou.pixeldungeon.items.armor.MailArmor;
import com.watabou.pixeldungeon.items.armor.PlateArmor;
import com.watabou.pixeldungeon.items.armor.RogueArmor;
import com.watabou.pixeldungeon.items.armor.ScaleArmor;
import com.watabou.pixeldungeon.items.armor.ScoutArmor;
import com.watabou.pixeldungeon.items.armor.ShamanArmor;
import com.watabou.pixeldungeon.items.armor.SniperArmor;
import com.watabou.pixeldungeon.items.armor.WardenArmor;
import com.watabou.pixeldungeon.items.armor.WarlockArmor;
import com.watabou.pixeldungeon.items.armor.WarriorArmor;
import com.watabou.pixeldungeon.items.bags.Keyring;
import com.watabou.pixeldungeon.items.bags.PotionBelt;
import com.watabou.pixeldungeon.items.bags.Quiver;
import com.watabou.pixeldungeon.items.bags.ScrollHolder;
import com.watabou.pixeldungeon.items.bags.SeedPouch;
import com.watabou.pixeldungeon.items.bags.WandHolster;
import com.watabou.pixeldungeon.items.food.ChargrilledMeat;
import com.watabou.pixeldungeon.items.food.FrozenCarpaccio;
import com.watabou.pixeldungeon.items.food.MysteryMeat;
import com.watabou.pixeldungeon.items.food.OverpricedRation;
import com.watabou.pixeldungeon.items.food.Pasty;
import com.watabou.pixeldungeon.items.food.PseudoPasty;
import com.watabou.pixeldungeon.items.food.Ration;
import com.watabou.pixeldungeon.items.food.RottenMeat;
import com.watabou.pixeldungeon.items.food.RottenPasty;
import com.watabou.pixeldungeon.items.food.RottenRation;
import com.watabou.pixeldungeon.items.keys.GoldenKey;
import com.watabou.pixeldungeon.items.keys.IronKey;
import com.watabou.pixeldungeon.items.keys.SkeletonKey;
import com.watabou.pixeldungeon.items.potions.PotionOfExperience;
import com.watabou.pixeldungeon.items.potions.PotionOfFrost;
import com.watabou.pixeldungeon.items.potions.PotionOfHealing;
import com.watabou.pixeldungeon.items.potions.PotionOfInvisibility;
import com.watabou.pixeldungeon.items.potions.PotionOfLevitation;
import com.watabou.pixeldungeon.items.potions.PotionOfLiquidFlame;
import com.watabou.pixeldungeon.items.potions.PotionOfMight;
import com.watabou.pixeldungeon.items.potions.PotionOfMindVision;
import com.watabou.pixeldungeon.items.potions.PotionOfParalyticGas;
import com.watabou.pixeldungeon.items.potions.PotionOfPurity;
import com.watabou.pixeldungeon.items.potions.PotionOfStrength;
import com.watabou.pixeldungeon.items.potions.PotionOfToxicGas;
import com.watabou.pixeldungeon.items.quest.CorpseDust;
import com.watabou.pixeldungeon.items.quest.DarkGold;
import com.watabou.pixeldungeon.items.quest.DriedRose;
import com.watabou.pixeldungeon.items.quest.DwarfToken;
import com.watabou.pixeldungeon.items.quest.Pickaxe;
import com.watabou.pixeldungeon.items.quest.RatSkull;
import com.watabou.pixeldungeon.items.rings.RingOfAccuracy;
import com.watabou.pixeldungeon.items.rings.RingOfDetection;
import com.watabou.pixeldungeon.items.rings.RingOfElements;
import com.watabou.pixeldungeon.items.rings.RingOfEvasion;
import com.watabou.pixeldungeon.items.rings.RingOfHaggler;
import com.watabou.pixeldungeon.items.rings.RingOfHaste;
import com.watabou.pixeldungeon.items.rings.RingOfHerbalism;
import com.watabou.pixeldungeon.items.rings.RingOfMending;
import com.watabou.pixeldungeon.items.rings.RingOfPower;
import com.watabou.pixeldungeon.items.rings.RingOfSatiety;
import com.watabou.pixeldungeon.items.rings.RingOfShadows;
import com.watabou.pixeldungeon.items.rings.RingOfStoneWalking;
import com.watabou.pixeldungeon.items.rings.RingOfThorns;
import com.watabou.pixeldungeon.items.scrolls.BlankScroll;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfChallenge;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfCurse;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfDomination;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfIdentify;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfLullaby;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfMagicMapping;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfMirrorImage;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfPsionicBlast;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfRecharging;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfRemoveCurse;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfTeleportation;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfTerror;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfUpgrade;
import com.watabou.pixeldungeon.items.scrolls.ScrollOfWeaponUpgrade;
import com.watabou.pixeldungeon.items.wands.WandOfAmok;
import com.watabou.pixeldungeon.items.wands.WandOfAvalanche;
import com.watabou.pixeldungeon.items.wands.WandOfBlink;
import com.watabou.pixeldungeon.items.wands.WandOfDisintegration;
import com.watabou.pixeldungeon.items.wands.WandOfFirebolt;
import com.watabou.pixeldungeon.items.wands.WandOfFlock;
import com.watabou.pixeldungeon.items.wands.WandOfLightning;
import com.watabou.pixeldungeon.items.wands.WandOfMagicMissile;
import com.watabou.pixeldungeon.items.wands.WandOfPoison;
import com.watabou.pixeldungeon.items.wands.WandOfRegrowth;
import com.watabou.pixeldungeon.items.wands.WandOfSlowness;
import com.watabou.pixeldungeon.items.wands.WandOfTelekinesis;
import com.watabou.pixeldungeon.items.wands.WandOfTeleportation;
import com.watabou.pixeldungeon.items.weapon.melee.BattleAxe;
import com.watabou.pixeldungeon.items.weapon.melee.CompoundBow;
import com.watabou.pixeldungeon.items.weapon.melee.Dagger;
import com.watabou.pixeldungeon.items.weapon.melee.Glaive;
import com.watabou.pixeldungeon.items.weapon.melee.Knuckles;
import com.watabou.pixeldungeon.items.weapon.melee.Kusarigama;
import com.watabou.pixeldungeon.items.weapon.melee.Longsword;
import com.watabou.pixeldungeon.items.weapon.melee.Mace;
import com.watabou.pixeldungeon.items.weapon.melee.Quarterstaff;
import com.watabou.pixeldungeon.items.weapon.melee.RubyBow;
import com.watabou.pixeldungeon.items.weapon.melee.ShortSword;
import com.watabou.pixeldungeon.items.weapon.melee.Spear;
import com.watabou.pixeldungeon.items.weapon.melee.Sword;
import com.watabou.pixeldungeon.items.weapon.melee.WarHammer;
import com.watabou.pixeldungeon.items.weapon.melee.WoodenBow;
import com.watabou.pixeldungeon.items.weapon.missiles.Boomerang;
import com.watabou.pixeldungeon.items.weapon.missiles.CommonArrow;
import com.watabou.pixeldungeon.items.weapon.missiles.CurareDart;
import com.watabou.pixeldungeon.items.weapon.missiles.Dart;
import com.watabou.pixeldungeon.items.weapon.missiles.FireArrow;
import com.watabou.pixeldungeon.items.weapon.missiles.FrostArrow;
import com.watabou.pixeldungeon.items.weapon.missiles.IncendiaryDart;
import com.watabou.pixeldungeon.items.weapon.missiles.Javelin;
import com.watabou.pixeldungeon.items.weapon.missiles.ParalysisArrow;
import com.watabou.pixeldungeon.items.weapon.missiles.PoisonArrow;
import com.watabou.pixeldungeon.items.weapon.missiles.Shuriken;
import com.watabou.pixeldungeon.items.weapon.missiles.Tamahawk;
import com.watabou.pixeldungeon.plants.Dreamweed;
import com.watabou.pixeldungeon.plants.Earthroot;
import com.watabou.pixeldungeon.plants.Fadeleaf;
import com.watabou.pixeldungeon.plants.Firebloom;
import com.watabou.pixeldungeon.plants.Icecap;
import com.watabou.pixeldungeon.plants.Sorrowmoss;
import com.watabou.pixeldungeon.plants.Sungrass;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class SpellFactory {

	static private Map<String, Class<? extends Spell>> mSpellsList = new HashMap<>();
	static private Map<Class<? extends Spell>,String>  mNamesList = new HashMap<>();
	static {
		initSpellsMap();
	}

	private static void registerSpellClass(Class<? extends Spell> spellClass) {
		mSpellsList.put(spellClass.getSimpleName(), spellClass);
		mNamesList.put(spellClass,spellClass.getSimpleName());
	}

	private static void initSpellsMap() {
		registerSpellClass(SummonDeathiling.class);
	}

	public static boolean isValidSpellClass(String spellClass) {
		return mSpellsList.containsKey(spellClass);
	}

	public static Spell spellByName(String selectedSpellClass) {
		try {
			return spellsClassByName(selectedSpellClass).newInstance();
		} catch (InstantiationException e) {
			throw new TrackedRuntimeException("", e);
		} catch (IllegalAccessException e) {
			throw new TrackedRuntimeException("", e);
		}
	}

	private static Class<? extends Spell> spellsClassByName(String selectedSpellClass) {
		Class<? extends Spell> spellClass = mSpellsList.get(selectedSpellClass);
		if (spellClass != null) {
			return spellClass;
		} else {
			Game.toast("Unknown spell: [%s], using 'Summon Wisp' instead", selectedSpellClass);
			return SummonDeathiling.class;
		}
	}

	public static String spellNameByClass(Class<? extends Spell> clazz) {
		String ret = mNamesList.get(clazz);
		if(ret==null) {
			EventCollector.logEvent("Unregistered entry",clazz.getCanonicalName());
			ret = "SummonDeathling";
		}
		return ret;
	}

//	public static Item createSpellFromDesc(JSONObject spellDesc) throws IllegalAccessException, InstantiationException, JSONException {
//		return spell;
//	}
}
