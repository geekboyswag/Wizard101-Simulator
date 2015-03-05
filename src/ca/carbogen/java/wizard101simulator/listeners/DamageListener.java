package ca.carbogen.java.wizard101simulator.listeners;

import ca.carbogen.java.wizard101simulator.entity.EntityAI;
import ca.carbogen.java.wizard101simulator.event.EventHandler;
import ca.carbogen.java.wizard101simulator.event.Listener;
import ca.carbogen.java.wizard101simulator.event.entity.EntityDamageByEntityEvent;
import ca.carbogen.java.wizard101simulator.spells.charm.Charm;
import ca.carbogen.java.wizard101simulator.spells.ward.Ward;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class DamageListener implements Listener
{
	@EventHandler
	public void onEntityDamageByEntity(EntityDamageByEntityEvent event)
	{
		for(Charm c : event.getDamager().getCharms(event.getSpell()))
		{
			event.setDamage(c.activate(event.getDamage()));
			event.getDamager().removeCharm(c.getClass());
		}

		for (Ward w : event.getDamagee().getWards(event.getSpell()))
		{
			event.setDamage(w.activate(event.getDamage()));
			event.getDamagee().removeWard(w.getClass());
		}

		if(EntityAI.getEntityAI(event.getDamagee()) != null)
			EntityAI.getEntityAI(event.getDamagee()).increaseThreat(event.getDamager(), event.getDamage());

		System.out.println(event.getDamager().getName() + " hit "
				+ event.getDamagee().getName() + " with "
				+ event.getSpell().getName() + " for "
				+ event.getDamage() + " health.");
	}
}
