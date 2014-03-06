package com.tutorial.seabass.tutorialmod;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderBiped;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderTest extends RenderBiped {
	/*
	 * I changed textures/models/ to textures/entities/ because this seems more correct semantically,
	 * and because that's how it shows up in Minecraft's assets dir.
	 */
	private static final ResourceLocation textureLocation =
			new ResourceLocation( MyMod.MODID + ":" + "textures/entities/entityTest.png" );
	
	public RenderTest( ModelBiped model, float shadowSize ) {
		super( model, shadowSize );
	}
	
	@Override
	protected ResourceLocation getEntityTexture( Entity entity ) {
		return textureLocation;
	}
}
