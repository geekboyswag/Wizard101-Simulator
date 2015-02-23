package ca.carbogen.java.wizard101simulator;

/**
 * Created by Carbogen on 2/18/2015.
 */
public enum School
{
	NULL, UNIVERSAL, SHADOW, BALANCE,

	// ELEMENTAL SCHOOLS
	STORM, ICE, FIRE,

	// SPIRIT SCHOOLS
	DEATH, MYTH, LIFE,

	// ASTRAL SCHOOLS
	STAR, MOON, SUN;

	private enum Elemental { STORM, ICE, FIRE }

	private enum Spirit { DEATH, MYTH, LIFE }

	private enum Astral { STAR, MOON, SUN }

	public School getWeakness()
	{
		switch(this)
		{
			case STORM:
				return MYTH;

			case ICE:
				return FIRE;

			case FIRE:
				return ICE;

			case DEATH:
				return LIFE;

			case MYTH:
				return STORM;

			case LIFE:
				return DEATH;
		}

		return NULL;
	}

	public boolean hasWeakness(School school)
	{
		if(school == getWeakness())
			return true;

		if(this == BALANCE)
			if(Spirit.valueOf(this.name()) != null)
				return true;

		if(this == MOON)
		{
			if(school == MYTH
					|| school == ICE
					|| school == DEATH)
				return true;

			return false;
		}

		return false;
	}
}
