package com.tutorial.seabass.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTest extends Block {
	/*
	 * Same thing pretty much as the mod's name.  This shouldn't change after you initially write the class,
	 * but this will make refactoring easier. (Plus unnamed constants/magic values are lame anyway.)
	 */
	public static final String NAME = "blockTest";
	
	/*
	 * The constructor is protected so that other mods cannot instantiate the block directly,
	 * but subclasses of that block can still access their super().  Since the class itself is public,
	 * other packages can still extend it.  This helps enforce keeping blocks (and other stuff) as singletons.
	 * 
	 * Note that if you look at Minecraft's own blocks, they're set up with protected constructors, too.
	 * 
	 * Other mods that want to interact with your mod's blocks should reference the singleton attached to
	 * the mod's base class.  (MyMod in this case.)  Because, you know, that's how it's done everywhere else.
	 */
	protected BlockTest() {
		super( Material.ground );
		this.setCreativeTab( MyMod.tabMyMod );
		
		/*
		 * If your block has only a simple texture, then this is all you need to do.
		 * If you have different textures for different sides, though, then it's a bit more involved...
		 * The texture referenced here will be at /resources/assets/<mod id>/textures/blocks/<block name>.png
		 * where <block name> is the part after the ":" in the block texture name below.
		 */
		this.setBlockTextureName( MyMod.MODID + ":" + BlockTest.NAME );
	}
}
