package com.tutorial.seabass.tutorialmod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class CreativeTabsMyMod extends CreativeTabs {
	
	/*
	 * The most barebones constructor for a creative tab.
	 */
	public CreativeTabsMyMod( String tabLabel ) {
		super( tabLabel );
	}

	/*
	 * This is how we determine the creative tab's icon.
	 * In our case, we're starting with a dirt block as the icon,
	 * since that's what the BlockTest will look like.
	 * @see net.minecraft.creativetab.CreativeTabs#getTabIconItem()
	 */
	@Override
	@SideOnly( Side.CLIENT )
	public Item getTabIconItem() {
		// This gives our tab a dirt block as an icon.
		return Item.getItemFromBlock( Blocks.dirt );
	}

}
