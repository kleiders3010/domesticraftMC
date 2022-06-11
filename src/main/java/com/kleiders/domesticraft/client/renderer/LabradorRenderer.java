
package com.kleiders.domesticraft.client.renderer;

import com.kleiders.domesticraft.entity.LabradorEntity;
import com.kleiders.domesticraft.client.LabradorModel;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import software.bernie.geckolib3.model.AnimatedGeoModel;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;

public class LabradorRenderer extends GeoEntityRenderer<LabradorEntity> {
    public LabradorRenderer(EntityRendererManager renderManager) {
        super(renderManager, new LabradorModel());
        this.shadowSize = 0.5f;
    }
}