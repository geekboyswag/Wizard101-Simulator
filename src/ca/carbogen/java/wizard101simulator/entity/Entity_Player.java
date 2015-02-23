package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.Methods;
import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.spells.Spell;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Entity_Player extends Entity
{
	private School school;
	private List<Spell> spellList = new ArrayList<Spell>();
	private int level;

	public Entity_Player(String name, School school)
	{
		super(name);
		this.school = school;
		this.level = 1;
		Spell firstSpell = Methods.getNewSpell(this);
		if(firstSpell != null)
			getSpellList().add(firstSpell);
	}

	public int getLevel()
	{
		return level;
	}

	public int getMaxHealth()
	{
		int mod = 100;

		switch(getSchool())
		{
			case BALANCE:
				mod = 450;
				break;
			case STORM:
				mod = 350;
				break;
			case ICE:
				mod = 500;
				break;
			case FIRE:
				mod = 400;
				break;
			case DEATH:
				mod = 420;
				break;
			case MYTH:
				mod = 400;
				break;
			case LIFE:
				mod = 480;
				break;
		}

		return (getLevel() * (mod/15)) + mod;
	}

	public List<Spell> getSpellList()
	{
		return this.spellList;
	}

	public School getSchool()
	{
		return this.school;
	}
}
