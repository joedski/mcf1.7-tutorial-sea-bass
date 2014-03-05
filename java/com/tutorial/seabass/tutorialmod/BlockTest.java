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
	 * The constructor is protected so that other mods cannot instantiate the block directly.
	 * I'm not sure if this is how it should be or not.  What if someone wants to make an addon-mod?
	 * Their code should not be in my package namespace, but if the block is not accessable, then
	 * how do they use this block?
	 * 
	 * Is it better to make this protected or public by default?
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
