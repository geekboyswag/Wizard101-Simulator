package ca.carbogen.java.wizard101simulator.spells.charm.negative.balance;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.charm.Charm;

/**
 * Created by Carbogen on 2/20/2015.
 */
public class Spell_Weakness extends Charm
{
	@Override
	public double getValue()
	{
		return 1 - 0.25;
	}

	@Override
	public String getValueString()
	{
		return "-25%";
	}

	@Override
	public School getSchool()
	{
		return School.UNIVERSAL;
	}

	@Override
	public String getName()
	{
		return "Weakness";
	}

	@Override
	public int getCost()
	{
		return 0;
	}
}
