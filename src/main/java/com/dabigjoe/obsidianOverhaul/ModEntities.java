package com.dabigjoe.obsidianOverhaul;

import java.util.Random;

import com.example.examplemod.EntityChinchilla;
import com.example.examplemod.EntityGuineaPig;
import com.example.examplemod.EntityRingTailedLemur;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ModEntities 
{
	
	private static int id = 1;

	public static void registerEntities()
	{
		registerEntity(EntityChinchilla.class, "Chinchilla");
		registerEntity(EntityGuineaPig.class, "Guinea Pig");
		registerEntity(EntityRingTailedLemur.class, "Ring Tailed Lemur");
	}

	public static void registerEntity(Class entityClass, String name)
	{
		long seed = name.hashCode();
		Random rand = new Random(seed);
		int primaryColor = rand.nextInt() * 16777215;
		int secondaryColor = rand.nextInt() * 16777215;
        EntityRegistry.registerModEntity(new ResourceLocation(ObsidianOverhaul.MODID, name), entityClass, name, id++, ObsidianOverhaul.instance, 64, 3, true, primaryColor, secondaryColor);
	}

}
