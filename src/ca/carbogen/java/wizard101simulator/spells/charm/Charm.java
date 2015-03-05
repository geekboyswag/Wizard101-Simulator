package ca.carbogen.java.wizard101simulator.spells.charm;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/20/2015.
 */
public abstract class Charm implements Spell
{
	@Override
	public final void cast(Entity caster, Entity castee)
	{
		castee.addCharm(this, caster);
		caster.removePips(getCost());
	}

	public abstract double getValue();

	public abstract String getValueString();

	public int activate(int damage)
	{
		return (int) (damage * getValue());
	}
}
