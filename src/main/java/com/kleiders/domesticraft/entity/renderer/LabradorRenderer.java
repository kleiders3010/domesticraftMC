
package com.kleiders.domesticraft.entity.renderer;

import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.util.ResourceLocation;
import net.minecraft.entity.Entity;
import net.minecraft.client.renderer.entity.model.OcelotModel;
import net.minecraft.client.renderer.entity.MobRenderer;

import com.kleiders.domesticraft.entity.LabradorEntity;

@OnlyIn(Dist.CLIENT)
public class LabradorRenderer {
	public static class ModelRegisterHandler {
		@SubscribeEvent
		@OnlyIn(Dist.CLIENT)
		public void registerModels(ModelRegistryEvent event) {
			RenderingRegistry.registerEntityRenderingHandler(LabradorEntity.entity,
					renderManager -> new MobRenderer(renderManager, new OcelotModel(0), 0.3f) {

						@Override
						public ResourceLocation getEntityTexture(Entity entity) {
							return new ResourceLocation("domesticraft:textures/labrador.png");
						}
					});
		}
	}
}
