package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.OceanSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class OceanSkeletonModel extends GeoModel<OceanSkeleton> {

    @Override
    public ResourceLocation getModelResource(OceanSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/ocean_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OceanSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/ocean_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OceanSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/ocean_skeleton.animation.json");
    }
}
