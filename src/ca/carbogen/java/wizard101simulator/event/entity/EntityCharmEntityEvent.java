package ca.carbogen.java.wizard101simulator.event.entity;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.event.Event;
import ca.carbogen.java.wizard101simulator.spells.charm.Charm;

/**
 * Created by Carbogen on 2/20/2015.
 */
public class EntityCharmEntityEvent extends Event
{
	private Entity castee;
	private Entity caster;
	private Charm charm;

	public EntityCharmEntityEvent(Entity caster, Entity castee, Charm charm)
	{
		this.caster = caster;
		this.castee = castee;
		this.charm = charm;
	}

	public Entity getCaster()
	{
		return this.caster;
	}

	public Entity getCastee()
	{
		return this.castee;
	}

	@Override
	public void happen()
	{

	}

	public Charm getCharm()
	{
		return this.charm;
	}
}
