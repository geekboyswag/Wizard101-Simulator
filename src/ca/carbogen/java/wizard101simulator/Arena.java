package ca.carbogen.java.wizard101simulator;

import ca.carbogen.java.wizard101simulator.entity.Entity;
import ca.carbogen.java.wizard101simulator.entity.EntityAI;
import ca.carbogen.java.wizard101simulator.spells.Spell;

import java.util.Arrays;

/**
 * Created by Carbogen on 2/19/2015.
 */
public class Arena
{
	private Entity[] side1 = new Entity[4];
	private Entity[] side2 = new Entity[4];
	public static int winner = 0;

	public Arena(Entity[] side1, Entity[] side2)
	{
		this.side1 = side1.clone();

		System.out.println(Arrays.asList(side1));

		this.side2 = side2.clone();
		System.out.println(Arrays.asList(side2));

		System.out.println("\nSTART!\n");
	}

	public void runRound()
	{
		System.out.println("\n");
		System.out.println(Arrays.asList(side1));
		System.out.println(Arrays.asList(side2));

		if(winner != 0)
			return;

		for(Entity e : side1)
		{
			if(e == null || e.isDead())
			{
				continue;
			}

			if(Methods.getEntityAI(e) != null)
			{
				EntityAI ai = Methods.getEntityAI(e);

				ai.updateThreats();

				Spell spell = ai.selectCard();

				if(Methods.isPositive(spell))
				{
					spell.cast(e, e);

					break;
				}

				if(ai.getTarget() != null)
					spell.cast(e, ai.getTarget());

				else
				{
					if(side2[0] != null && !side2[0].isDead())
						spell.cast(e, side2[0]);
					else if(side2[1] != null && !side2[1].isDead())
						spell.cast(e, side2[1]);
					else if(side2[2] != null && !side2[2].isDead())
						spell.cast(e, side2[2]);
					else if(side2[3] != null && !side2[3].isDead())
						spell.cast(e, side2[3]);
					else
					{
						System.out.println("SideA wins!");
						winner = 1;
						return;
					}
				}
			}
		}

		for(Entity e : side2)
		{
			if(e == null || e.isDead())
			{
				continue;
			}

			if(Methods.getEntityAI(e) != null)
			{
				EntityAI ai = Methods.getEntityAI(e);

				ai.updateThreats();

				Spell spell = ai.selectCard();

				if(Methods.isPositive(spell))
				{
					spell.cast(e, e);

					break;
				}

				if(ai.getTarget() != null)
					spell.cast(e, ai.getTarget());

				else
				{
					if(side1[0] != null && !side1[0].isDead())
						spell.cast(e, side1[0]);
					else if(side1[1] != null && !side1[1].isDead())
						spell.cast(e, side1[1]);
					else if(side1[2] != null && !side1[2].isDead())
						spell.cast(e, side1[2]);
					else if(side1[3] != null && !side1[3].isDead())
						spell.cast(e, side1[3]);
					else
					{
						System.out.println("SideB wins!");
						winner = 2;
						return;
					}
				}
			}
		}
	}
}
