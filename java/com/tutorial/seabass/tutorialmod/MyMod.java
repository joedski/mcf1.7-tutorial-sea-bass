package com.tutorial.seabass.tutorialmod;

/*
 * This is an example mod with lots of annotations as I cement the thoughts in my head.
 */

import java.lang.reflect.Field;
import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityList;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import com.tutorial.seabass.tutorialmod.proxy.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
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
	
	@SidedProxy( clientSide = "com.tutorial.seabass.tutorialmod.proxy.ClientProxy",
			serverSide = "com.tutorial.seabass.tutorialmod.proxy.CommonProxy" )
	public static CommonProxy proxy;
	
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
	 * Reflection!  This is so much easier in interpreted languages.
	 * It's probably just as easy in either case to shoot yourself in the foot, though.
	 * 
	 * This method first tries to get the static "NAME" field, then failing that uses the class's name.
	 * This can only get no name if you create anonymous classes.  Which is possible.
	 */
	public static String getThingName( Class<?> thingClass ) {
		Field nameField;
		String name = null;
		
		try {
			nameField = thingClass.getField( "NAME" );
		}
		catch( SecurityException e ) {
			e.printStackTrace();
			nameField = null;
		}
		catch( NoSuchFieldException e ) {
			e.printStackTrace();
			nameField = null;
		}
		
		if( nameField != null ) {
			try {
				name = (String) nameField.get( null );
			}
			catch( IllegalArgumentException e ) {
				e.printStackTrace();
				nameField = null;
			}
			catch( IllegalAccessException e ) {
				e.printStackTrace();
				nameField = null;
			}
		}
		
		if( nameField == null ) {
			name = thingClass.getSimpleName();
		}
		
		return name;
	}

	/*
	 * Utility method to make registering entities less annoying.
	 * 
	 * I don't know why this is static.  I don't think it matters, though.
	 */
	@SuppressWarnings( { "rawtypes", "unchecked" } )
	public static void registerEntity( Class entityClass ) {
		String name = getThingName( entityClass );
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
	
	public static Block registerBlock( Class<? extends Block> blockClass ) throws InstantiationException, IllegalAccessException {
		String name;
		Block block = null;
		block = blockClass.newInstance();
		name = getThingName( blockClass );
		block.setBlockName( name );
		GameRegistry.registerBlock( block, name );
		
		return block;
	}

	public static Item registerItem( Class<? extends Item> itemClass ) throws InstantiationException, IllegalAccessException {
		String name;
		Item item = null;
		item = itemClass.newInstance();
		name = getThingName( itemClass );
		item.setUnlocalizedName( name );
		GameRegistry.registerItem( item, name );
		
		return item;
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
	public void preInit( FMLPreInitializationEvent event ) throws InstantiationException, IllegalAccessException {
		this.initBlocks( event );
		this.initItems( event );
		this.initEntities( event );
		
		proxy.registerRenderers();
	}
	
	/*
	 * Added reflection to get the names from the class objects since I myself am doing that as a standard thing.
	 * The real question is, do I handle the exceptions here?  Do I handle just a few?
	 */
	public void initBlocks( FMLPreInitializationEvent event ) throws InstantiationException, IllegalAccessException {
		blockTest = registerBlock( BlockTest.class );
		blockTestSided = registerBlock( BlockTestSided.class );
	}
	
	public void initItems( FMLPreInitializationEvent event ) throws InstantiationException, IllegalAccessException {
		/*
		 * I moved the call to setTextureName() from here to ItemTest's constructor,
		 * because it's more consistent with how BlockTest is written and I get twitchy
		 * if they don't match.
		 */
		itemTest = registerItem( ItemTest.class );
	}
	
	public void initEntities( FMLPreInitializationEvent event ) throws InstantiationException, IllegalAccessException {
		registerEntity( EntityTest.class );
		registerEntity( EntityTestWithAI.class );
	}
	
	/*
	 * Init-time init code!
	 * 
	 * By this time, all items and blocks are supposed to be initialized.
	 */
	@EventHandler
	public void init( FMLInitializationEvent event ) {
		this.initRecipes( event );
	}
	
	public void initRecipes( FMLInitializationEvent event ) {
		GameRegistry.addShapedRecipe( new ItemStack( MyMod.itemTest, 2 ),
				"ddd",
				" d ",
				" d ",
				'd', Blocks.dirt );
		
		GameRegistry.addShapedRecipe( new ItemStack( MyMod.blockTest, 1 ),
				"tt",
				"tt",
				't', MyMod.itemTest );
		
		GameRegistry.addShapelessRecipe( new ItemStack( MyMod.blockTestSided, 2 ),
				MyMod.blockTest, MyMod.blockTest );
	}
}
