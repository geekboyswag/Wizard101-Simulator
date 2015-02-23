package ca.carbogen.java.wizard101simulator.spells.damage.life;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Spell_Imp extends DamageSpell
{
	@Override
	public String getName()
	{
		return "Imp";
	}

	@Override
	public School getSchool()
	{
		return School.LIFE;
	}

	@Override
	public int[] getDamage()
	{
		return new int[] { 65, 75, 85, 105 };
	}

	@Override
	public int getCost()
	{
		return 1;
	}
}
