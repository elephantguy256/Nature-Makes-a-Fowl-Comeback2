package com.dabigjoe.obsidianOverhaul;

import com.dabigjoe.obsidianAPI.ObsidianAPIUtil;
import com.dabigjoe.obsidianAPI.animation.wrapper.AIAnimationWrapper;
import com.dabigjoe.obsidianAPI.animation.wrapper.FunctionAnimationWrapper.IsActiveFunction;
import com.dabigjoe.obsidianAPI.registry.AnimationRegistry;
import com.dabigjoe.obsidianOverhaul.entity.ai.EntityAIEat;
import com.dabigjoe.obsidianOverhaul.entity.ai.EntityAIPanicAnimation;
import com.dabigjoe.obsidianOverhaul.entity.ai.EntityOnShoulder;
import com.example.examplemod.EntityGuineaPig;
import com.example.examplemod.EntityRingTailedLemur;
import com.example.examplemod.SoundEvents2;

import net.minecraft.util.ResourceLocation;

public class CommonProxy
{	
	public void init() 
	{	
		ModEntities.registerEntities();
		registerRendering();
		SoundEvents2.registerSounds();
	}

	public void registerRendering() {}

	public void registerAnimations() 
	{
		AnimationRegistry.init();
		
		IsActiveFunction isWalking = (entity) -> { 
			return ObsidianAPIUtil.isEntityMoving(entity) && !entity.isSprinting() && !entity.isSneaking() && entity.onGround;
		};
		IsActiveFunction returnTrue = (entity) -> { 
			return true;
		};
		IsActiveFunction isCalling = (entity) -> { 
			return entity instanceof EntityRingTailedLemur ? ((EntityRingTailedLemur) entity).isCalling() : false;
		};
		
		AnimationRegistry.registerEntity(EntityRingTailedLemur.class, "saiga");
		AnimationRegistry.registerAnimation("saiga", "Walk", new ResourceLocation("de:animations/ringtailedlemur_walk.oba"), 10, true, isWalking);
		AnimationRegistry.registerAnimation("saiga", "Eat", new AIAnimationWrapper(EntityAIEat.name, new ResourceLocation("de:animations/ringtailedlemur_idle.oba"), 50, true, 0.5F));
		AnimationRegistry.registerAnimation("saiga", "Panic", new AIAnimationWrapper(EntityAIPanicAnimation.name, new ResourceLocation("de:animations/ringtailedlemur_run3.oba"), 0, true));
		AnimationRegistry.registerAnimation("saiga", "Sitting", new ResourceLocation(EntityOnShoulder.name, "de:animations/ringtailedlemur_sit.oba"), 70, false, returnTrue);
		AnimationRegistry.registerAnimation("saiga", "Idle", new ResourceLocation("de:animationsringtailedlemur_idle.oba"), 100, true, returnTrue);
	}

}
