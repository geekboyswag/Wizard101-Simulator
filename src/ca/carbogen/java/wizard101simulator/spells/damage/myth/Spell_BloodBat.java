package ca.carbogen.java.wizard101simulator.spells.damage.myth;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Spell_BloodBat extends DamageSpell
{
	@Override
	public String getName()
	{
		return "Blood Bat";
	}

	@Override
	public School getSchool()
	{
		return School.MYTH;
	}

	@Override
	public int[] getDamage()
	{
		return new int[] { 70, 80, 100, 110 };
	}

	@Override
	public int getCost()
	{
		return 1;
	}
}
