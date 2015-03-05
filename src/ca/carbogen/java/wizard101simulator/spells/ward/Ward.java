package ca.carbogen.java.wizard101simulator.spells.ward;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/23/2015.
 */
public abstract class Ward implements Spell
{
	public abstract double getValue();
	public abstract String getValueString();

	public int activate(int damage)
	{
		return (int) (damage * getValue());
	}

	@Override
	public final void cast(Entity caster, Entity castee)
	{
		castee.addWard(this, caster);
		caster.removePips(getCost());
	}
}
