package com.tutorial.seabass.tutorialmod;

/*
 * This is an example mod with lots of annotations as I cement the thoughts in my head.
 */

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;

@Mod( modid = MyMod.MODID, version = MyMod.VERSION, name = MyMod.MODNAME )
public class MyMod {
	/*
	 * MODID must be all lowercase.  If you don't make it all lowercase, cats will spawn halfbreeds with dogs,
	 * furries will become acceptable citizens of the wider fandom world,
	 * satan will become mother teresa, and also none of your textures will work.
	 */
	public static final String MODID = "seabassmymod";
	public static final String VERSION = "in_development";
	public static final String MODNAME = "MyMod - Sea Bass Tutorial Mod";
	
	/*
	 * First we have the static things that are used to hold all our singletons.
	 * That way, we can just do things like MyMod.blockTest == someBlockIHave, etc.
	 * Or as with the BlockTest's constructor, this.setCreativeTab( MyMod.tabMyMod );
	 */
	public static Block blockTest;
	
	public static CreativeTabs tabMyMod = new CreativeTabsMyMod( "MyMod" );
	
	/*
	 * Mod init code!
	 * Or pre-init, as it were.  For MC 1.7, Forge requires you to register your blocks
	 * in the Pre-Initialization stage.  For details on all the events, look at the
	 * javadoc for @EventHandler.  Note that it has /suggestions/ on what you do
	 * at each event, but I have heard that you cannot register blocks after pre-init.
	 */
	@EventHandler
	public void preInit( FMLPreInitializationEvent event ) {
		blockTest = new BlockTest().setBlockName( BlockTest.NAME );
		GameRegistry.registerBlock( blockTest, blockTest.getUnlocalizedName() );
	}
}
