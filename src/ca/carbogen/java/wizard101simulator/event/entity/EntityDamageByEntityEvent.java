package ca.carbogen.java.wizard101simulator.event.entity;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.event.Event;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class EntityDamageByEntityEvent extends Event
{
	private Entity damager;
	private Entity damagee;
	private Spell spell;
	private int damage;

	public EntityDamageByEntityEvent(Entity damagee, Entity damager, Spell spell, int damage)
	{
		this.damager = damager;
		this.damagee = damagee;
		this.damage = damage;
		this.spell = spell;
	}

	@Override
	public void happen()
	{

	}

	public Entity getDamager()
	{
		return damager;
	}

	public Entity getDamagee()
	{
		return damagee;
	}

	public Spell getSpell()
	{
		return spell;
	}

	public int getDamage()
	{
		return damage;
	}

	public void setDamage(int damage)
	{
		this.damage = damage;
	}
}
