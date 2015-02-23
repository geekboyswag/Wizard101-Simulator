package ca.carbogen.java.wizard101simulator.event.entity;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.event.Event;
import ca.carbogen.java.wizard101simulator.spells.ward.Ward;

/**
 * Created by Carbogen on 2/23/2015.
 */
public class EntityWardEntityEvent extends Event
{
	private Entity castee;
	private Entity caster;
	private Ward ward;

	public EntityWardEntityEvent(Entity caster, Entity castee, Ward ward)
	{
		this.caster = caster;
		this.castee = castee;
		this.ward = ward;
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

	public Ward getWard()
	{
		return this.ward;
	}
}
