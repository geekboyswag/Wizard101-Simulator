package ca.carbogen.java.wizard101simulator.spells.damage.storm;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Spell_ThunderSnake extends DamageSpell
{
	@Override
	public String getName()
	{
		return "Thunder Snake";
	}

	@Override
	public School getSchool()
	{
		return School.STORM;
	}

	@Override
	public int[] getDamage()
	{
		return new int[] { 105, 125, 135, 145 };
	}

	@Override
	public int getCost()
	{
		return 1;
	}
}
