package ca.carbogen.java.wizard101simulator.listeners;

import ca.carbogen.java.wizard101simulator.event.EventHandler;
import ca.carbogen.java.wizard101simulator.event.Listener;
import ca.carbogen.java.wizard101simulator.event.entity.EntityCharmEntityEvent;

/**
 * Created by Carbogen on 2/20/2015.
 */
public class CharmListener implements Listener
{
	@EventHandler
	public void onEntityCharmEntity(EntityCharmEntityEvent e)
	{
		System.out.println(e.getCaster().getName() + " cast a " +
				e.getCharm().getValueString() + " " +
				e.getCharm().getName() + " on " +
				e.getCastee().getName() + ".");
	}
}
