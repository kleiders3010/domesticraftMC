
package com.kleiders.domesticraft.client.renderer;

import net.minecraft.client.renderer.entity.EntityRendererProvider;

import com.kleiders.domesticraft.entity.LabradorEntity;
import com.kleiders.domesticraft.client.LabradorModel;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Vector3f;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.ItemTransforms.TransformType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import software.bernie.geckolib3.geo.render.built.GeoBone;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.client.renderer.MultiBufferSource.BufferSource;





public class LabradorRenderer extends GeoEntityRenderer<LabradorEntity> {
    private ItemStack itemStack;
	
	public LabradorRenderer(EntityRendererProvider.Context context) {
		super(context, new LabradorModel());
		this.shadowRadius = 0.5f;
	}

		@Override
	public RenderType getRenderType(LabradorEntity animatable, float partialTicks, PoseStack stack,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn,
			ResourceLocation textureLocation) {
		return RenderType.entityTranslucent(getTextureLocation(animatable));
	}
	
	@Override
	public void renderEarly(LabradorEntity animatable, PoseStack stackIn, float ticks,
			MultiBufferSource renderTypeBuffer, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn,
			float red, float green, float blue, float partialTicks) {
		this.rtb = renderTypeBuffer;
		this.whTexture = this.getTextureLocation(animatable);
	     this.itemStack = animatable.getItemBySlot(EquipmentSlot.MAINHAND);
	     		super.renderEarly(animatable, stackIn, ticks, renderTypeBuffer, vertexBuilder, packedLightIn, packedOverlayIn,
				red, green, blue, partialTicks);
	}
/*	
    @Override
    public void renderEarly(LabradorEntity ratEntity, PoseStack stackIn, float ticks, MultiBufferSource vertexConsumerProvider, VertexConsumer vertexBuilder, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float partialTicks) {
        this.itemStack = ratEntity.getItemBySlot(EquipmentSlot.MAINHAND);

        super.renderEarly(ratEntity, stackIn, ticks, vertexConsumerProvider, vertexBuilder, packedLightIn, packedOverlayIn, red,
                green, blue, partialTicks);
    }
 */       


   	@Override
	public void renderRecursively(GeoBone bone, PoseStack stack, VertexConsumer bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
		if (bone.getName().equals("helder")) { // rArmRuff is the name of the bone you to set the item to attach too. Please see Note
			stack.pushPose();
            // You'll need to play around with these to get item to render in the correct orientation
			stack.mulPose(Vector3f.XP.rotationDegrees(0)); 
			stack.mulPose(Vector3f.YP.rotationDegrees(0)); 
			stack.mulPose(Vector3f.ZP.rotationDegrees(90));
            // You'll need to play around with this to render the item in the correct spot.
			stack.translate(0.8D, -0.2D, -0.75D); 
            // Sets the scaling of the item.
			stack.scale(0.65f, 0.65f, 0.65f); 
            // Change mainHand to predefined Itemstack and TransformType to what transform you would want to use.
				Minecraft.getInstance().getItemRenderer().renderStatic(itemStack, TransformType.THIRD_PERSON_RIGHT_HAND,
					packedLightIn, packedOverlayIn, stack, this.rtb, 0);
			stack.popPose();
			bufferIn = rtb.getBuffer(RenderType.entityTranslucent(whTexture));
		}
		super.renderRecursively(bone, stack, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
	}

}
