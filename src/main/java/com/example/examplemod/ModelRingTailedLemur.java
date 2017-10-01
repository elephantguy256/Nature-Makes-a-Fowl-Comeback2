package com.example.examplemod;

import com.dabigjoe.obsidianAPI.render.ModelAnimated;
import com.dabigjoe.obsidianAPI.render.wavefront.WavefrontObject;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class ModelRingTailedLemur extends ModelAnimated {

	public ModelRingTailedLemur(String entityName, WavefrontObject wavefrontObj, ResourceLocation textureLocation) {
		super(entityName, wavefrontObj, textureLocation);
	}
	
	@Override
    public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
		super.render(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
    }

	@Override
	public void setRotationAngles(float swingTime, float swingMax, float clock, float lookX, float lookY, float f5,
			Entity entity) {
		super.setRotationAngles(swingTime, swingMax, clock, lookX, lookY, f5, entity);
		
//		EntityAnimationPropertiesClient animProps = EntityAnimationPropertiesClient.get(entity);
//		if (animProps == null)
//			GuiDebug.instance.animationText = "null";
//		else
//		{
//			AnimationSequence seq = animProps.getActiveAnimation();
//			if (seq == null)
//				GuiDebug.instance.animationText = "null";
//			else
//				GuiDebug.instance.animationText = seq.getName();
//		}		
	}

}
