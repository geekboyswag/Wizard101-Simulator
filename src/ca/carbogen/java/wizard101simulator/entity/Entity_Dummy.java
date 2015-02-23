package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.charm.negative.balance.Spell_Weakness;
import ca.carbogen.java.wizard101simulator.spells.damage.balance.Spell_Scarab;
import ca.carbogen.java.wizard101simulator.spells.damage.myth.Spell_BloodBat;
import ca.carbogen.java.wizard101simulator.spells.ward.positive.ice.Spell_TowerShield;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Entity_Dummy extends Entity
{

	public Entity_Dummy(String name)
	{
		super(name);
	}

	public Entity_Dummy()
	{
		super("Dummy");
	}

	@Override
	public List<Spell> getSpellList()
	{
		List<Spell> spells = new ArrayList<Spell>();

		spells.add(new Spell_Scarab());
		spells.add(new Spell_BloodBat());
		spells.add(new Spell_Weakness());
		spells.add(new Spell_TowerShield());

		return spells;
	}

	@Override
	public int getMaxHealth()
	{
		return 500;
	}

	@Override
	public School getSchool()
	{
		return School.BALANCE;
	}
}
