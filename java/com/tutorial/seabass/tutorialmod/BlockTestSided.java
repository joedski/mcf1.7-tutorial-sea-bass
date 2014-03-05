package com.tutorial.seabass.tutorialmod;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/*
 * This is the same as BlockTest, but instead will have different textures for different sides.
 */

public class BlockTestSided extends Block {
	
	public static final String NAME = "blockTestSided";
	
	/*
	 * Here's where the fun begins.
	 * 
	 * Graphical stuff is a client-side-only thing, so here we tell Forge so.
	 * This way, the server doesn't load any textures it shouldn't. (because it doesn't display them.)
	 */
	@SideOnly( Side.CLIENT )
	protected IIcon blockIcon;
	@SideOnly( Side.CLIENT )
	protected IIcon blockIconTop;
	
	protected BlockTestSided() {
		super( Material.ground );
		this.setCreativeTab( MyMod.tabMyMod );
		
//		This is exactly the same as BlockTest, except there's no call to #setBlockTextureName().
	}

	/*
	 * Always mark your overrides explicitly so that, if an API change occurs and a method's name is altered,
	 * then you'll receive a nice little compile error and can check it out.  Saving yourself from yourself and all that.
	 * 
	 * @see net.minecraft.block.Block#registerBlockIcons(net.minecraft.client.renderer.texture.IIconRegister)
	 */
	@SideOnly( Side.CLIENT )
	@Override
	public void registerBlockIcons( IIconRegister iconRegister ) {
		// see BlockTest's constructor for why I used BlockTest.NAME instead of this.getLocalizedName().
		// Also, since I'm reusing BlockTest's textures, I need to use BlockTest's name...
		blockIcon = iconRegister.registerIcon( MyMod.MODID + ":" + BlockTest.NAME );
		blockIconTop = iconRegister.registerIcon( MyMod.MODID + ":" + BlockTest.NAME + "Top" );
	}

	/*
	 * You could use a bit of testing, tracing out the values (or using a debugger if you are teh r34l pr0gr4mm0rz)
	 * to figure out what those ints are, or you could just read ahead.  I recommend doing one, followed by the other,
	 * if you're still learning programming.
	 * 
	 * The metadata/damage value is obvious, but the lack of named constants for the side ints is kind of annoying.
	 * @see net.minecraft.block.Block#getIcon(int, int)
	 */
	@SideOnly( Side.CLIENT )
	@Override
	public IIcon getIcon( int side, int metadata ) {
		if( side == 1 )
			return blockIconTop;
		else
			return blockIcon;
	}
}
