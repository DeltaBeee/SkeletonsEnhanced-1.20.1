package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.JungleSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class JungleSkeletonModel extends GeoModel<JungleSkeleton> {

    @Override
    public ResourceLocation getModelResource(JungleSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/jungle_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(JungleSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/jungle_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(JungleSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/skeleton.animation.json");
    }
}