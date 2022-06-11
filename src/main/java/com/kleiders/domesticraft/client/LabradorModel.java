package com.kleiders.domesticraft.client;

import com.kleiders.domesticraft.DomesticraftMod;
import com.kleiders.domesticraft.entity.LabradorEntity;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class LabradorModel extends AnimatedGeoModel<LabradorEntity> {
    @Override
    public ResourceLocation getModelLocation(LabradorEntity object) {
        return new ResourceLocation("domesticraft", "geo/labrador.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(LabradorEntity object) {
        return new ResourceLocation("domesticraft", "textures/labrador.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(LabradorEntity animatable) {
        return new ResourceLocation("domesticraft", "animations/labrador.animation.json");
    }
}
