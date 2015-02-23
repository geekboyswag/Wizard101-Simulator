package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.damage.fire.Spell_FireCat;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Entity_LostSoul extends Entity
{
	public Entity_LostSoul()
	{
		super("Lost Soul");
	}

	public int getMaxHealth()
	{
		return 55;
	}

	public School getSchool()
	{
		return School.DEATH;
	}

	public List<Spell> getSpellList()
	{
		List<Spell> spells = new ArrayList<Spell>();
		spells.add(new Spell_FireCat());

		return spells;
	}
}
