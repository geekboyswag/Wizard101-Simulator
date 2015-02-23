package ca.carbogen.java.wizard101simulator.listeners;

import ca.carbogen.java.wizard101simulator.event.EventHandler;
import ca.carbogen.java.wizard101simulator.event.Listener;
import ca.carbogen.java.wizard101simulator.event.entity.EntityWardEntityEvent;

/**
 * Created by Carbogen on 2/23/2015.
 */
public class WardListener implements Listener
{
	@EventHandler
	public void onEntityWardEntity(EntityWardEntityEvent e)
	{
		System.out.println(e.getCaster().getName() + " cast a " +
				e.getWard().getValueString() + " " +
				e.getWard().getName() + " on " +
				e.getCastee().getName() + ".");
	}
}
