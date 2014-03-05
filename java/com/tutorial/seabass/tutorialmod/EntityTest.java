package com.tutorial.seabass.tutorialmod;

import net.minecraft.entity.monster.EntityMob;
import net.minecraft.world.World;

/*
 * A barebones monster.
 */
public class EntityTest extends EntityMob {
	public static final String NAME = "entityTest";
	
	public EntityTest( World world ) {
		super( world );
	}
}
