package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.Methods;
import ca.carbogen.java.wizard101simulator.spells.PassingSpell;
import ca.carbogen.java.wizard101simulator.spells.Spell;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class EntityAI
{
	public static ConcurrentHashMap<Entity, EntityAI> instances = new ConcurrentHashMap<Entity, EntityAI>();

	private Entity entity;
	private ConcurrentHashMap<Entity, Integer> threat = new ConcurrentHashMap<Entity, Integer>();

	public EntityAI(Entity e)
	{
		this.entity = e;
		instances.put(e, this);
	}

	public Spell selectCard()
	{
		Spell spell = null;

		for(int i = 0; i < 2; i++)
		{
			spell = entity.getSpellList().get(Methods.generateRandomInteger(entity.getSpellList().size()));

			if(spell.getCost() <= entity.countPips())
				return spell;
		}

		return new PassingSpell();
	}

	public Entity getTarget()
	{
		Entity target = null;
		int highestThreat = 0;

		for(Entity e : threat.keySet())
		{
			if(threat.get(e) >= highestThreat)
			{
				highestThreat = threat.get(e);
				target = e;
			}
		}

		return target;
	}

	public Entity getVulnerableAlly(Entity[] allies)
	{
		Entity vulnerable = null;
		int lowestHealth = Integer.MAX_VALUE;

		for(Entity e : allies)
		{
			if(e != null && !e.isDead() && e.getHealth() < lowestHealth)
			{
				lowestHealth = e.getHealth();
				vulnerable = e;
			}
		}

		return vulnerable;
	}

	public int getThreat(Entity e)
	{
		return threat.get(e);
	}

	public void updateThreats()
	{
		ArrayList<Entity> keys = new ArrayList<Entity>(threat.keySet());
		for(int i = 0; i < keys.size(); i++)
			if(keys.get(i).isDead())
				threat.remove(keys.get(i));
	}

	public void increaseThreat(Entity e, int amount)
	{
		if(threat.containsKey(e))
			threat.put(e, threat.get(e) + amount);
		else
			threat.put(e, amount);
	}

	public static EntityAI getEntityAI(Entity e)
	{
		if(e == null)
			return null;

		if(instances.containsKey(e))
			return instances.get(e);
		else
			return new EntityAI(e);
	}
}
