package com.tutorial.seabass.tutorialmod;

/*
 * This is an example mod with lots of annotations as I cement the thoughts in my head.
 */

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
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
	
	@Instance( MODID )
	public static MyMod instance;
	
	/*
	 * First we have the static things that are used to hold all our singletons.
	 * That way, we can just do things like MyMod.blockTest == someBlockIHave, etc.
	 * Or as with the BlockTest's constructor, this.setCreativeTab( MyMod.tabMyMod );
	 */
	public static Block blockTest;
	public static Block blockTestSided;
	
	public static Item itemTest;
	
	public static CreativeTabs tabMyMod = new CreativeTabsMyMod( "MyMod" );

	/*
	 * Utility method to make registering entities less annoying.
	 * 
	 * I don't know why this is static.  I don't think it matters, though.
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public static void registerEntity( Class entityClass, String name ) {
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		long seed = name.hashCode();
		Random rand = new Random( seed );
		int primaryEggColor = rand.nextInt() * 0xFFFFFF; // 0xffffff is RGB 255,255,255...
		int secondaryEggColor = rand.nextInt() * 0xFFFFFF;
		
		EntityRegistry.registerGlobalEntityID( entityClass, name, entityID );
		EntityRegistry.registerModEntity( entityClass, name, entityID, instance, 64, 1, true ); // long range, eh?
		EntityList.entityEggs.put(
				Integer.valueOf( entityID ),
				new EntityList.EntityEggInfo( entityID, primaryEggColor, secondaryEggColor ) );
	}
	
	/*
	 * Mod init code!
	 * Or pre-init, as it were.  For MC 1.7, Forge requires you to register your blocks
	 * in the Pre-Initialization stage.  For details on all the events, look at the
	 * javadoc for @EventHandler.  Note that it has /suggestions/ on what you do
	 * at each event, but I have heard that you cannot register blocks after pre-init.
	 * 
	 * I put the block inits and the item init into separate methods, because that's how I roll.
	 * Also, when making lengthy constructors with lots of blocks, this helps me keep things organized.
	 */
	@EventHandler
	public void preInit( FMLPreInitializationEvent event ) {
		this.initBlocks( event );
		this.initItems( event );
		this.initEntities( event );
	}
	
	public void initBlocks( FMLPreInitializationEvent event ) {
		blockTest = new BlockTest().setBlockName( BlockTest.NAME );
		GameRegistry.registerBlock( blockTest, BlockTest.NAME );
		
		blockTestSided = new BlockTestSided().setBlockName( BlockTestSided.NAME );
		GameRegistry.registerBlock( blockTestSided, BlockTestSided.NAME );
	}
	
	public void initItems( FMLPreInitializationEvent event ) {
		/*
		 * I moved the call to setTextureName() from here to ItemTest's constructor,
		 * because it's more consistent with how BlockTest is written and I get twitchy
		 * if they don't match.
		 */
		itemTest = new ItemTest().setUnlocalizedName( ItemTest.NAME );
		GameRegistry.registerItem( itemTest, ItemTest.NAME );
	}
	
	public void initEntities( FMLPreInitializationEvent event ) {
		registerEntity( EntityTest.class, EntityTest.NAME );
	}
}
