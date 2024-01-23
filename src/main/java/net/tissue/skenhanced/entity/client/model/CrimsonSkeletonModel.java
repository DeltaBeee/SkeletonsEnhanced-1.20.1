package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.CrimsonSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class CrimsonSkeletonModel extends GeoModel<CrimsonSkeleton> {

    @Override
    public ResourceLocation getModelResource(CrimsonSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/crimson_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CrimsonSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/crimson_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CrimsonSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/skeleton.animation.json");
    }
}
