package ca.carbogen.java.wizard101simulator.entity;

import ca.carbogen.java.wizard101simulator.Methods;
import ca.carbogen.java.wizard101simulator.Pip;
import ca.carbogen.java.wizard101simulator.School;
import ca.carbogen.java.wizard101simulator.event.entity.EntityCharmEntityEvent;
import ca.carbogen.java.wizard101simulator.event.entity.EntityDamageByEntityEvent;
import ca.carbogen.java.wizard101simulator.event.entity.EntityHealEntityEvent;
import ca.carbogen.java.wizard101simulator.event.entity.EntityWardEntityEvent;
import ca.carbogen.java.wizard101simulator.spells.Spell;
import ca.carbogen.java.wizard101simulator.spells.charm.Charm;
import ca.carbogen.java.wizard101simulator.spells.ward.Ward;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Carbogen on 2/18/2015.
 */
public abstract class Entity
{
	private String name;
	private int currentHealth;
	private int maxPips = 7;
	private List<Pip> currentPips = new ArrayList<Pip>();
	private List<Charm> orbitingCharms = new ArrayList<Charm>();
	private List<Ward> orbitingWards = new ArrayList<Ward>();
	private HashMap<School, Double> resistance = new HashMap<School, Double>();
	private HashMap<School, Double> damage = new HashMap<School, Double>();

	public Entity(String name)
	{
		this.name = name;
		this.currentHealth = this.getMaxHealth();

		setupDefaultStats();
		setupDamages();
		setupResists();
	}

	public void setHealth(int value)
	{
		this.currentHealth = value;
	}

	public String getName()
	{
		return this.name;
	}

	public int getHealth()
	{
		return this.currentHealth;
	}

	public boolean isDead()
	{
		return getHealth() <= 0;
	}

	public void damage(int damage, Spell spell, Entity damager)
	{
		EntityDamageByEntityEvent e = new EntityDamageByEntityEvent(this, damager, spell, damage);
		e.fire();
		setHealth((getHealth() - e.getDamage() >= 0) ? getHealth() - e.getDamage() : 0);
	}

	public void heal(int health, Spell spell, Entity healer)
	{
		EntityHealEntityEvent e = new EntityHealEntityEvent(this, healer, spell, health);
		e.fire();
		setHealth((getHealth() + e.getHealth() <= getMaxHealth()) ? getHealth() + e.getHealth() : getMaxHealth());
	}

	public List<Pip> getPips()
	{
		return this.currentPips;
	}

	public void addPip()
	{
		if(isDead())
		{
			getPips().clear();
			return;
		}

		if(getPips().size() >= 7)
			return;

		if(Methods.generateRandomInteger(100) < 30)
			getPips().add(new Pip(true));

		else
			getPips().add(new Pip(false));
	}

	public void addPips(int amount)
	{
		for(int i = 0; i < amount; i++)
		{
			getPips().add(new Pip(false));
		}
	}

	public boolean onlyHasPowerPips()
	{
		for(Pip pip : getPips())
			if(!pip.isPowerPip())
				return false;

		return true;
	}

	public void removePips(int amount)
	{
		while(amount > 0)
		{
			if(onlyHasPowerPips())
			{
				amount *= 2;
			}

			for(int i = 0; i < getPips().size(); i++)
			{
				if(getPips().get(i).getValue() <= amount)
				{
					amount -= getPips().get(i).getValue();
					getPips().remove(i);
					break;
				}
			}
		}
	}

	public int countPips()
	{
		int count = 0;

		for(Pip pip : getPips())
			count += pip.getValue();

		return count;
	}

	public List<Ward> getWards() { return this.orbitingWards; }

	public void addWard(Ward ward, Entity caster)
	{
		EntityWardEntityEvent e = new EntityWardEntityEvent(caster, this, ward);
		e.fire();
		getWards().add(e.getWard());
	}

	public List<Ward> getWards(Spell spell)
	{
		List<Ward> wards = new ArrayList<Ward>();
		first: for(Ward w : getWards())
		{
			if(w.getSchool() == spell.getSchool()
					|| w.getSchool() == School.UNIVERSAL)
			{
				for(Ward exist : wards)
					if(exist.getName().equalsIgnoreCase(w.getName())
							&& exist.getValue() == w.getValue())
						continue first;

				wards.add(w);
			}
		}

		return wards;
	}

	public void removeWard(Class<? extends Ward> ward)
	{
		for(int i = 0; i < orbitingWards.size(); i++)
		{
			if(orbitingWards.get(i).getClass() == ward)
			{
				orbitingWards.remove(i);
				return;
			}
		}
	}

	public List<Charm> getCharms()
	{
		return this.orbitingCharms;
	}

	public void addCharm(Charm charm, Entity caster)
	{
		EntityCharmEntityEvent e = new EntityCharmEntityEvent(caster, this, charm);
		e.fire();
		getCharms().add(e.getCharm());
	}

	public List<Charm> getCharms(Spell spell)
	{
		List<Charm> charms = new ArrayList<Charm>();
		first: for(Charm c : getCharms())
		{
			if(c.getSchool() == spell.getSchool()
					|| c.getSchool() == School.UNIVERSAL)
			{
				for(Charm exist : charms)
					if(exist.getName().equalsIgnoreCase(c.getName())
							&& exist.getValue() == c.getValue())
						continue first;

				charms.add(c);
			}
		}

		return charms;
	}

	public void removeCharm(Class<? extends Charm> charm)
	{
		for(int i = 0; i < orbitingCharms.size(); i++)
		{
			if(orbitingCharms.get(i).getClass() == charm)
			{
				orbitingCharms.remove(i);
				return;
			}
		}
	}

	public String toString()
	{
		return this.getName() + "(" + ((this.getHealth() > 0) ? this.getHealth() : "dead") + "[" + countPips() + "])";
	}

	public void setupDefaultStats()
	{
		getDamages().put(School.BALANCE, 0.0);
		getDamages().put(School.DEATH, 0.0);
		getDamages().put(School.FIRE, 0.0);
		getDamages().put(School.ICE, 0.0);
		getDamages().put(School.LIFE, 0.0);
		getDamages().put(School.MYTH, 0.0);
		getDamages().put(School.STORM, 0.0);
		getDamages().put(School.UNIVERSAL, 0.0);

		getResistances().put(School.BALANCE, 0.0);
		getResistances().put(School.DEATH, 0.0);
		getResistances().put(School.FIRE, 0.0);
		getResistances().put(School.ICE, 0.0);
		getResistances().put(School.LIFE, 0.0);
		getResistances().put(School.MYTH, 0.0);
		getResistances().put(School.STORM, 0.0);
		getResistances().put(School.UNIVERSAL, 0.0);
	}

	public abstract List<Spell> getSpellList();
	public abstract int getMaxHealth();
	public abstract School getSchool();
	public void setupDamages() {}
	public void setupResists() {}

	public HashMap<School, Double> getResistances()
	{
		return resistance;
	}

	public HashMap<School, Double> getDamages()
	{
		return damage;
	}
}
