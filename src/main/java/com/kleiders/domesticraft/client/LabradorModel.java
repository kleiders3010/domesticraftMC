package com.kleiders.domesticraft.client;

import software.bernie.geckolib3.model.AnimatedGeoModel;

import com.kleiders.domesticraft.DomesticraftMod;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;

import software.bernie.geckolib3.GeckoLib;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.processor.IBone;
import software.bernie.geckolib3.model.AnimatedTickingGeoModel;
import software.bernie.geckolib3.model.provider.data.EntityModelData;
import net.minecraft.world.entity.LivingEntity;

import com.kleiders.domesticraft.entity.LabradorEntity;


public class LabradorModel extends AnimatedGeoModel<LabradorEntity> {
    @Override
    public ResourceLocation getModelLocation(LabradorEntity object) {
        return new ResourceLocation(DomesticraftMod.MODID, "geo/labrador.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LabradorEntity object) {
        return new ResourceLocation(DomesticraftMod.MODID, "textures/labrador.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LabradorEntity animatable) {
        return new ResourceLocation(DomesticraftMod.MODID, "animations/labrador.animation.json");
    }
@SuppressWarnings({ "unchecked", "unused", "rawtypes" })
    @Override
    public void setLivingAnimations(LabradorEntity entity, Integer uniqueID, AnimationEvent customPredicate) {
        super.setLivingAnimations(entity, uniqueID, customPredicate);
        IBone head = this.getAnimationProcessor().getBone("head");

        LivingEntity entityIn = (LivingEntity) entity;
        EntityModelData extraData = (EntityModelData) customPredicate.getExtraDataOfType(EntityModelData.class).get(0);
        head.setRotationX(extraData.headPitch * ((float) Math.PI / 180F));
        head.setRotationY(extraData.netHeadYaw * ((float) Math.PI / 180F));
    }
}
