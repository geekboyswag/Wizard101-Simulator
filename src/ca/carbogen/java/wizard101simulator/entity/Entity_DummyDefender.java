package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.charm.negative.balance.Spell_Weakness;
import ca.carbogen.java.wizard101simulator.spells.ward.positive.ice.Spell_TowerShield;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 2/25/2015.
 */
public class Entity_DummyDefender extends Entity
{
	public Entity_DummyDefender(String name)
	{
		super(name.replaceAll("\\s", ""));
	}

	public Entity_DummyDefender()
	{
		super("DummyDefender");
	}

	@Override
	public List<Spell> getSpellList()
	{
		List<Spell> spells = new ArrayList<Spell>();

		spells.add(new Spell_Weakness());
		spells.add(new Spell_TowerShield());
		return spells;
	}

	@Override
	public int getMaxHealth()
	{
		return 200;
	}

	@Override
	public School getSchool()
	{
		return School.ICE;
	}
}
