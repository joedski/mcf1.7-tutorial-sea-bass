package com.tutorial.seabass.tutorialmod;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

/*
 * A bare-bones monster.
 * 
 * This monster doesn't do anything, really, just sorta loafs around until you come by.
 * This uses the basic EntityMob AI, but doesn't set any custom AI.
 */
public class EntityTest extends EntityMob {
	public static final String NAME = "entityTest";
	
	public EntityTest( World world ) {
		super( world );
	}
	
	/*
	 * Remember that these are all set per-mob, and thus can be different each time!
	 * @see net.minecraft.entity.monster.EntityMob#applyEntityAttributes()
	 */
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		
		this.getEntityAttribute( SharedMonsterAttributes.maxHealth ).setBaseValue( 20.0D );
		this.getEntityAttribute( SharedMonsterAttributes.followRange ).setBaseValue( 32.0D );
		this.getEntityAttribute( SharedMonsterAttributes.knockbackResistance ).setBaseValue( 0.0D );
		this.getEntityAttribute( SharedMonsterAttributes.movementSpeed ).setBaseValue( 0.25D );
		this.getEntityAttribute( SharedMonsterAttributes.attackDamage ).setBaseValue( 2.0D );
	}
}
