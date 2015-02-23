package ca.carbogen.java.wizard101simulator.spells.damage.death;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.damage.DamageSpell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Spell_DarkSprite extends DamageSpell
{
	@Override
	public String getName()
	{
		return "Dark Sprite";
	}

	@Override
	public School getSchool()
	{
		return School.DEATH;
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
