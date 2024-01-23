package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.FarmSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class FarmSkeletonModel extends GeoModel<FarmSkeleton> {
    @Override
    public ResourceLocation getModelResource(FarmSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/farm_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(FarmSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/farm_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(FarmSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/skeleton.animation.json");
    }
}
