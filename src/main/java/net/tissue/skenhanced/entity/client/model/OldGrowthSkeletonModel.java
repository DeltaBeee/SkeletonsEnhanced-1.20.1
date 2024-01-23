package net.tissue.skenhanced.entity.client.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.OldGrowthSkeleton;
import software.bernie.geckolib.model.GeoModel;


public class OldGrowthSkeletonModel extends GeoModel<OldGrowthSkeleton> {




    @Override
    public ResourceLocation getModelResource(OldGrowthSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/old_growth_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(OldGrowthSkeleton skeleton) {

            return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/oldgrowthskeleton/old_growth_skeleton_ghost_"
                    + skeleton.getVariant().getId()+ "_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(OldGrowthSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/old_growth_skeleton.animation.json");
    }
}
