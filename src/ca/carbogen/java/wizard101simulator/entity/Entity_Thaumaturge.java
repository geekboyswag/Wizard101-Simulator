package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.damage.ice.Spell_FrostBeetle;
import ca.carbogen.java.wizard101simulator.spells.damage.ice.Spell_SnowSerpent;
import ca.carbogen.java.wizard101simulator.spells.ward.positive.ice.Spell_TowerShield;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 3/11/2015.
 */
public class Entity_Thaumaturge extends Entity
{
	public Entity_Thaumaturge(String name)
	{
		super(name);
	}

	public Entity_Thaumaturge()
	{
		super("Thaumaturge");
	}

	@Override
	public List<Spell> getSpellList()
	{
		List<Spell> spells = new ArrayList<Spell>();

		spells.add(new Spell_TowerShield());
		spells.add(new Spell_FrostBeetle());
		spells.add(new Spell_SnowSerpent());

		return spells;
	}

	@Override
	public void setupResists()
	{
		getResistances().put(School.STORM, 0.5);
		getResistances().put(School.FIRE, 0.54);
		getResistances().put(School.ICE, 0.14);
		getResistances().put(School.UNIVERSAL, 0.5);
	}

	@Override
	public int getMaxHealth()
	{
		return 600;
	}

	@Override
	public School getSchool()
	{
		return null;
	}
}
