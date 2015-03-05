package ca.carbogen.java.wizard101simulator.spells.damage;

import ca.carbogen.java.wizard101simulator.Methods;
import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.spells.Spell;

/**
 * Created by Carbogen on 2/19/2015.
 */
public abstract class DamageSpell implements Spell
{
	public abstract int[] getDamage();

	@Override
	public final void cast(Entity caster, Entity castee)
	{
		castee.damage(getDamage()[Methods.generateRandomInteger(getDamage().length)], this, caster);
		caster.removePips(getCost());
	}
}
