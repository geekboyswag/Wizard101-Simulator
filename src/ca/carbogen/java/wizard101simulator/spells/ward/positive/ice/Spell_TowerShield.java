package ca.carbogen.java.wizard101simulator.spells.ward.positive.ice;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.ward.Ward;

/**
 * Created by Carbogen on 2/23/2015.
 */
public class Spell_TowerShield extends Ward
{
	@Override
	public double getValue()
	{
		return 1 - 0.50;
	}

	@Override
	public String getValueString()
	{
		return "-50%";
	}

	@Override
	public School getSchool()
	{
		return School.UNIVERSAL;
	}

	@Override
	public String getName()
	{
		return "Tower Shield";
	}

	@Override
	public int getCost()
	{
		return 0;
	}
}
