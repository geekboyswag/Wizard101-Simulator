package ca.carbogen.java.wizard101simulator;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.entity.Entity_Dummy;
import ca.carbogen.java.wizard101simulator.event.EventManager;
import ca.carbogen.java.wizard101simulator.listeners.CharmListener;
import ca.carbogen.java.wizard101simulator.listeners.DamageListener;
import ca.carbogen.java.wizard101simulator.listeners.WardListener;

/**
 * Created by Carbogen on 2/18/2015.
 */
public class Main
{
	public static void main(String[] args)
	{
		System.out.println("Starting game.");
		EventManager.listeners.add(new DamageListener());
		EventManager.listeners.add(new CharmListener());
		EventManager.listeners.add(new WardListener());

		Entity[] side1 = new Entity[] {new Entity_Dummy("DummyA1"), new Entity_Dummy("DummyA2"), null, null};
		Entity[] side2 = new Entity[] {new Entity_Dummy("DummyB1"), new Entity_Dummy("DummyB2"), null, null};

		Arena arena = new Arena(side1, side2);
		while(arena.winner == 0)
			arena.runRound();
	}
}
