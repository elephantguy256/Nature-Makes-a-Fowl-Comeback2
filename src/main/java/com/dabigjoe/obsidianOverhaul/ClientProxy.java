package com.dabigjoe.obsidianOverhaul;

import com.dabigjoe.obsidianAPI.file.importer.FileLoader;
import com.example.examplemod.EntityChinchilla;
import com.example.examplemod.EntityGuineaPig;
import com.example.examplemod.EntityRingTailedLemur;
import com.example.examplemod.ModelChinchilla;
import com.example.examplemod.ModelGuineaPig;
import com.example.examplemod.ModelRingTailedLemur;
import com.example.examplemod.RenderChinchilla;
import com.example.examplemod.RenderGuineaPig;
import com.example.examplemod.RenderRingTailedLemur;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy {

	private ResourceLocation saigaModel = new ResourceLocation("de:models/ringtailedlemur.obm");
	private ResourceLocation saigaTexture1 = new ResourceLocation("de:textures/entity/preyanimal/ringtailedlemur.png");    private ResourceLocation saigaTexture = new ResourceLocation("mod_api_tutorial:models/Saiga.png");

    public void registerRendering() {
    	RenderManager renderManager = Minecraft.getMinecraft().getRenderManager();
        RenderingRegistry.registerEntityRenderingHandler(EntityChinchilla.class, new RenderChinchilla(renderManager, new ModelChinchilla(), 0.5F)); 
        RenderingRegistry.registerEntityRenderingHandler(EntityGuineaPig.class, new RenderGuineaPig(renderManager, new ModelGuineaPig(), 0.5F)); 
        ModelRingTailedLemur modelSaiga = FileLoader.loadModelFromResources("saiga", saigaModel, saigaTexture1, ModelRingTailedLemur.class);
        modelSaiga.setModelScale(0.6F);
        RenderRingTailedLemur saigaRenderer = new RenderRingTailedLemur(modelSaiga);
        RenderingRegistry.registerEntityRenderingHandler(EntityRingTailedLemur.class, saigaRenderer);
    }
}