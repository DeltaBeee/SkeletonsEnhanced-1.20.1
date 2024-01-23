package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.CrimsonSkeleton;
import net.tissue.skenhanced.entity.skeletons.WarpedSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class WarpedSkeletonModel extends GeoModel<WarpedSkeleton> {

    @Override
    public ResourceLocation getModelResource(WarpedSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/warped_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(WarpedSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/warped_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(WarpedSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/skeleton.animation.json");
    }
}
