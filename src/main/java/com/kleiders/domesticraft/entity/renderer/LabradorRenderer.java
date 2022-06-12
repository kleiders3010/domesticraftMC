
package com.kleiders.domesticraft.entity.renderer;

import com.kleiders.domesticraft.entity.LabradorEntity;
import com.kleiders.domesticraft.client.LabradorModel;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import net.minecraft.entity.Entity;

public class LabradorRenderer extends GeoEntityRenderer<LabradorEntity> {
	public LabradorRenderer(EntityRendererManager renderManager) {
		super(renderManager, new LabradorModel());
	}
	
    @Override
    public ResourceLocation getEntityTexture(LabradorEntity entity) {
        return null;
    }
}