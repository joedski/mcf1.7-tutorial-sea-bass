package com.tutorial.seabass.tutorialmod;

import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/*
 * This is a simple class which extends EntityTest and uses advanced AI instead of simple default AI.
 */

public class EntityTestWithAI extends EntityTest {
	public static final String NAME = "entityTestWithAI";
	
	public EntityTestWithAI( World world ) {
		super( world );
		
		this.initAI( world );
	}
	
	public void initAI( World world ) {
		// Lower numbers are higher priority.
		// Here, we want swimming to be top priority, because drowning kinda sucks.
		// However, you could make a mob where it doesn't care about drowning as much as it does
		// attacking the player.
		this.tasks.addTask( 1, new EntityAISwimming( this ) );
		// Attack the player by bumping awkwardly into them.
		// Well, rather more "attack /when/ bumping awkwardly into them."
		this.tasks.addTask( 2, new EntityAIAttackOnCollide( this, EntityPlayer.class, 1.2D, false ) );
		// If we have nothing to attack, just wander around.
		this.tasks.addTask( 3, new EntityAIWander( this, 1.0D ) );
		// If there's a player near by, sometimes stare at them. o_o
		this.tasks.addTask( 4, new EntityAIWatchClosest( this, EntityPlayer.class, 8.0F ) );
		// Lowest priority - Stand around staring at random things.
		this.tasks.addTask( 5, new EntityAILookIdle( this ) );
		
		// Target the last thing that hurt it.
		this.targetTasks.addTask( 1, new EntityAIHurtByTarget( this, false ) );
		// Target near by players if there's nothing else that's hurt it.
		this.targetTasks.addTask( 2, new EntityAINearestAttackableTarget( this, EntityPlayer.class, 0, true ) );
		
		/*
		 * Congratulations!  You now have a shiny new ordinary vanilla mob!
		 */
	}
	
	@Override
	public boolean isAIEnabled() {
		return true;
	}
}
