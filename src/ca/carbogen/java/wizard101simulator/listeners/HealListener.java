package ca.carbogen.java.wizard101simulator.listeners;

import ca.carbogen.java.wizard101simulator.event.EventHandler;
import ca.carbogen.java.wizard101simulator.event.Listener;
import ca.carbogen.java.wizard101simulator.event.entity.EntityHealEntityEvent;

/**
 * Created by Carbogen on 2/25/2015.
 */
public class HealListener implements Listener
{
	@EventHandler
	public void onEntityHealEntity(EntityHealEntityEvent e)
	{
		System.out.println(e.getHealer().getName() + " healed "
				+ e.getHealee().getName() + " with "
				+ e.getSpell().getName() + " for "
				+ e.getHealth() + ".");
	}
}
