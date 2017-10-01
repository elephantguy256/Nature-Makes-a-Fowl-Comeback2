package com.example.examplemod;

import com.dabigjoe.obsidianAPI.render.RenderAnimated;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;



public class RenderRingTailedLemur extends RenderAnimated
{
	public RenderRingTailedLemur(ModelRingTailedLemur saiga)
	{
		super(saiga, 0.8F);
	}
}