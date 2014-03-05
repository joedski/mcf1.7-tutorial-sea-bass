package com.tutorial.seabass.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockTest extends Block {
	/*
	 * Same thing pretty much as the mod's name.  This shouldn't change after you initially write the class,
	 * but this will make refactoring easier. (Plus unnamed constants/magic values are lame anyway.)
	 * 
	 * NOTE: Ideally, this name only shows up in one place anyway, so this shouldn't matter.
	 * Regardless, I like named constants rather than strings.
	 * 
	 * I may go back on this, though.  This does have the disadvantage of spreading the names out
	 * over different files versus having them all in the mod base class. (Also may break some 3rd party utils?)
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
		 * 
		 * NOTE: Many tutorials recommend using #getUnlocalizedName().substring( 5 ) here, which if you didn't know,
		 * takes the value returned by #getUnlocalizedName() (in this case "tile.blockTest") and
		 * lops off the first 5 chars, "tile.".  This seems hacky, so I just use a named constant.
		 * The important thing is that the name you use here matches the name of the texture file on disk.
		 * (besides, what if "tile." becomes "tiles." or "foobarbaz."?!  What if...?! (Don't stress over this
		 * and just pick a way to do it, and STICK WITH IT.))
		 * 
		 * NOTE: static finals are available to the local scopes just like instance properties.
		 */
		this.setBlockTextureName( MyMod.MODID + ":" + NAME );
	}
}
