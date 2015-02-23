package ca.carbogen.java.wizard101simulator;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Pip
{
	private int value;

	public Pip(boolean power)
	{
		this.value = (power) ? 2 : 1;
	}

	public int getValue()
	{
		return this.value;
	}

	public boolean isPowerPip()
	{
		return (this.value > 1) ? true : false;
	}
}
