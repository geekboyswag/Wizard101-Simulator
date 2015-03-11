package ca.carbogen.java.wizard101simulator.spells.damage.ice;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 3/11/2015.
 */
public class Spell_SnowSerpent extends DamageSpell
{
	@Override
	public int[] getDamage()
	{
		return new int[] { 155, 165, 175, 185, 195 };
	}

	@Override
	public School getSchool()
	{
		return School.ICE;
	}

	@Override
	public String getName()
	{
		return "Snow Serpent";
	}

	@Override
	public int getCost()
	{
		return 2;
	}
}
