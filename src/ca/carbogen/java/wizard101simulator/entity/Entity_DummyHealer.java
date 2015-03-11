package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.regeneration.life.Spell_MinorBlessing;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 2/25/2015.
 */
public class Entity_DummyHealer extends Entity
{
	public Entity_DummyHealer(String name)
	{
		super(name.replaceAll("\\s", ""));
	}

	public Entity_DummyHealer()
	{
		super("DummyHealer");
	}

	@Override
	public List<Spell> getSpellList()
	{
		List<Spell> spells = new ArrayList<Spell>();

		spells.add(new Spell_MinorBlessing());

		return spells;
	}

	@Override
	public int getMaxHealth()
	{
		return 70;
	}

	@Override
	public void setupResists()
	{
		getResistances().put(School.LIFE, 0.4);
	}

	@Override
	public School getSchool()
	{
		return School.LIFE;
	}
}
