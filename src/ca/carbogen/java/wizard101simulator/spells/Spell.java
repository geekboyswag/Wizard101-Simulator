package ca.carbogen.java.wizard101simulator.spells;

import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.entity.Entity;

/**
 * Created by Carbogen on 2/19/2015.
 */
public interface Spell
{
	public School getSchool();
	public String getName();
	public int getCost();
	public void cast(Entity caster, Entity castee);
}
