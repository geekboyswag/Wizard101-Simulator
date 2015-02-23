package ca.carbogen.java.wizard101simulator.event;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class EventManager 
{
	public static List<Listener> listeners = new ArrayList<Listener>();
	
	public static void callEvent(Event event)
	{
		for(Listener l : listeners)
		{
			for(Method m : l.getClass().getMethods())
			{
				if(m.getAnnotation(EventHandler.class) instanceof EventHandler)
				{
					try
					{
						m.invoke(l, event);
					}
					catch(Exception e) 
					{
						
					} 
				}
			}
		}
	}
}
