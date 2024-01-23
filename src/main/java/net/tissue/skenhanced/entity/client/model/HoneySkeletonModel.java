package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.HoneySkeleton;
import software.bernie.geckolib.model.GeoModel;

public class HoneySkeletonModel extends GeoModel<HoneySkeleton> {

    @Override
    public ResourceLocation getModelResource(HoneySkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/honey_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(HoneySkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/honey_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(HoneySkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/honey_skeleton.animation.json");
    }
}
