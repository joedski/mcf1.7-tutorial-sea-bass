package com.tutorial.seabass.tutorialmod;

import net.minecraft.item.Item;

public class ItemTest extends Item {
	public static final String NAME = "itemTest";
	
	protected ItemTest() {
		this.setCreativeTab( MyMod.tabMyMod );
		this.setTextureName( MyMod.MODID + ':' + NAME );
	}
}
