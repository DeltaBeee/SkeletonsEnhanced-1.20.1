package net.tissue.skenhanced.entity.client.gecko.model;

import net.minecraft.resources.ResourceLocation;
import net.tissue.skenhanced.SkEnhanced;
import net.tissue.skenhanced.entity.skeletons.IceSpikesSkeleton;
import net.tissue.skenhanced.entity.skeletons.gecko.GeoIceSpikesSkeleton;
import software.bernie.geckolib.model.GeoModel;

public class GeoIceSpikesSkeletonModel extends GeoModel<IceSpikesSkeleton> {

    @Override
    public ResourceLocation getModelResource(IceSpikesSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "geo/ice_spikes_skeleton.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(IceSpikesSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "textures/entity/ice_spikes_skeleton_texture.png");
    }

    @Override
    public ResourceLocation getAnimationResource(IceSpikesSkeleton animatable) {
        return new ResourceLocation(SkEnhanced.MOD_ID, "animations/ice_spike_skeleton.animation.json");
    }
}
