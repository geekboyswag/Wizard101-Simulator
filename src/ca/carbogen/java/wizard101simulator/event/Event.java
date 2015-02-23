package ca.carbogen.java.wizard101simulator.event;

public abstract class Event
{
	private boolean isCancelled = false;

	public void fire()
	{
		EventManager.callEvent(this);

		happen();
	}

	public boolean isCancelled()
	{
		return this.isCancelled;
	}

	public void setCancelled(boolean value)
	{
		this.isCancelled = value;
	}

	public abstract void happen();
}
