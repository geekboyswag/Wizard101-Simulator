package ca.carbogen.java.wizard101simulator.spells.regeneration;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/23/2015.
 */
public abstract class RegenerationSpell implements Spell
{
	public abstract int healValue();

	@Override
	public final void cast(Entity caster, Entity castee)
	{
		castee.heal(healValue(), this, caster);
		caster.removePips(getCost());
	}
}
