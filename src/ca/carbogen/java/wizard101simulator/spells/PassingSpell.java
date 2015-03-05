package ca.carbogen.java.wizard101simulator.spells;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.entity.Entity;

/**
 * Created by Carbogen on 2/26/2015.
 */
public class PassingSpell implements Spell
{

	@Override
	public School getSchool()
	{
		return School.UNIVERSAL;
	}

	@Override
	public String getName()
	{
		return "Pass";
	}

	@Override
	public int getCost()
	{
		return 0;
	}

	@Override
	public void cast(Entity caster, Entity castee)
	{
		System.out.println(caster.getName() + " has passed their turn.");
	}
}
