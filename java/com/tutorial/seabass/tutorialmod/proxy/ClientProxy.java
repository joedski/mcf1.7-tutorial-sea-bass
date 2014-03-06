package com.tutorial.seabass.tutorialmod.proxy;

import net.minecraft.client.model.ModelBiped;

import com.tutorial.seabass.tutorialmod.EntityTest;
import com.tutorial.seabass.tutorialmod.RenderTest;

import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {
	@Override
	public void registerRenderers() {
		RenderingRegistry.registerEntityRenderingHandler(
				EntityTest.class,
				new RenderTest( new ModelBiped(), 0.5F ) );
	}
}
