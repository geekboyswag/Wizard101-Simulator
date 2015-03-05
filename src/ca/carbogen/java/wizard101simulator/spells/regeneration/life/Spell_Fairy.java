package ca.carbogen.java.wizard101simulator.spells.regeneration.life;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.regeneration.RegenerationSpell;

/**
 * Created by Carbogen on 2/25/2015.
 */
public class Spell_Fairy extends RegenerationSpell
{

	@Override
	public int healValue()
	{
		return 420;
	}

	@Override
	public School getSchool()
	{
		return School.LIFE;
	}

	@Override
	public String getName()
	{
		return "Fairy";
	}

	@Override
	public int getCost()
	{
		return 2;
	}
}
