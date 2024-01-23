package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.MushroomSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class MushroomSkeletonModel extends GeoModel<MushroomSkeleton> {

    @Override
    public ResourceLocation getModelResource(MushroomSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/mushroom_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(MushroomSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/mushroom_skeleton.png");
    }

    @Override
    public ResourceLocation getAnimationResource(MushroomSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/skeleton.animation.json");
    }
}
