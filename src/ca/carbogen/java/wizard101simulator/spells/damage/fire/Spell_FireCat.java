package ca.carbogen.java.wizard101simulator.spells.damage.fire;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Spell_FireCat extends DamageSpell
{
	@Override
	public String getName()
	{
		return "Fire Cat";
	}

	@Override
	public School getSchool()
	{
		return School.FIRE;
	}

	@Override
	public int[] getDamage()
	{
		return new int[] {80, 100, 120};
	}

	@Override
	public int getCost()
	{
		return 1;
	}
}
