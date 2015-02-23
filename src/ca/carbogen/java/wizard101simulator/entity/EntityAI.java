package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.Methods;
import ca.carbogen.java.wizard101simulator.spells.Spell;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class EntityAI
{
	private Entity entity;
	private ConcurrentHashMap<Entity, Integer> threat = new ConcurrentHashMap<Entity, Integer>();

	public EntityAI(Entity e)
	{
		this.entity = e;
	}

	public Spell selectCard()
	{
		return entity.getSpellList().get(Methods.generateRandomInteger(entity.getSpellList().size()));
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

	public void updateThreats()
	{
		ArrayList<Entity> keys = new ArrayList<Entity>(threat.keySet());
		for(int i = 0; i < keys.size(); i++)
			if(keys.get(i).isDead())
				threat.remove(keys.get(i));
	}

	public void increaseThreat(Entity e, int amount)
	{
		threat.put(e, amount);
	}
}
