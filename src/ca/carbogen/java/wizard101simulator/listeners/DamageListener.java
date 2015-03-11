package ca.carbogen.java.wizard101simulator.listeners;

import ca.carbogen.java.wizard101simulator.School;
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
		double damagerDamage = event.getDamager().getDamages().get(event.getSpell().getSchool());
		damagerDamage += event.getDamager().getDamages().get(School.UNIVERSAL);
		event.setDamage(event.getDamage() + (int) (event.getDamage() * damagerDamage));

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

		double damageeResist = event.getDamagee().getResistances().get(event.getSpell().getSchool());
		damageeResist += event.getDamagee().getResistances().get(School.UNIVERSAL);

		if(damageeResist > 1.0)
			damageeResist = 1.0;

		event.setDamage(event.getDamage() - (int) (event.getDamage() * damageeResist));

		if(EntityAI.getEntityAI(event.getDamagee()) != null)
			EntityAI.getEntityAI(event.getDamagee()).increaseThreat(event.getDamager(), event.getDamage());

		System.out.println(event.getDamager().getName() + " hit "
				+ event.getDamagee().getName() + " with "
				+ event.getSpell().getName() + " for "
				+ event.getDamage() + " health.");
	}
}
