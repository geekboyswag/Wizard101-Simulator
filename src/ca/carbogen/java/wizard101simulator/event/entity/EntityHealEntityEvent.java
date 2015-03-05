package ca.carbogen.java.wizard101simulator.event.entity;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.event.Event;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/25/2015.
 */
public class EntityHealEntityEvent extends Event
{
	private Entity healer;
	private Entity healee;
	private Spell spell;
	private int health;

	public EntityHealEntityEvent(Entity healee, Entity healer, Spell spell, int health)
	{
		this.healer = healer;
		this.healee = healee;
		this.health = health;
		this.spell = spell;
	}

	@Override
	public void happen()
	{

	}

	public Entity getHealer()
	{
		return healer;
	}

	public Entity getHealee()
	{
		return healee;
	}

	public Spell getSpell()
	{
		return spell;
	}

	public int getHealth()
	{
		return health;
	}

	public void setHealth(int health)
	{
		this.health = health;
	}
}
