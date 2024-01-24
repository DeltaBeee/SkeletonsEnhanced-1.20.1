package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.DesertSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class DesertSkeletonModel extends GeoModel<DesertSkeleton> {

    @Override
    public ResourceLocation getModelResource(DesertSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/desert_skeleton_" + animatable.isBurrowed()+ ".geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(DesertSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/desert_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(DesertSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/desert_skeleton.animation.json");
    }
}
