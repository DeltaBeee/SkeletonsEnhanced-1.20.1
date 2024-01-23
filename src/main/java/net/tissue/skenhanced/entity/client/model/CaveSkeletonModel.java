package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.CaveSkeleton;
import net.tissue.skenhanced.entity.skeletons.HoneySkeleton;
import software.bernie.geckolib.model.GeoModel;

public class CaveSkeletonModel extends GeoModel<CaveSkeleton> {

    @Override
    public ResourceLocation getModelResource(CaveSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/cave_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(CaveSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/cave_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(CaveSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/honey_skeleton.animation.json");
    }
}
