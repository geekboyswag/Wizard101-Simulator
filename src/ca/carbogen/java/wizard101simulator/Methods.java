package ca.carbogen.java.wizard101simulator;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.entity.EntityAI;
import ca.carbogen.java.wizard101simulator.entity.Entity_Player;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.charm.Charm;
import ca.carbogen.java.wizard101simulator.spells.damage.balance.Spell_Scarab;
import ca.carbogen.java.wizard101simulator.spells.damage.death.Spell_DarkSprite;
import ca.carbogen.java.wizard101simulator.spells.damage.fire.Spell_FireCat;
import ca.carbogen.java.wizard101simulator.spells.damage.ice.Spell_FrostBeetle;
import ca.carbogen.java.wizard101simulator.spells.damage.life.Spell_Imp;
import ca.carbogen.java.wizard101simulator.spells.damage.myth.Spell_BloodBat;
import ca.carbogen.java.wizard101simulator.spells.damage.storm.Spell_ThunderSnake;
import ca.carbogen.java.wizard101simulator.spells.regeneration.RegenerationSpell;
import ca.carbogen.java.wizard101simulator.spells.ward.Ward;

import java.util.Random;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Methods
{
	@Deprecated
	public static EntityAI getEntityAI(Entity e)
	{
		if(!(e instanceof Entity_Player))
		{
			return EntityAI.getEntityAI(e);
		}

		return null;
	}

	public static boolean isPositive(Spell spell)
	{
		if((spell instanceof Charm && ((Charm) spell).getValue() >= 1)
				|| spell instanceof Ward && ((Ward) spell).getValue() < 1
				|| spell instanceof RegenerationSpell)
			return true;

		return false;
	}

	public static Spell getNewSpell(Entity_Player player)
	{
		if(player.getLevel() == 1)
		{
			switch(player.getSchool())
			{
				case BALANCE:
					return new Spell_Scarab();
				case STORM:
					return new Spell_ThunderSnake();
				case ICE:
					return new Spell_FrostBeetle();
				case FIRE:
					return new Spell_FireCat();
				case DEATH:
					return new Spell_DarkSprite();
				case MYTH:
					return new Spell_BloodBat();
				case LIFE:
					return new Spell_Imp();
			}
		}



		return null;
	}

	public static int generateRandomInteger(int to)
	{
		return generateRandomInteger(0, to);
	}

	public static int generateRandomInteger(int from, int to)
	{
		return new Random().nextInt(to - from) + from;
	}
}
